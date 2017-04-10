package com.java.thread.concurrencyOfArt.chap4;

import com.java.thread.concurrencyOfArt.utils.SleepUtils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 过期的suspend()、resume()、stop()
 * 通过本示例可以看出这三个方法是过期的，原因是他们被调用后，线程不会释放已经占有的资源（比如锁），
 * 而是进入睡眠状态，这样容易产生死锁。这些暂停恢复操作可以用等待/通知机制来替代
 * Created by ibm on 2017/4/9.
 */
public class Deprecated {

    public static void main(String[] args)throws Exception{
        DateFormat format=new SimpleDateFormat("HH:mm:ss");
        //创建printThread线程
        Thread printThread=new Thread(new Runner(),"PrintThread");
        printThread.setDaemon(true);
        printThread.start();
        TimeUnit.SECONDS.sleep(3);

        //将PrintThread进行暂停，输出内容工作停止
        printThread.suspend();
        System.out.println("main suspend PrintThread at "+format.format(new Date()));
        TimeUnit.SECONDS.sleep(3);

        //将PrintThread进行恢复，输出内容继续
        printThread.resume();
        System.out.println("main resume PrintThread at "+format.format(new Date()));
        TimeUnit.SECONDS.sleep(3);

        //将PrintThread进行终止，输出内容停止
        printThread.stop();
        System.out.println("main stop PrintThread at "+format.format(new Date()));
        TimeUnit.SECONDS.sleep(3);



    }
    static class Runner implements Runnable{

        public void run() {
            DateFormat format=new SimpleDateFormat("HH:mm:ss");
            while (true){
                System.out.println(Thread.currentThread().getName()+"Run at "+format.format(new Date()));
                SleepUtils.second(1);
            }
        }
    }
}
