package IO.homeWork;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

public class Test01 {
    public static void main(String[] args) {

    }

    @Test
    public void test01(){
        File file = new File("/Users/crilv/Desktop/java项目/chapter10/my");
        if (!file.exists()){
            if (file.mkdir()){
                System.out.println("创建成功");
            }
        }

        File file1 = new File("/Users/crilv/Desktop/java项目/chapter10/my/a.txt");
        BufferedWriter bufferedWriter = null;
        if (!file1.exists()){
            try {
                if (file1.createNewFile()){
                    System.out.println("a.txt 创建成功");

                    bufferedWriter = new BufferedWriter(new FileWriter("/Users/crilv/Desktop/java项目/chapter10/my/a.txt"));
                    bufferedWriter.write("111111");

                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }finally {
                try {
                    if (bufferedWriter != null){
                        bufferedWriter.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }


    @Test
    public void test02(){
        String path = "/Users/crilv/Desktop/java项目/chapter10/my/a.txt";
        BufferedReader bufferedReader = null;
        try {


            InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(path), "utf-8");
            bufferedReader = new BufferedReader(inputStreamReader);

            String str = "";
            int line = 0;

            while ((str = bufferedReader.readLine()) != null){
                System.out.println("行号"+ ++line + str);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    @Test
    public void test03(){

        Properties properties = new Properties();
        ObjectOutputStream objectOutputStream = null;
        ObjectInputStream objectInputStream = null;
        try {
            properties.load(new FileReader("/Users/crilv/Desktop/java项目/chapter10/a.properties"));
            Dog dog = new Dog(properties.getProperty("name"), Integer.parseInt(properties.getProperty("id")));
            System.out.println(dog);

            // 序列化
            objectOutputStream = new ObjectOutputStream(new FileOutputStream("/Users/crilv/Desktop/java项目/chapter10/b.txt"));
            objectOutputStream.writeObject(dog);

            objectInputStream = new ObjectInputStream(new FileInputStream("/Users/crilv/Desktop/java项目/chapter10/b.txt"));
            Object o = objectInputStream.readObject();
            System.out.println(o);


        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (objectOutputStream != null){
                try {
                    objectOutputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (objectInputStream != null){
                try {
                    objectInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}

class Dog implements Serializable{
    private String name;
    private int id ;

    public Dog(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
