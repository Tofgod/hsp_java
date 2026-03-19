package fanshe;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class ClassTesto1 {

    public static void main(String[] args) {
        String path = "fanshe.Car";
        try {
            Class<?> aClass = Class.forName(path);
            // <?> 表示不确定的类型
            System.out.println(aClass);
            System.out.println(aClass.getClass());

            System.out.println(aClass.getPackage().getName());

            System.out.println(aClass.getName());

            Object o = aClass.newInstance();
            System.out.println(o);

            Field[] fields = aClass.getFields();
            System.out.println(fields[0]);

            Object o1 = fields[0].get(o);
            System.out.println(o1);

            fields[0].set(o,"ggg");
            System.out.println(fields[0].get(o));

            // 代码阶段   Class.forName  多用于配置文件
            // 运行阶段获取 Class  类.class  用于构造器的参数传递
            // Constructor<?> constructor1 = aClass.getConstructor(int.class)
            Class<Car> carClass = Car.class;
            System.out.println(carClass);

            // 运行阶段  对象.getClass  已经得到运行的实例了
            Car car = new Car();
            Class<? extends Car> aClass1 = car.getClass();

            // 通过类加载器(4 种)获取到类的 class 对象
            ClassLoader classLoader = car.getClass().getClassLoader();
            Class<?> aClass2 = classLoader.loadClass(path);


            //基本数据类型 通过 .class获取 Class
            Class<Integer> integerClass = int.class;


            // 基本类型对应的包装类 .type 获取Class对象
            Class<Integer> type = Integer.TYPE;
            System.out.println(type);


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }
}
