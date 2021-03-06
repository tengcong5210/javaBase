package com.java.thread.concurrencyOfArt.chap6;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * For/Join的使用
 */
public class CountTask extends RecursiveTask<Integer> {
    private static final int THRESHOLD=2;//阀值
    private int start;
    private int end;

    public CountTask(int start,int end){
        this.start=start;
        this.end=end;
    }

    protected Integer compute() {
        int sum=0;
        boolean canCompute=(end-start)<=THRESHOLD;
        if(canCompute){
            for(int i=start;i<=end;i++){
                sum+=i;
            }
        }else{
            //如果任务大于阀值，就分裂成两个子任务计算
            int middle=(start+end)/2;
            CountTask leftTask=new CountTask(start,middle);
            CountTask rightTask=new CountTask(middle+1,end);
            //执行子任务 fork方法调用时，ForkJoinWorkerThread的pushTask方法异步的执行这个任务，然后立即返回结果。
            leftTask.fork();
            rightTask.fork();
            //等待子任务执行完，并得到其结果  join方法阻塞当前并等待获取结果。
            int leftResult=leftTask.join();
            int rightResult=rightTask.join();
            //合并子任务
            sum=leftResult+rightResult;
        }
        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        //生成一个计算任务 ，负责计算1+2+3+4
        CountTask task=new CountTask(1,4);
        //执行一个任务
        Future<Integer> result=forkJoinPool.submit(task);
        try {
            System.out.print(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
