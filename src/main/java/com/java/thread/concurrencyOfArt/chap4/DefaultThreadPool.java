package com.java.thread.concurrencyOfArt.chap4;


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by ibm on 2017/4/16.
 */
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job> {
    //线程池最大的数量
    private  static final int MAX_WORKER_NUMBERS=10;
    //线程池默认的数据
    private  static final int DEFAULT_WORKER_NUMBERS=5;
    //线程池最小的数量
    private  static final int MIN_WORKER_NUMBERS=1;
    //这是一个工作列表，将会向里面插入工作job
    private final LinkedList<Job> jobs=new LinkedList<Job>();
    //工作者列表
    private final List<Worker> workers= Collections.synchronizedList(new ArrayList<Worker>());
    //工作者线程的数量
    private int workerNum=DEFAULT_WORKER_NUMBERS;
    //线程编号生成
    private AtomicLong threadNum=new AtomicLong();

    public DefaultThreadPool(){
        initializeWokers(DEFAULT_WORKER_NUMBERS);
    }

    public DefaultThreadPool(int num){
        workerNum=num>MAX_WORKER_NUMBERS?MAX_WORKER_NUMBERS:num<MIN_WORKER_NUMBERS?MIN_WORKER_NUMBERS:num;
        initializeWokers(workerNum);
    }

    public void execute(Job job) {
        if(job!=null){
            //添加一个工作，然后进行通知
            synchronized (jobs){
                jobs.addLast(job);
                jobs.notify();
            }
        }
    }

    public void shutdown() {
        for (Worker worker:workers){
            worker.shutdown();
        }
    }

    public void addWorkers(int num) {
        //限制新增的Worker数量不能超过最大值
        synchronized (jobs){
            if(num+this.workerNum>MAX_WORKER_NUMBERS){
                num=MAX_WORKER_NUMBERS-this.workerNum;
            }
            initializeWokers(num);
            this.workerNum+=num;
        }
    }

    public void removeWorker(int num) {
        synchronized (jobs){
            if(num>=this.workerNum){
                throw new IllegalArgumentException("num beyond workerNum,num="+num+",workerNum="+workerNum);
            }
            int count=0;
            while (count<num){
                Worker worker=workers.get(count);
                if(workers.remove(worker)){
                    worker.shutdown();
                    count++;
                }
            }
            this.workerNum-=count;
        }
    }

    public int getJobSize() {
        return jobs.size();
    }

    //初始化线程工作者
    private void initializeWokers(int num) {
        for(int i=0;i<num;i++){
            Worker worker=new Worker();
            workers.add(worker);
            Thread thread=new Thread(worker,"ThreadPool-Worker-"+threadNum.incrementAndGet());
            thread.start();
        }
    }
    //工作者，负责消费任务
    class Worker implements Runnable{
        private volatile boolean running=true;

        public void run() {
            while (running){
               Job job=null;

                synchronized (jobs){

                    while (jobs.isEmpty()){
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                            //感知到外部对WorkerThread的中断操作，返回
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    //去吃一个Job
                    job=jobs.removeFirst();
                }
                if(job!=null){
                    try {
                        job.run();
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }
        }

        public void shutdown(){
            running=false;
        }
    }
}
