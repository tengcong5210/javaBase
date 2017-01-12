package com.java.collection;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Method;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * 类CollectionReflectDemo.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年10月17日 下午1:29:23
 * @version 1.0.0
 */
public class CollectionReflectDemo {
    //用于判断目录或文件所处的层次
    private static int time = 1;

    @SuppressWarnings("rawtypes")
    public static void reflectCollection() {
        Class collectionClazz = Collection.class;
        Class[] clazzs = collectionClazz.getInterfaces();
        for (Class class1 : clazzs) {
            System.out.println(class1.getName());
        }
        //Class collectionSuperClazz = collectionClazz.getSuperclass(); //当getSuperclass方法返回的是Object类、接口、基本类型或void,则返回Null

        //System.out.println(collectionSuperClazz.getName());
    }

    /**
     * 获取某类的所实现的所有接口和继承的类（注意： 要了解getInterfaces方法和getGenericInterfaces方法的区别）
     */
    @SuppressWarnings("rawtypes")
    public static Class[] getInterfaceTree(Class clazz) {
        if (null == clazz) {
            return null;
        }
        List<Class> detailInterfaces = new ArrayList<Class>();
        Class[] interfaceClass = clazz.getInterfaces();
        detailInterfaces.addAll(Arrays.asList(interfaceClass));
        int index = 0;
        while (index < detailInterfaces.size()) {
            Class tempClazz = detailInterfaces.get(index);
            Class[] childClazz = tempClazz.getInterfaces();
            for (int i = childClazz.length - 1; i >= 0; i--) {
                detailInterfaces.add(index + 1, childClazz[i]);
            }
            index++;
        }
        return (Class[]) detailInterfaces.toArray(new Class[0]);

    }

    @SuppressWarnings("rawtypes")
    public static void printTree(Writer writer, String lineSplitChar) throws IOException {
        Class[] interfaceTree = getInterfaceTree(ArrayList.class);
        for (Class class1 : interfaceTree) {
            writer.write(class1.getName() + lineSplitChar);
        }
    }

    /**
     * 打印某类所继承的类和实现的接口
     * 
     * @param clazz 初始Class
     * @param isInit 是否是第一次调用
     */
    public static void printObjOfInheritEdInterfaceAndClass(Class clazz, boolean isInit) {
        if (null == clazz) {
            return;
        }
        System.out.println("method:" + (clazz.getDeclaredMethods().length == clazz.getMethods().length));
        if (isInit) {
            System.out.println(clazz.getName());
        }
        Class superClazzs = clazz.getSuperclass();//先继承后实现接口，所以要先检查有没有父类
        Class[] interfaceClazzs = clazz.getInterfaces();//实现的接口
        Class[] superClassAndIntefaceS = sortClass(superClazzs, interfaceClazzs);
        for (Class class1 : superClassAndIntefaceS) {
            StringBuffer output = new StringBuffer();
            output.append(getTabs(time));
            output.append(class1.getName());
            System.out.println(output);
            Method[] methods = class1.getMethods();
            for (Method method : methods) {
                //                System.out.println("--" + method.getName());
            }
            if (null != class1.getSuperclass() || class1.getInterfaces().length > 0) {
                time++;
                printObjOfInheritEdInterfaceAndClass(class1, false);
                time--;
            }

        }
    }

    //判断需要加多少 tab的方法
    private static String getTabs(int time) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < time; i++) {
            buffer.append("\t");
        }
        return buffer.toString();
    }

    /**
     * 将父类和接口放到一个数组中
     * 
     * @param superClazzs
     * @param interfaceClazzs
     * @return
     */
    @SuppressWarnings("rawtypes")
    private static Class[] sortClass(Class superClazzs, Class[] interfaceClazzs) {
        if (null == superClazzs && null == interfaceClazzs) {
            return null;
        }
        List<Class> list = new ArrayList<Class>();
        if (null != superClazzs) {
            list.add(superClazzs);
        }
        for (Class class1 : interfaceClazzs) {
            list.add(class1);
        }
        return list.toArray(new Class[list.size()]);
    }

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        printObjOfInheritEdInterfaceAndClass(AbstractCollection.class, true);
    }
}
