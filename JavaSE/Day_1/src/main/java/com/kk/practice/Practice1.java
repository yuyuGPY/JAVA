package com.kk.practice;

/**
 * 要求线程a执行完才开始线程b, 线程b执行完才开始线程
 */
public class Practice1 {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("线程a执行......");
            }
        });

        Thread t2 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println("线程b执行......");
            }
        });

        t1.start();
        t1.join();
        t2.start();
    }
}


