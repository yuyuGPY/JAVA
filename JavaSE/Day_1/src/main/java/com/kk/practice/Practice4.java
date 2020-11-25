package com.kk.practice;

import java.util.Properties;

/**
 * 编写一个程序，启动三个线程，三个线程的ID分别是A，B，C；，每个线程将自己的ID值在屏幕上打印5遍，打印顺序是ABCABC…
 * 重点：多线程执行顺序
 */
public class Practice4 {
    public static class ABC{
        private int flag = 0;
        public synchronized void printA(){
            for (int i = 0; i < 5; i++) {
                while (flag!= 0){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                flag = 1;
                System.out.print("A");
                notifyAll();
            }
        }
        public synchronized void printB(){
            for (int i = 0; i < 5; i++) {
                while (flag!= 1){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                flag = 2;
                System.out.print("B");
                notifyAll();
            }
        }
        public synchronized void printC(){
            for (int i = 0; i < 5; i++) {
                while (flag!= 2){
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                flag = 0;
                System.out.print("C");
                notifyAll();
            }
        }
    }


    public static void main(String[] args) {
        ABC abc = new ABC();
        new Thread(new Runnable() {
            @Override
            public void run() {
                abc.printA();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                abc.printB();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                abc.printC();
            }
        }).start();
    }


}
