package com.fx;

import org.junit.jupiter.api.Test;

import java.util.*;

public class Fx06  {
    public static void main(String[] args) {
        //泛型不具备继承关系
        // ArrayList<Object> objects = new ArrayList<String >(); //是不对的
        // <?> 表示支持任意泛型类型
        // <? extends A> 表示支持A类以及A类的子类 规定了泛型的上限
        // <? super A> 表示支持A类以及A类的父类 不限制于直接父类 规定了泛型的下限

    }

    @Test
    public void test1(){
        DAO<User> userDAO = new DAO<>();
        userDAO.save("1", new User(1,18,"asd"));
        System.out.println(userDAO.get("1"));
        userDAO.update("1",new User(1,18,"abd") );
        System.out.println(userDAO.get("1"));
        System.out.println(userDAO.list1());
        userDAO.delete("1");
        System.out.println(userDAO.list());
    }
}

class DAO<T>{

    public Map <String , T > m = new HashMap<>();

    public void save(String id , T entity){
        m.put(id , entity);
    }

    public T get( String id ){
        return this.m.get(id);
    }

    public void update(String id , T entity){
        if (this.m.containsKey(id)){
            this.m.put(id , entity);
        }
    }

    public Collection<T> list(){
        return  this.m.values();
    }

    public List<T> list1(){
        List<T> ts = new ArrayList<>();
        Set<String> strings = this.m.keySet();
        for (String o :strings) {
            ts.add(get(o));
        }
        return ts;

    }

    public void delete(String id){
        this.m.remove(id);
    }

}

class User{
    private int id;
    private int age;
    private String name ;

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}