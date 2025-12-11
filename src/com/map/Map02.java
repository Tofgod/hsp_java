package com.map;

import java.util.*;

public class Map02 {
    public static void main(String[] args) {

        Map map = new HashMap();

        map.put("aaa","bbb");
        map.put("ttt","bbb");
        map.remove("aaa");
//        System.out.println(map);
//        System.out.println(map.get("ttt"));
//        System.out.println(map.size());
//        System.out.println(map.isEmpty());
//        map.clear();
//        System.out.println(map);
//        System.out.println(map.containsKey("a")); //是否存在

        Set set = map.keySet();
        // 1 .增强for 2.迭代器  在通过map.get

        Collection values = map.values();
        // 1 .增强for 2.迭代器  获得全部的值

        Set set1 = map.entrySet();
        // 1 .增强for 2.迭代器
        for (Object o : set1) {
            Map.Entry m = (Map.Entry) o ;
            System.out.println(m.getKey() + "-" +m.getValue());
        }

        Iterator iterator = set1.iterator();
        while (iterator.hasNext()) {
            Object next =  iterator.next();
            Map.Entry m = (Map.Entry) next ;
            System.out.println(m.getKey() + "-" +m.getValue());
        }


        Map hashMap = new HashMap();

        hashMap.put(1,new Ma(100,1,"大山1" ));
        hashMap.put(2,new Ma(20000,2,"大山2"));
        hashMap.put(3,new Ma(35000,3,"大山3"));

        Set set2 = hashMap.keySet();
        for (Object o : set2) {
            Ma o1 = (Ma)hashMap.get(o);
            if (o1.getSalary() > 18000){
                System.out.println(o1);
            }
        }


    }
}

class Ma{
    private  int id ;
    private  String name;
    private int salary;

    public Ma(int salary, int id, String name) {
        this.salary = salary;
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Ma{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Ma)) return false;
        Ma ma = (Ma) o;
        return id == ma.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
