package com.abstract_;

public class Test1 {
    public static void main(String[] args) {

    }
}

abstract class Employee{
    private String name;
    private double salary;
    private String id;

    public Employee(String name, int salary, String id) {
        this.name = name;
        this.salary = salary;
        this.id = id;
    }

    public abstract void work();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

class Manager extends Employee{

    private double bonus;

    public Manager(String name, int salary, String id) {
        super(name, salary, id);
    }

    public void work(){
        System.out.println(super.getName() + "正在工作中。。。。。。");
    }
}
