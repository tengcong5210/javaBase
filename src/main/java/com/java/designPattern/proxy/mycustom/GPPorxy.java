package com.java.designPattern.proxy.mycustom;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * jdk动态代理
 * 生成代理对象的代码
 * @author tengcongcong
 * @create 2017-09-30 16:55
 * @Version 1.0
 **/
public class GPPorxy {

    private static final String ln = "\r\n";
    /**
     * 日志
     */
    private final static Logger LOGGER = LoggerFactory.getLogger(GPPorxy.class);

    public static Object newProxyInstance(GPClassLoader classLoader,Class<?>[] interfaces,GPInvocationHandler h){

        try {
            //1.生成源代码
            String proxySrc=generageSrc(interfaces[0]);

            //2.将生成的源代码输出到磁盘，保存为.java文件
            String filePath=GPPorxy.class.getResource("").getPath();
            File f=new File(filePath+"$Proxy0.java");
            FileWriter fw=new FileWriter(f);
            fw.write(proxySrc);
            fw.flush();
            fw.close();

            //3.编译源代码，并且生成.class文件
            JavaCompiler compiler= ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager=compiler.getStandardFileManager(null,null,null);
            Iterable iterable=manager.getJavaFileObjects(f);

            JavaCompiler.CompilationTask task=compiler.getTask(null,manager,null,null,null,iterable);
            task.call();
            manager.close();
            //4.将class文件中的内容，动态动态加载到JVM中来
            Class proxyClass=classLoader.findClass("$Proxy0");
            //5.返回被被代理后的代理对象。
            Constructor c=proxyClass.getConstructor(GPInvocationHandler.class);
            f.delete();
            return c.newInstance(h);

        }catch (Exception e){
            e.printStackTrace();
            LOGGER.error("生成动态代理异常",e);
        }
        return null;
    }

    private static String generageSrc(Class<?> anInterface) {
        StringBuilder src=new StringBuilder();
        src.append("package com.java.designPattern.proxy.mycustom;").append(ln);
        src.append("import java.lang.reflect.Method;").append(ln);
        src.append("public class $Proxy0 implements ").append(anInterface.getName()).append("{").append(ln);
        //定义代理类的成员变量
        src.append(" GPInvocationHandler h;").append(ln);
        //代理类的有参构造
        src.append(" public $Proxy0(GPInvocationHandler h){").append(ln);
        src.append(" this.h=h;").append(ln);
        src.append("}").append(ln);

        for(Method m:anInterface.getMethods()){
            src.append("public ").append(m.getReturnType().getName()).append(" ").append(m.getName()).append("(){").append(ln);
                src.append(" try{").append(ln);
                src.append(" Method m=").append(anInterface.getName()).append(".class.getMethod(\""+m.getName()+"\",new Class[]{});").append(ln);
                src.append(" this.h.invoke(this,m,null);").append(ln);
                src.append(" }catch(Throwable e){");
                src.append(" e.printStackTrace();");
                src.append("}").append(ln);
            src.append("}").append(ln);
        }

        src.append("}");

        return src.toString();

    }
}
