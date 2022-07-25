package com.Multithreading.java;

/**
 * 创建三个窗口卖票，总票数为100------------使用实现Runnable接口的方式
 * 存在线程安全问题
 *
 * 1、问题：
 * 2、问题出现的原因：当某个线程操作车票的过程中，尚未操作完成时，其他线程参与进来，也操作车票
 * 3、解决：当一个线程a在操作ticket的时候，其他线程不能参与进来，直到线程a操作完ticket时，其他线程才可以开始操作ticket，
 *         这种情况即使线程a出现阻塞，也不能被改变
 * 4、Java中，我们通过同步机制，来解决线程的安全问题
 *
 *      方式一：同步代码块
 *
 *      synchronized(同步监视器){
 *          需要被同步的代码
 *      }
 *      说明: 1、操作共享数据的代码，即为需要被同步的代码
 *            2、共享数据：多个线程共同操作的变量。比如：ticket就是共享数据
 *            3、同步监视器；俗称：锁。任何一个类的对象，都可以充当锁
 *            要求：多个线程必须要共用同一把锁
 *      方式二：同步方法
 *
 *      5、同步的方法，解决了线程的安全问题
 *
 *
 *
 * @Name NumberTwoPlayer
 * @create 2022-07-23-20:00
 */
class window1 implements Runnable {

    private int ticket = 100;
    Object object = new Object();

    public void run() {
        while (true) {
            synchronized (object) {
                if (ticket > 0) {

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + "：卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
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