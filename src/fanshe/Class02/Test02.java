package fanshe.Class02;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test02 {
    public static void main(String[] args) {
        // 反射 创建对象实例
        try {
            Class<?> aClass = Class.forName("fanshe.Class02.Person");

            //通过无参构造器 创建
            Person o = (Person) aClass.newInstance();

            Constructor<?> constructor = aClass.getConstructor(String.class ); // public
            Person o1 = (Person) constructor.newInstance("123");

            Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class, int.class);
            // 私有的构造器 这样执行的话 会报错
            //Person o2 = (Person) declaredConstructor.newInstance("213", 123);

            // 可以进行爆破 再执行  通过反射爆破 可以访问私有的构造器
            declaredConstructor.setAccessible(true);
            Person o2 = (Person) declaredConstructor.newInstance("213", 123);


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void Test01(){
        try {
            Class<?> aClass = Class.forName("fanshe.Class02.Person");

            Field name = aClass.getDeclaredField("name");
            Person o = (Person)aClass.newInstance();
            name.set(o,"qwe");
            System.out.println(name.get(o));

            Field s = aClass.getDeclaredField("s");
            // 私有属性不可以直接修改
            // 通过反射爆破 可以进行修改
            s.setAccessible(true);
            s.set(o,1);
            System.out.println(s.get(o));

            Field m = aClass.getDeclaredField("m");
            s.set(null,1);  // static 修饰的话 可以传入null



        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void Test03(){
        try {
            Class<?> aClass = Class.forName("fanshe.Class02.Person");
            Method m1 = aClass.getDeclaredMethod("m1" , String.class , int.class , double.class);
            Person o = (Person)aClass.newInstance();
            m1.invoke(o , "1" , 1, 1.0 );  // 方法调用

            Method m2 = aClass.getDeclaredMethod("m2");
            m2.setAccessible(true);
            m2.invoke(o );

            // 如果是静态方法 o 可以为null


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}



