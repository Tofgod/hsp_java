package com.thread;

public class Test04 {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread();

        // 优先级 PRIORITY  1 5 10
//        thread.getPriority();
        // interrupt 中断休眠  结束休眠状态   //  中断线程的休眠 但是没有真正结束线程  一般用于中断正在休眠的线程  其实之 会触发InterruptedException 异常 会被捕获

        Y y = new Y();
        y.setName("aaaaa");
        y.setPriority(Thread.MIN_PRIORITY);
        System.out.println(y.getName());
        y.start();

        for (int i = 0; i < 5; i++) {
            Thread.sleep(2000);
            y.interrupt(); //中断休眠  结束休眠状态
        }

        System.out.println(y.getPriority());


    }
}

class Y extends Thread{
    @Override
    public void run() {

        while (true){
//            for (int i = 0; i < 100; i++) {
//                System.out.println(Thread.currentThread().getName());
//            }

            try {
                Thread.sleep(20000);
            } catch (InterruptedException e) {
                // 当线程执行 Interrupt 方法 会catch  捕获到一个中断异常
                System.out.println(Thread.currentThread().getName() + "休眠被中断了...");
//                throw new RuntimeException(e);
            }

        }


    }
}
