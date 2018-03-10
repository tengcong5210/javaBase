package com.java.designPattern.delegate;

public class delegateTest {
    public static void main(String [] args){
        //看上去好像是我们的项目经理在干活
        //但实际干活的人是普通员工
        //这就是典型，干活是我的，功劳是你的
        //spring 中在哪里有用到 委派模式？ 答：在注册IOC容器的时候
        Manager manager=new Manager(new BaseWorkerB());
        manager.doing();
    }
}
