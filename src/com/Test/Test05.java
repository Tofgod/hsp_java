package com.Test;

public class Test05 {
    public static void main(String[] args) {

        Car car = new Car(-99);
        Car.Air air = car.new Air();
        air.flow();

    }
}

class Car{
    private double temp ;

    public Car(double temp) {
        this.temp = temp;
    }

    class Air{

        public void flow(){
            if (Car.this.temp < 0.0){
                System.out.println("吹冷风");
            }else if (Car.this.temp > 40.0){
                System.out.println("吹冷风");
            }else{
                System.out.println("关闭");
            }
        }
    }
}
