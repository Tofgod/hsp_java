package IO.io;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test04 {
    public static void main(String[] args) {
        // 对象处理流
       //  ObjectInputStream//  序列化 ： 同时保存值 跟 数据类型
    }
    @Test
    public void get(){
        try {
            Path path = Paths.get("/Users/crilv/Desktop/java项目/chapter10/Text6.dat");
            ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(path)); // 读取的顺序 要跟存放的顺序保持一致
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(path));


            objectOutputStream.writeInt(100);
            objectOutputStream.writeBoolean(false);
            objectOutputStream.writeUTF("2131");
            objectOutputStream.writeObject(new Dog());
            // 细节 ：
            // 需要实现Serializable 接口  不然会报错 因为没有实现序列化接口
            // 并且这个类必须在当前包内 或者是public 类
            objectOutputStream.close();


            Object o = objectInputStream.readInt();
            System.out.println(o);
            Object o1 = objectInputStream.readBoolean();
            System.out.println(o1);
            Object o2 = objectInputStream.readUTF();
            System.out.println(o2);
            Object o3 = objectInputStream.readObject();
            System.out.println(o3);

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}

class M implements Serializable {

}

//Serializable 序列化 标记接口 没有任何方法
//Externalizable 序列化 有方法需要实现 不推荐
class Dog implements Serializable{

     private static final long serialVersionUID = 1L; // 序列化版本号 ，可以提供序列化的兼容性

    // static , transient  修饰的成员不会序列化。transient关键字的作用是防止序列化某些敏感或不必要的字段。

    // 序列化时候 要求成方也要继承序列化的接口

    private M m = new M();   // 序列化时候 如果进行了初始化 要求成方也要继承序列化的接口

    private M m1; // 这样的不用继承序列化的接口

    transient int age = 1;  // 没有被序列化 反序列化的时候 读取不到 因为 transient 的修饰

    @Override
    public String toString() {
        return "Dog{" +
                "age=" + age +
                '}';
    }
}