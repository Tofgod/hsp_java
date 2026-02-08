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
            Path path = Paths.get("D:\\JavaProject\\hsp_java\\Text6.dat");

            ObjectInputStream objectInputStream = new ObjectInputStream(Files.newInputStream(path));

            ObjectOutputStream objectOutputStream = new ObjectOutputStream(Files.newOutputStream(path));

            objectOutputStream.write(100);
            objectOutputStream.writeBoolean(false);
            objectOutputStream.writeUTF("2131");
            objectOutputStream.writeObject(new Dog()); // 需要实现Serializable 接口  不然会报错 因为没有实现序列化接口
            objectOutputStream.close();

            Object o = objectInputStream.readObject();


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

}



//Serializable 序列化 标记接口 没有任何方法
//Externalizable 序列化 有方法需要实现 不推荐
class Dog implements Serializable{

}