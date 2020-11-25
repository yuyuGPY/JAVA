package com.kk;

import javax.swing.*;

//测试join方法
//想象为插队
public class JoinThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            System.out.println("线程vip来了"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        //启动我们的线程
        JoinThread joinThread = new JoinThread();
        Thread thread = new Thread(joinThread);
        thread.start();

        //主线程
        for (int i = 0; i < 500; i++) {

            if (i == 200){
                thread.join(); //插队
            }
            System.out.println("main"+i);
        }

    }
}
