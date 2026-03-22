package fanshe.Class02;

import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test01 {
    public static void main(String[] args) {

        try {
            Class<?> aClass = Class.forName("fanshe.Class02.Person");

            System.out.println(aClass.getName()); // 全类名
            System.out.println(aClass.getSimpleName());// 类名

            Field[] fields = aClass.getFields();//  本类以及父类  所有 public 属性
            for (Field field : fields) {
//                System.out.println(field.getName());
            }

            Field[] declaredFields = aClass.getDeclaredFields();// 本类所有属性
            for (Field declaredField : declaredFields) {
//                System.out.println(declaredField.getName());
            }

            Method[] methods = aClass.getMethods();   // 本类以及父类 所有 public 方法
            for (Method method : methods) {
//                System.out.println( method.getName());
            }

            Method[] declaredMethods = aClass.getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {
//                System.out.println(declaredMethod.getName()); // 本类所有属性 方法
            }

            Constructor<?>[] constructors = aClass.getConstructors();   // 本类所有 public 构造器
            for (Constructor<?> constructor : constructors) {
//                System.out.println(constructor.getName());
            }

            Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
            for (Constructor<?> declaredConstructor : declaredConstructors) {
//                System.out.println(declaredConstructor.getName());  // 本类所有 构造器
            }

            Package aPackage = aClass.getPackage();
            System.out.println(aPackage);  // 包名

            Class<?> superclass = aClass.getSuperclass();  // 获取父类 class

            Class<?>[] interfaces = aClass.getInterfaces();  // 所有接口信息
            for (Class<?> anInterface : interfaces) {
//                System.out.println(anInterface.getName());
            }

            Annotation[] annotations = aClass.getAnnotations();  // 所有注解
            for (Annotation annotation : annotations) {
//                System.out.println(annotation);
            }


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void Test01(){
        try {
            Class<?> aClass = Class.forName("fanshe.Class02.Person");

            Field[] declaredFields = aClass.getDeclaredFields();// 本类所有属性
            for (Field declaredField : declaredFields) {
                System.out.println(declaredField.getName() + "属性值 "+ declaredField.getModifiers() + "属性的类型" + declaredField.getType());
            }

            //getModifiers 获取属性值 如果是组合的 会相加
            // 默认 0  public 1  private 2 protected 4   static 8  final 16


            Method[] declaredMethods = aClass.getDeclaredMethods();
            for (Method declaredMethod : declaredMethods) {

                System.out.println(declaredMethod.getName()  + "属性值 "+ declaredMethod.getModifiers() + "属性的类型" + declaredMethod.getReturnType() ); // 本类所有 方法


                Class<?>[] parameterTypes = declaredMethod.getParameterTypes();
                for (Class<?> parameterType : parameterTypes) {
                    System.out.println("该方法的形参" + parameterType);
                }
            }


            Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
            for (Constructor<?> declaredConstructor : declaredConstructors) {
                System.out.println(declaredConstructor.getName()  + "属性值 "+ declaredConstructor.getModifiers()); // 本类所有 方法


                Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
                for (Class<?> parameterType : parameterTypes) {
                    System.out.println("该方法的形参" + parameterType);
                }
            }


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void Test02(){
        try {
            Class<?> aClass = Class.forName("fanshe.Class02.Person");

            //getModifiers 获取属性值 如果是组合的 会相加
            // 默认 0  public 1  private 2 protected 4   static 8  final 16

            Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
            for (Constructor<?> declaredConstructor : declaredConstructors) {
                System.out.println(declaredConstructor.getName()  + "属性值 "+ declaredConstructor.getModifiers()); // 本类所有 方法


                Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
                for (Class<?> parameterType : parameterTypes) {
                    System.out.println("该方法的形参" + parameterType);
                }
            }


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

class A implements Serializable {
    public String h ;
}



class Person extends  A implements Runnable {
    public String name ;
    protected  int age ;
    String job;
    private  int s;

    public static  String m ;

    public void m1(String s , int t , double d){
        System.out.println(s);
        System.out.println(t);
        System.out.println(d);
    }
    private void m2(){
        System.out.println("wqe");
    }
    protected void m3(){

    }
    void m4(){

    }

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    private Person(String name , int i) {
        this.name = name;
    }

    @Override
    public void run() {

    }
}


