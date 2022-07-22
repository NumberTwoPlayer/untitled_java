package com.Multithreading.java;

/**
 * 测试Thread中的常用方法：
 * 1、start()：启动当前线程；调用当前线程的run（）
 * 2、run()：通常需要重写Thread类中的此方法；将创建的线程要执行的操作声明在此方法中
 * 3、currentThread()：静态方法，返回执行当前代码的线程
 * 4、getName()：获取当前线程的名字
 * 5、setName()：设置当前线程的名字
 * 6、yield()：释放当前cpu的执行权
 * 7、join()；早线程a中调用线程b的join()，此时线程a就进入堵塞状态，直到线程b完全执行完以后，线程a才结束堵塞状态
 * 8、stop()：已过时，当执行此方法时，强制执行当前线程
 * 9、sleep(long millitime)：让当前线程“睡眠”指定的millitime毫秒，在指定的millittime毫秒时间内。当前线程处于堵塞状态
 * 10、isAlive()：判断当前线程是否存活
 *
 *
 * @Name NumberTwoPlayer
 * @create 2022-07-22-19:08
 */

class HelloThread extends Thread{

    public void run(){
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){

                try {
                    sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

//           if(i % 20 == 0){
//                yield();
//           }
        }
    }
    public HelloThread(String name){
        super(name);
    }

}

public class ThreadMethodTest {
    public static void main(String[] args) {

        HelloThread s1 = new HelloThread("Thread: 1: ");

        s1.setName("线程一");

        s1.start();

        //给主线程命名
        Thread.currentThread().setName("主线程");

        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

            if(i == 20){
                try {
                    s1.join();
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }

        System.out.println(s1.isAlive());
    }
}
