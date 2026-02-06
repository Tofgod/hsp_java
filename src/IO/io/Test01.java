package IO.io;

import org.junit.jupiter.api.Test;

import java.io.*;

public class Test01 {
    public static void main(String[] args) {
        // 字符跟字节的对应跟编码是有关系的  不同的编码方式 是不同的

        // 字符流的效率高 读取的多  操作文本文件   Reader    Writer
        //字节流 操作二进制文件  保证文件无损操作  inputStream  output～
        //节点流 处理流 包装流

        //都是抽象类

        // InputStream   继承 Closeable  抽象类 不可以直接创建
        // Reader 继承Readable, Closeable 抽象类 不可以直接创建

        //

        // InputStream  常用的子类

//        FileInputStream fileInputStream = new FileInputStream(); //
//
//        ObjectInputStream objectInputStream = new ObjectInputStream();
//
//        // BufferedInputStream 的 父类 FilterInputStream -》
//        BufferedInputStream bufferedInputStream = new BufferedInputStream();


    }

    @Test // 单个字节的读取
    public void get1(){

        // 1 通过file对象进行连接 通过打开一个实际文件
        // 2. 或者是 使用文件路径 String
        String filePath = "/Users/crilv/Desktop/java项目/chapter10/text.txt";
        File file = new File(filePath);
        FileInputStream fileInputStream = null;
        try {
             fileInputStream = new FileInputStream(file);
//            FileInputStream fileInputStream1 = new FileInputStream(filePath);

            int read = 0 ;

            while ((read = fileInputStream.read()) != -1){
                System.out.println((char) read);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test // 多字节的读取  使用 read(byte[] b)
    public void get2(){

        // 1 通过file对象进行连接 通过打开一个实际文件
        // 2. 或者是 使用文件路径 String
        String filePath = "/Users/crilv/Desktop/java项目/chapter10/text.txt";
        File file = new File(filePath);
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
//            FileInputStream fileInputStream1 = new FileInputStream(filePath);

            int read = 0 ;
            byte [] bytes = new byte[8]; // 一次读8个
            int len = 0 ;
            // (fileInputStream.read(bytes) 返回实际读取的字节数
            while ((len = fileInputStream.read(bytes)) != -1){
//                for (int i = 0; i < bytes.length; i++) {
//                    System.out.println((char) bytes[i]);
//                }
                System.out.println(new String(bytes , 0  , len));  // 指定长度
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void out1(){
        // 输出流
        String filePath = "/Users/crilv/Desktop/java项目/chapter10/text3.txt";
        File file = new File(filePath);
        FileOutputStream fileOutputStream = null;
        try {

            fileOutputStream = new FileOutputStream(file , true);  // 如果文件不存在 会创建文件  append  T 追加 F 覆盖
//            fileOutputStream.write('a');  // char 跟 int 自动转换

            String a = "hello,word";
//            fileOutputStream.write(a.getBytes()); // 转换成 byte 数组


            fileOutputStream.write(a.getBytes() , 0 , a.getBytes().length); // 转换成 byte 数组  从0 到 2 -》 0 1

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
