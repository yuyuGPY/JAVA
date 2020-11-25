package com.kk.practice;

/**
 * 写两个线程，一个线程打印1~ 52，另一个线程打印A~Z，打印顺序是12A34B…5152Z
 * 思路：两个线程的线程执行顺序问题还是可以用wait()、notify()
 */
public class Practice3 {
    public static class TakeTurns{
        private static boolean flag = true;
        private int count = 0;

        public synchronized void print1() throws InterruptedException {
            for (int i = 0; i < 26; i++) {
                while (!flag){
                    this.wait();
                }
                System.out.print("线程1:"+ ++count);
                System.out.print(++count);
                flag = !flag;
                notifyAll();
            }
        }

        public synchronized void print2() throws InterruptedException {
            for (int i = 0; i < 26; i++) {
                while (flag){
                    this.wait();
                }
                System.out.println("线程2:"+(char)(65+i));
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
