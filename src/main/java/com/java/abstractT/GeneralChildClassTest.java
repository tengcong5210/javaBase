package com.java.abstractT;

/**
 * 子类
 * 
 * @author linco lee
 */
public class GeneralChildClassTest extends GeneralSuperClassTest {
    public void execute() {
        System.out.println("GeneralChildClassTest execute method");
        action();
    }

    @Override
    public void runBiz() {
        System.out.println("GeneralChildClassTest runBiz method");
    }

}
