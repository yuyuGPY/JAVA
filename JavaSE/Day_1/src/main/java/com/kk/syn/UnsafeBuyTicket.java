package com.kk.syn;

//不安全的买票
//线程安全问题，存在负数
public class UnsafeBuyTicket {
    public static void main(String[] args) {
        BuyTicket station = new BuyTicket();

        new Thread(station,"小明").start();
        new Thread(station,"张三").start();
        new Thread(station,"李四").start();


    }
}

class BuyTicket implements Runnable{

    //票
    int ticketNums = 10;
    boolean flag = true; //循环标志

    public void run() {
        //买票
        while (flag){
            try{
                buy();
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

    private void buy() throws InterruptedException {
        //判定是否有票
        if (ticketNums<=0){
            flag = false;
            return;
        }
        //模拟延时，放大问题发生性
        Thread.sleep(100);
        //买票
        System.out.println(Thread.currentThread().getName()+"拿到"+ticketNums--);
    }
}