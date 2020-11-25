package com.kk;

//多个线程同时操作同一个对象
//买火车票的例子

//发现问题： 多个线程操作同一资源的情况下，线程不安全，数据紊乱。
public class TrainTicket implements Runnable{

    //票数
    private int ticketNums = 10;

    public void run() {
        while(true){
            if (ticketNums<=0){
                break;
            }
            try {
                Thread.sleep(200);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"拿到了"+ticketNums--+"号票");
        }
    }


    public static void main(String[] args) {
        TrainTicket ticket = new TrainTicket();

        new Thread(ticket,"小明").start();
        new Thread(ticket,"老师").start();
        new Thread(ticket,"黄牛党").start();
    }
}
