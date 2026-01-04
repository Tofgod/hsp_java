package com.thread;

public class Test06 {
    public static void main(String[] args) throws InterruptedException {
        // 用户线程 ： 工作线程 当内容执行完结束 或者 收到通知 结束
        // 守护线程： 为用户线程服务的 当所有的用户线程结束 守护线程也就结束   垃圾回收机制
        //daemonThread.setDaemon(true);  // 设置为守护线程  当工作线程 结束 守护线程自动退出

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println(Thread.currentThread().getName() + "守护线程正在执行");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        thread.setDaemon(true); // 设置为守护线程  当工作线程 结束 守护线程自动退出
        thread.start();

        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println("main线程在工作");
        }

        System.out.println("main结束工作");
    }
}



