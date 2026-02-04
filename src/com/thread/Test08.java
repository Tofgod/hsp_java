package com.thread;

import java.util.Scanner;

public class Test08 {
    public static void main(String[] args) {
//        TT tt = new TT();
//        tt.start();
//        TTF ttf = new TTF(tt);
//        ttf.start();

        Card card = new Card();

        Thread thread = new Thread(card);
        Thread thread1 = new Thread(card);
        thread.start();
        thread1.start();
    }
}

class TT extends Thread{

    public boolean loop = true;

    @Override
    public void run() {
        while (loop){

            System.out.println((int)(Math.random()*100));

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

    }
}

class TTF extends Thread{

    private TT t = null;
    private Scanner scanner = new Scanner(System.in);

    public TTF(TT t) {
        this.t = t;
    }

    @Override
    public void run() {
        while (true){

            char s = scanner.next().toUpperCase().charAt(0);
            if (s == 'Q'){
                t.loop = false;
                System.out.println("TTF 线程退出");
                break;
            }

        }

    }
}

class Card implements Runnable{

    private int num = 10000;

    @Override
    public void run() {
        while (true){


            synchronized (this){

                if (num <= 0){
                    System.out.println("结束");
                    break;
                }

                num-=1000;
                System.out.println(Thread.currentThread().getName() + "取钱1000" + "剩余" + num);
            }


            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }



}
