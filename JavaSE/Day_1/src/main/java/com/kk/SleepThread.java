package com.kk;

//模拟网络延时:放大问题的发生性
public class SleepThread implements Runnable {

        //票数
        private int ticketNums = 10;

        public void run () {
            while (true) {
                if (ticketNums <= 0) {
                    break;
                }
                //模拟延时
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "拿到了" + ticketNums-- + "号票");
            }
        }


        public static void main (String[]args){
            TrainTicket ticket = new TrainTicket();

            new Thread(ticket, "小明").start();
            new Thread(ticket, "老师").start();
            new Thread(ticket, "黄牛党").start();
        }
    }

