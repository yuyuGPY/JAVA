package com.kk;

//测试守护线程
public class DaemonThread {
    public static void main(String[] args) {
        God god = new God();
        People people = new People();

        Thread t1 = new Thread(god);
        t1.setDaemon(true);
        t1.start();

        Thread t2 = new Thread(people);
        t2.start();

    }

}

class God implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 30000; i++) {
            System.out.println("上帝守护你");
        }

    }
}

class People implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 30000; i++) {
            System.out.println("开心活着");
        }
        System.out.println("---------死了-------------");
    }
}