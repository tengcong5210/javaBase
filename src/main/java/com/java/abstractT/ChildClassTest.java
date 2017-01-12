package com.java.abstractT;

public class ChildClassTest extends AbstractTest {

    @Override
    public void initDependency() {
        System.out.println("ChildClassTest initDependency()");
    }

    public void execute() {
        action();//子类调用父类方法
    }

    /**
     * 
     */
    private void action() {
        // TODO Auto-generated method stub

    }

    @Override
    public void runBiz() {
        System.out.println("子类业务处理runBiz()");
    }

    public static void main(String[] args) {
        ChildClassTest cct = new ChildClassTest();
        cct.execute();
        System.out.println("child main:");

    }

}
