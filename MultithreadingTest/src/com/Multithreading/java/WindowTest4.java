package com.Multithreading.java;

/**
 * 使用同步方法解决实现Runnable接口的线程安全问题
 *
 * 关于同步方法的总结：
 * 1、同步方法仍然涉及到同步监视器，只是不需要我们显示的声明
 * 2、非静态的同步方法，同步监视器是：this
 *      静态的同步方法，同步监视器是：当前类本身
 *
 * @Name NumberTwoPlayer
 * @create 2022-07-25-16:34
 */
class Window4 extends Thread {

    private static int ticket = 100;

    public void run() {

        while (true) {

            show();
        }
    }
        private static synchronized void show(){
            if (ticket > 0) {

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                ticket--;
            }
        }
    }



public class WindowTest4 {
    public static void main(String[] args) {
        Window4 t1 = new Window4();
        Window4 t2 = new Window4();
        Window4 t3 = new Window4();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}
