package com.Multithreading.java;

/**
 * 创建三个窗口卖票，总票数为100------------使用实现Runnable接口的方式
 * 存在线程安全问题
 *
 * @Name NumberTwoPlayer
 * @create 2022-07-23-20:00
 */
class window1 implements Runnable {

    private int ticket = 100;

    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(Thread.currentThread().getName() + "：卖票，票号为：" + ticket);
                ticket--;
            } else {
                break;
            }
        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {
        window1 w = new window1();

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
