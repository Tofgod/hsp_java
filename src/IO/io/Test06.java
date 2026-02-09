package IO.io;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Test06 {
    public static void main(String[] args) {
        // 转换流
        // 字节流 字符流 转换



    }


    @Test
    public void get(){

        String path = "/Users/crilv/Desktop/java项目/chapter10/Text7.txt";

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(path));

            // 乱码问题 没有指定读取文件的编码方式
            // 解决 在读取字节流指定编码  再通过转换流 进行转换

            String s =  bufferedReader.readLine(); // 默认情况下读取文件 使用 utf-8 读取  ， 如果编码发生问题 就会出现乱码
            System.out.println(s);

            //  InputStreamReader
            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path));
            new InputStreamReader(bufferedInputStream, StandardCharsets.UTF_8); // 传入第二个参数 设定编码方式  将字节流转换成字符流


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void get1(){

        String path = "/Users/crilv/Desktop/java项目/chapter10/Text7.txt";

        try {

            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(path));
            InputStreamReader inputStreamReader = new InputStreamReader(bufferedInputStream, "gbk");// 传入第二个参数 设定编码方式  将字节流转换成字符流
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader); //  将转换流放入到包装流  解决编码问题
            System.out.println(bufferedReader.readLine());
            bufferedReader.close();

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void swt(){
        String path = "/Users/crilv/Desktop/java项目/chapter10/Text7.txt";

        try {

            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(path));
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(bufferedOutputStream, "gbk");// 传入第二个参数 设定编码方式  将字节流转换成字符流
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter); //  将转换流放入到包装流  解决编码问题
            bufferedWriter.write("2131,你好你好你好");
            bufferedWriter.close(); //文件写入

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
