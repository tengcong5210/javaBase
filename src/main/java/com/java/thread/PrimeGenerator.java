package com.java.thread;

/**
 * n 线程的中断
 * 
 * @author linco lee
 */
public class PrimeGenerator extends Thread {

    @Override
    public void run() {
        long number = 1l;
        while (true) {
            if (isPrime(number)) {
                System.out.println("Number :" + number + " is prime");
            }
            if (isInterrupted()) {//判断线程是否中断
                System.out.println("the prime Generator has ben interrupted");
                return;
            }
            number++;
        }
    };

    /**
     * 判断一个数是不是素数
     * 
     * @param number
     * @return
     */
    private boolean isPrime(long number) {
        if (number <= 2) {
            return true;
        }
        for (long i = 2; i < number; i++) {
            if (number % 2 == 0) {
                return false;
            }

        }
        return true;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread task = new PrimeGenerator();
        task.start();
        Thread.sleep(5000);
        task.interrupt();
    }

}
