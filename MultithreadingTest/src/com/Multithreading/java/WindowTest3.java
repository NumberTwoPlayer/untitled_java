package com.Multithreading.java;

/**
 * 使用同步方法解决实现Runnable接口的线程安全问题
 *
 * @Name NumberTwoPlayer
 * @create 2022-07-25-16:20
 */
class window3 implements Runnable {
    private int ticket = 100;

    public void run(){
        while(true){

            show();
        }
    }

    public synchronized void show(){//同步监视器：this
        //synchronized(this){
        while (true) {
            if (ticket > 0) {

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + "：卖票，票号为：" + ticket);
                ticket--;
            }
        }
    }
}


public class WindowTest3 {
    public static void main(String[] args) {
        window3 w = new window3();

        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");

        t1.start();
        t2.start();
        t3.start();
    }
}
