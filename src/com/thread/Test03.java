package com.thread;

public class Test03 {
    public static void main(String[] args) throws InterruptedException {
        // 使用变量控制 run方法结束来退出线程
        T t = new T();
        Thread thread = new Thread(t);
        thread.start();

        Thread.sleep(5000);
        t.b = false; // 外部控制

    }
}

class T implements Runnable{

    boolean b = true;

    @Override
    public void run() {
         while (b){
             try {
                 Thread.sleep(50);

             } catch (InterruptedException e) {
                 throw new RuntimeException(e);
             }
             System.out.println("T 正在运行");
         }
    }
}
