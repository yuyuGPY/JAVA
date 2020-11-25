package com.kk.practice;

/**
 * 两个线程轮流打印数字，一直到100
 * 思路：wait()、notify()
 */
public class Practice2 {

    public static class TakeTurns{
        private static boolean flag = true;

        private static int count = 0;

        public synchronized void print1() throws InterruptedException {
            for (int i = 0; i < 50; i++) {
                while (!flag){
                    this.wait();
                }
                System.out.println("线程1："+ ++count);
                flag = !flag;
                notifyAll();
            }
        }

        public synchronized void print2() throws InterruptedException {
            for (int i = 0; i < 50; i++) {
                while (flag){
                    this.wait();
                }
                System.out.println("线程2:"+ ++count);
                flag = !flag;
                notifyAll();
            }
        }
    }



    public static void main(String[] args) {

        TakeTurns takeTurns = new TakeTurns();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    takeTurns.print1();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    takeTurns.print2();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}


