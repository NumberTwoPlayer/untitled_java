package com.Multithreading.java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三：lock锁 ---JDK5.0新增
 *
 * 1、面试题：synchronized 与 Lock 的异同？
 * 相同：二者的可以解决线程安全问题
 * 不同：synchronized机制在执行完相应的同步代码块以后，自动的释放同步监视器
 *      lock需要手动的启动同步（lock()），同时结束同步也需要手动的实现（unlock()）
 *
 *
 * @Name NumberTwoPlayer
 * @create 2022-07-27-23:48
 */
class Window implements Runnable {
    private int ticket = 100;

    //1、实例化Reentrantlock
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                //2、调用Lock()
                lock.lock();

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (ticket > 0) {
                    System.out.println(Thread.currentThread().getName() + ":售票，票号为" + ticket);
                    ticket--;
                } else {
                    break;
                }
            } finally {
                //3、调用解锁方法：unlock()
                lock.unlock();
            }
        }
    }
}


    public class LockTest {
        public static void main(String[] args) {
            Window w = new Window();


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

