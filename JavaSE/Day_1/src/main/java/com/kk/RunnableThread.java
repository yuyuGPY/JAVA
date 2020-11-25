package com.kk;

//创建线程方式2：实现runnable接口，执行线程需要丢人runnable接口实现类，调用start方法
public class RunnableThread implements Runnable{

    public void run() {
        //run方法线程体
        for (int i = 0; i < 200; i++) {
            System.out.println("子线程运行......"+i);
        }
    }

    public static void main(String[] args) {
        //创建runnable接口的实现类对象
        RunnableThread runnableThread =new RunnableThread();

        //创建线程对象，通过线程对象来开启我们的线程，代理
        new Thread(runnableThread).start();

        for (int i = 0; i < 1000; i++) {
            System.out.println("主线程运行......"+i);
        }
    }

}
