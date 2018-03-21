package com.java.designPattern.delegate;

/**
 * 经理工作
 * 一般经理 的任务就是 分配给下面的人去做。
 */
public class Manager implements Worker {
    private Worker worker;
    public Manager(Worker worker){
        this.worker=worker;
    }
    public void doing() {
        worker.doing();
    }
}
