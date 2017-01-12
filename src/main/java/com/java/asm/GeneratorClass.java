package com.java.asm;

import java.io.File;
import java.io.FileOutputStream;

import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

/**
 * 通过Asm生成类的字节码
 * 
 * @author tengcongcong
 */
public class GeneratorClass {
    public static void main(String[] args) throws Exception {
        //生成一个类只需要ClassWriter组件即可
        ClassWriter cw = new ClassWriter(0);
        //通过visit方法确定类的头部信息
        cw.visit(Opcodes.V1_5, Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT + Opcodes.ACC_INTERFACE,
                "com/java/asm/Comparable", null, "java/lang/Object", new String[] { "com/java/asm/Mesurable" });
        cw.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + Opcodes.ACC_STATIC, "LESS", "I", null, new Integer(-1))
                .visitEnd();
        cw.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + Opcodes.ACC_STATIC, "EQUAL", "I", null, new Integer(0))
                .visitEnd();
        cw.visitField(Opcodes.ACC_PUBLIC + Opcodes.ACC_FINAL + Opcodes.ACC_STATIC, "GREATER", "I", null, new Integer(1))
                .visitEnd();
        //定义方法 
        cw.visitMethod(Opcodes.ACC_PUBLIC + Opcodes.ACC_ABSTRACT, "compareTo", "(Ljava/lang/Object;)I", null, null)
                .visitEnd();
        cw.visitEnd();
        byte[] data = cw.toByteArray();
        File file = new File("D:\\Comparable.class");
        FileOutputStream out = new FileOutputStream(file);
        out.write(data);
        out.close();
    }
}
