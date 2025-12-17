package com.exercise;

import java.util.HashSet;
import java.util.Objects;

public class Hashset01 {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        P a = new P(100, "a"); // 9
        P b = new P(200, "b"); // 0

        hashSet.add(a);
        hashSet.add(b);
        a.name = "c";
        hashSet.remove(a); // 10
        System.out.println(hashSet);
        hashSet.add(new P(100,"c")); // 10
        System.out.println(hashSet);
        hashSet.add(new P(100, "a") );// 9
        System.out.println(hashSet);
    }
}

class P {
    private int id;
    public String name;

    public P(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof P)) return false;
        P p = (P) o;
        return id == p.id && Objects.equals(name, p.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "P{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
