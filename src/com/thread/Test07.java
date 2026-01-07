package com.thread;

import java.util.concurrent.locks.LockSupport;

public class Test07 {
    public static void main(String[] args) {
        // Thread 线程的状态
        System.out.println(Thread.State.NEW);//尚未启动

        System.out.println(Thread.State.RUNNABLE);
        //正在运行 可运行状态 分为两个状态。一个是就绪状态 ready  一个是运行状态running
        // 当线程进入RUNNABLE状态 不是立即就会执行 是由系统调度决定的


        //* o 表示本线程 t表示其他线程

        System.out.println(Thread.State.BLOCKED);
        //被阻塞 等待进入同步代码块锁


        System.out.println(Thread.State.WAITING);
        //等待 调用 o.wait t.join LockSupport.park 会进入WAITING状态
        // 在执行o.notify o.notifyAll   LockSupport.unpark 重新进入RUNNABLE


        System.out.println(Thread.State.TIMED_WAITING);
        //等待超时 往往有一个时间限制 等时间结束 则进入RUNNABLE
        //Thread.sleep(time) o.wait(time) t.join(time)  LockSupport.parkNanos(); LockSupport.parkUntil();会进入TIMED_WAITING状态


        System.out.println(Thread.State.TERMINATED);//已经退出





    }
}
