package com.java;

import org.junit.Test;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

/**
 * java中引用（强引用，软引用，弱引用，虚引用）
 */
public class ReferenceTest {

    @Test
    public void testSoftReference()throws Exception{
        //软引用
        String str="张三";
        SoftReference<String> sf=new SoftReference<String>(str);
        str=null;
        String strSf=sf.get();
        System.out.println("strSf:"+strSf);
        System.out.println(str==strSf);
        System.out.println("==============================");
    }

    @Test
    public void testWeakReference()throws Exception{
        //弱引用
        String wstr="张三";
        WeakReference<String> wsf=new WeakReference<String>(wstr);
        //wstr=null;
        String wstrSf=wsf.get();
        wsf.isEnqueued();
        System.out.println("strSf:"+wstrSf);
        System.out.println(wstr==wstrSf);
        System.out.println("==============================");
    }

    @Test
    public void testPhantomReference()throws Exception{
        //虚引用
        String wstr="张三";
        PhantomReference<String> wsf=new PhantomReference<String>(wstr,null);
        //wstr=null;
        String wstrSf=wsf.get();//永远返回null
        wsf.isEnqueued();
        System.out.println("strSf:"+wstrSf);
        System.out.println(wstr==wstrSf);
        System.out.println("==============================");
    }
}
