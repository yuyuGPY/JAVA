package com.kk;

//测试线程优先级
public class PriorityThread {
    public static void main(String[] args) {
        //主线程默认线程优先级
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());

        MyPriority myPriority = new MyPriority();

        Thread t1 = new Thread(myPriority);
        Thread t2 = new Thread(myPriority);
        Thread t3 = new Thread(myPriority);
        Thread t4 = new Thread(myPriority);
        Thread t5 = new Thread(myPriority);
        Thread t6 = new Thread(myPriority);

        t1.start();

        t2.setPriority(2);
        t2.start();

        t3.setPriority(6);
        t3.start();

        t4.setPriority(1);
        t4.start();

        t5.setPriority(10);
        t5.start();

        t6.setPriority(8);
        t6.start();

    }
}

class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"-->"+Thread.currentThread().getPriority());
    }
}
