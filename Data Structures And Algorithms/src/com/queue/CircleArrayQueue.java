package com.queue;

/**
 * @Name NumberTwoPlayer
 * @create 2022-07-19-13:49
 */
public class CircleArrayQueue {
    public static void main(String[] args) {

    }
}
//使用数组模拟队列——编写一个ArrayQueue类
class CircleArray {
    private int maxSize; //表示数组的最大容量
    private int front; //队列头
    //front变量的含义做一个调整：front就指向队列的第一个元素，也就是说arr[front]就是队列的第一个元素
    //front的初始值为0
    private int rear; //队列尾
    //rear变量的含义做一个调整：rear指向队列的最后一个元素的后一个位置，因为希望空出一个空间
    //rear的初始值为0
    private int[] arr; //该数据用于存放数据，模拟队列

    //创建队列的构造器
    public CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1; //指向队列头部，分析front是指向队列头的前一个位置
        rear = -1; //指向队列尾，指向队列尾的数据(即包含队列最后一个数据)
    }

    //判断队列是否为满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }
    //判断队列是否为空
    public boolean isEmpty() {
        return rear == front;
    }
    //添加数据到队列
    public void addQueue(int n) {
        //判断队列是否满
        if (isFull()) {
            System.out.println("队列满,不能加入数据");
            return;
        }
        //直接将数据加入
        arr[rear] = n;
        //将rear后移，这里必须考虑取模
        rear = (rear + 1) % maxSize;
    }
    //获取队列的数据，出队列
    public int getQueue() {
        //判断队列是否空
        if (isEmpty()) {
            //通过抛出异常
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
    }
    //显示队列的所有数据
    public void showQueue() {
        //遍历
        if (isEmpty()) {
            System.out.println("队列空，没有数据");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d] = %d\n", i, arr[i]);
        }
    }

    //显示队列的头数据，注意不是取出数据
    public int headQueue(){
        //判断
        if(isEmpty()){
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front + 1];
    }
}
