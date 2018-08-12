package com.java.thread.threadPool;

import java.util.concurrent.Callable;

/**
 * @创建人 tengcc
 * @创建时间 2018/8/9
 * @描述
 */
public class BuildTask implements Callable<String> {

    private  int num;
    public BuildTask(int num){
        this.num=num;
    }

    @Override
    public String call() throws Exception {

        String str=num+"构建号";

        return str;
    }
}
