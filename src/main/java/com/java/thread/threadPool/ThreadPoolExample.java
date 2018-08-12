package com.java.thread.threadPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @创建人 tengcc
 * @创建时间 2018/8/9
 * @描述
 */
public class ThreadPoolExample {




    public static void main(String[] args) throws ExecutionException, InterruptedException {

// 构造一个线程池
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(2, 4, 3,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3));
        List<Future<String>> futureList =new ArrayList<>();
        for(int i=0;i<3;i++){
            Future<String> future=threadPool.submit(new BuildTask(i));

            futureList.add(future);
        }

        System.out.println("--------------submit----------------");

        for(Future<String> f:futureList){
            String string=f.get();
            System.out.println("result:"+string);
        }
        System.out.println("--------------get----------------");

    }





}
