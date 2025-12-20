package com.fx;

import java.util.*;

public class Fx02 {
    public static void main(String[] args) {

        Person<String> s = new Person<>("s");

        HashMap<String, Stu> stringStuHashMap = new HashMap<>();
        Stu das = new Stu("das");
        Stu dasT = new Stu("dasT");
        stringStuHashMap.put(das.getName() ,das);
        stringStuHashMap.put(dasT.getName() ,dasT);

        Set<Map.Entry<String, Stu>> entries = stringStuHashMap.entrySet();
        Iterator<Map.Entry<String, Stu>> iterator = entries.iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Stu> next =  iterator.next();
            String key = next.getKey();
            Stu value = next.getValue();
            System.out.println(key);
            System.out.println(value);
        }

        HashSet<Stu> stus = new HashSet<>();
        stus.add(new Stu("w"));


    }
}

class Person <T>{  //该数据类型 在创建的时候被定义 在编译期间就确定了
    String s;
    T c; // 这个属性的数据类型 在创建的时候被定义

    public Person(T s) {
        this.c = s;
    }

    public T ss(){
        return c;
    }

}

class Stu{
    private String name;

    public Stu(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Stu stu = (Stu) o;
        return Objects.equals(name, stu.name);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "Stu{" +
                "name='" + name + '\'' +
                '}';
    }
}
