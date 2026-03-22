package fanshe.Class02;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test03 {


    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("fanshe.Class02.PrivateTest");
            Object o = aClass.newInstance();
            Field name = aClass.getDeclaredField("name");
            name.setAccessible(true);
            name.set(o , "tt");

            Method getName = aClass.getDeclaredMethod("getName");
            Object invoke = getName.invoke(o);
            System.out.println(invoke);



        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
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
            Class<?> aClass = Class.forName("java.io.File");

//            Constructor<?>[] constructors = aClass.getConstructors();
//            for (Constructor<?> constructor : constructors) {
//                System.out.println(constructor.getName());
//            }

            Constructor<?>[] declaredConstructors = aClass.getDeclaredConstructors();
            for (Constructor<?> declaredConstructor : declaredConstructors) {
                System.out.println(declaredConstructor);
            }

            Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class);
            File o = (File) declaredConstructor.newInstance(""); // 里面填写地址
//            o.createNewFile(); // 创建文件的方法 调用才可以创建文件

            Method createNewFile = aClass.getDeclaredMethod("createNewFile");
            createNewFile.invoke(o );  // 创建文件的方法 调用才可以创建文件


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }

    }
}
class PrivateTest {

    private String name = "helloKitty";



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}