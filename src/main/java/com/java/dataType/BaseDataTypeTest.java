package com.java.dataType;

/**
 * java基本数据类型默认值及长度
 * 
 * @author linco lee
 */
public class BaseDataTypeTest {
    private boolean bool;
    private byte    b;   //1字节 =8bit  -128    +127
    private short   s;   //2字节=16bit -2^15   +2^15-1
    private int     i;   //4字节=32bit -2^31   +2^31-1
    private char    c;   //2字节=18bit Unicode 0 Unicode 2^16-1
    private long    l;   //8字节=64bit -2^63   +2^63-1   
    private float   f;   //4字节=32bit IEEE754 IEEE754
    private double  d;   //8字节=64bit IEEE754 IEEE754

    public static void main(String[] args) {
        BaseDataTypeTest vb = new BaseDataTypeTest();
        System.out.println("boolean:" + vb.bool);
        System.out.println("byte:" + vb.b);
        System.out.println("short:" + vb.s);
        System.out.println("int:" + vb.i);
        System.out.println("char:" + vb.c);
        System.out.println("long:" + vb.l);
        System.out.println("float" + vb.f);
        System.out.println("double:" + vb.d);
    }

}
