package com.java.thread;

/**
 * 线程通信demo
 * 
 * @author tengcongcong
 * @date 2015年11月28日 上午10:19:30
 * @version 1.0.0
 */
public class ThreadCorrespondDemo {

    public static void main(String[] args) {
        Resource r = new Resource();
        //        InputRes input = new InputRes(r);
        //        OutputRes output = new OutputRes(r);
        //        Thread t1 = new Thread(input);
        //        Thread t2 = new Thread(output);
        //        t1.start();
        //        t2.start();

        new Thread(new InputRes(r)).start();
        new Thread(new OutputRes(r)).start();
    }
}

/**
 * 线程访问资源
 * 
 * @author tengcongcong
 * @date 2015年11月28日 下午1:15:49
 * @version 1.0.0
 */
class Resource {
    private String  name;
    private String  sex;
    private boolean flag = false;

    //优化后代码
    public synchronized void set(String name, String sex) {
        if (flag)
            try {
                this.wait();
            } catch (Exception e) {
            }
        this.name = name;
        this.sex = sex;
        flag = true;
        this.notify();
    }

    //优化后代码
    public synchronized void out() {
        if (!flag)
            try {
                this.wait();
            } catch (Exception e) {
            }
        System.out.println(this.name + "........" + this.sex);
        flag = false;
        this.notify();
    }

}

class InputRes implements Runnable {
    Resource r;

    public InputRes(Resource r) {
        this.r = r;
    }

    public void run() {
        int x = 0;
        while (true) {
            //            synchronized (r) {
            //                if (r.flag) {
            //                    try {
            //                        r.wait();//wait方法只能和synchronized关键字一起使用。
            //                    } catch (Exception e) {
            //                    }
            //                    ;
            //                }
            //                if (x == 0) {
            //                    r.name = "zhangsan";
            //                    r.sex = "menmen";
            //                } else {
            //                    r.name = "李四李四";
            //                    r.sex = "男男男男";
            //                }
            //                r.flag = true;
            //                r.notify();
            //            }
            if (x == 0) {
                r.set("zhangsan", "menmen");
            } else {
                r.set("李四李四", "男男男男");
            }

            x = (x + 1) % 2;
        }
    }
}

class OutputRes implements Runnable {
    Resource r;

    public OutputRes(Resource r) {
        this.r = r;
    }

    public void run() {
        while (true) {
            //            synchronized (r) {
            //                if (!r.flag) {
            //                    try {
            //                        r.wait();
            //                    } catch (Exception e) {
            //                    }
            //                }
            //                System.out.println(r.name + "--------" + r.sex);
            //                r.flag = false;
            //                r.notify();
            //            }
            r.out();
        }
    }
}
