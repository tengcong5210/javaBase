package com.java.innerClass;

/**
 * 类InnerMap.java的实现描述：TODO 类实现描述
 * 
 * @author tengcongcong
 * @date 2015年10月17日 上午9:58:22
 * @version 1.0.0
 */
public class InnerMap {

    public final static MyContextClassLoaderLocal MYCONTEXTCLASSLOADERLOCAL = new MyContextClassLoaderLocal() {
                                                                                {
                                                                                    System.out.println("代码块");
                                                                                    defaultPrint();
                                                                                }

                                                                                @Override
                                                                                protected void defaultPrint() {
                                                                                    System.out
                                                                                            .println("InnerMap defultPrint");
                                                                                }

                                                                            };

    public static void main(String[] args) {
        System.out.println("start");
        MYCONTEXTCLASSLOADERLOCAL.defaultPrint();
        System.out.println("end");
    }
}
