package com.interface_;

public class Test {
    public static void main(String[] args) {
        Computer computer = new Computer();
        Phone phone = new Phone();
        Crama crama = new Crama();
        computer.work(phone);
        computer.work(crama);
    }
}

class Computer{
    public void work(Usb usb){
        usb.start();
        usb.stop();
        if (usb instanceof Phone){
            Phone p = (Phone) usb;
            p.call();
        }
        if (usb instanceof Crama){
            Crama c = (Crama) usb;
            c.call1();
        }
    }
}

