package com.kk;

//创建线程方式一：继承Thread类，重写run()方法，调用start开启线程
public class StartThread extends Thread{
    @Override
    public void run(){
        //run方法线程体
        for (int i = 0; i < 20; i++) {
            System.out.println("子线程运行......"+i);
        }
    }
    //main线程，主线程
    public static void main(String[] args) {


        //创建一个线程对象
        StartThread startThread = new StartThread();

        //调用start()方法开启线程
        startThread.start();


        for (int i = 0; i < 20; i++) {
            System.out.println("主线程运行......"+i);
        }
    }

}


//总结：线程开启不一定立即执行，由CPU调度执行