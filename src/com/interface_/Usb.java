package com.interface_;

public interface Usb {
    public void start();
    public void stop();
}

class Phone implements Usb{
    @Override
    public void start() {
        System.out.println("phone  start");
    }

    @Override
    public void stop() {
        System.out.println("phone  stop");
    }

    void call(){
        System.out.println("我是手机");
    }
}

class Crama implements Usb{
    @Override
    public void start() {
        System.out.println("Crama  start");
    }

    @Override
    public void stop() {
        System.out.println("Crama  stop");
    }

    void call1(){
        System.out.println("我是Crama");
    }
}