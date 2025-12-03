package collection;

import java.util.LinkedList;
import java.util.List;

public class Test1 {
    public static void main(String[] args) {

        List list = new LinkedList();
        list.add(new Book("das",90));
        list.add(new Book("das",60));
        list.add(new Book("das1",20));
        list.add(new Book("das2",30));
        list.add(new Book("das",10));


        for (Object o : list) {
            Book b = (Book) o ;
            System.out.println(b.getPrice());
        }

        sort(list);
        for (Object o : list) {
            System.out.println(o);
        }


    }

    public static void sort(List list){
        for (int i = 0; i < list.size() - 1 ; i++) {
            for (int j = 0; j < list.size()- 1 - i ; j++) {
                Book b = (Book)list.get(j);
                Book bb = (Book)list.get(j + 1 );
                if (b.getPrice() - bb.getPrice()  > 0){
                    list.set(j , bb);
                    list.set(j + 1 , b);
                }
            }
        }
    }
}
class Book{
    private String name;
    private int price;

    public Book(String name, int price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}