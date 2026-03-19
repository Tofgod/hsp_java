package fanshe;

public class Car {

    public String brand = "bm";
    public int price = 2 ;
    public String color = "b";


    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                '}';
    }
}
