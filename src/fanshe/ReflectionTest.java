package fanshe;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;

public class ReflectionTest {
    public static void main(String[] args) {
        // 根据配置文件指定的信息 创建对象并调用方法hi

        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("/Users/crilv/Desktop/java项目/chapter10/src/fanshe/re.properties"));
//            properties.load(new FileInputStream("D:\\JavaProject\\hsp_java\\src\\fanshe/re.properties"));

            String classfullpath = properties.get("classfullpath").toString();
            String method = properties.get("method").toString();
            System.out.println(classfullpath);
            System.out.println(method);
            String filed = properties.get("filed").toString();

            //创建一个对象  但此时拿到的累的信息 是字符串  无法通过传统的方式进行对象的创建 即 new
            // 所以 这就是反射的第一个作用 使用 一些信息就可以创建一个对象   而不是传统的定义了class文件 再通过new去创建
            // 反射可以使用一些信息去创建对象

            // 第一层思考 反射是创建对象的第二种方式 第一种是new
            // 反射通过加载类的 包名的信息  去创建对象的实例。前提是包名正确 类存在


            // 第一步 先加载一个 Class  返回了一个Class类型的一个对象
            Class<?> aClass = Class.forName(classfullpath);  // 先通过 Class 加载 classfullpath 返回一个Class对象
            // 通过 aClass 可以得到 classfullpath 的对象事例
            Object o = aClass.newInstance(); // 得到classfullpath 的对象事例
            System.out.println(o.getClass());
            // 可以通过类型转换到对应的对象 但是 没有必要 因为 这不是反射的应用场景
            // 反射的第一个功能 通过读取到的类的信息 去进行方法的调用  比如从一个配置文件 读取类的信息 然后通过这些信息 去加载类 去调用类的方法
            // 大前提是 这些加载类的信息都是正确的

            // 反射中 方法也是一种对象
            Method method1 = aClass.getMethod(method); // 通过这个方法可以获取到 加载的类的方法对象
            // 然后通过 方法对象实现方法的调用

            // 传入 持有该方法的对象 即可完成方法的调用
            method1.invoke(o);
            //java被称为动态语言 就是因为 java 的反射机制  spring 以及 spring的相关框架 离不开 java 的反射机制  价值很高


            // 可以做到在不修改源码的情况下 进行程序的更改 满足开闭原则    比如类 的方法 名称 的信息 都在通过在配置文件中记录的
            // 在上述流程固定的情况下 只用修改配置问价 就可以达到不修改源码 就可以加载不同的类 调用不同的方法

            // 程序运行反射在运行期间 获取类的信息
            // 加载完信息后 会生成一个 Class类型类的对象实例  一个类只能在堆中产生一个Class类型类  它包含了加载对象的全部信息  像一面镜子 反射出类的所有信息 所以称之为反射

            //获取对象的字段
            //Field field = aClass.getField("a"); // 不能得到私有属性
            Field field = aClass.getField("b"); // 不能得到私有属性







        } catch (IOException e) {
            throw new RuntimeException(e);
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
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }


        //传统的方式 先newCat 在调用对应的hi





    }
}


