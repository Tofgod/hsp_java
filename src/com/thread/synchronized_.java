package com.thread;

public class synchronized_ {
    public static void main(String[] args) {

        // 线程同步机制  保证一些数据 在任何同一时刻最多有一个线程访问 保证数据的完整性
        // 也可以这样理解 当一个线程对一个内存进行操作的时候  其他线程不可以对该内存地址进行操作 直到该线程操作完毕

        //同步方法的锁
        // 非静态当法的锁 是加在当前this指向的对象  也可以是其他对象 （要求是同一个对象）
        // 静态方法的锁 是加在当前类本身

    }
}

class Op extends Thread{




    @Override
    public void run() {

    }
}
