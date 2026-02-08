package IO.io;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Test03 {
    public static void main(String[] args) {
        // 节点流 对文件操作 对特定的数据源 进行操作  文件 数组
        // 处理流  包装流  链接已经存在的节点流

        //  BufferedReader  Reader 的一个子类

        // BufferedInputStream   同理  字节
        // BufferedOutputStream  同理  字节




    }

    @Test
    public void get(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\JavaProject\\hsp_java\\Text5.txt"));
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);

            }

            bufferedReader.close(); //

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void set(){
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\JavaProject\\hsp_java\\Text5.txt" , true));
            String line = "你好你好你好你好你好你好你好";
            bufferedWriter.newLine();
            bufferedWriter.write(line);


            bufferedWriter.close(); //

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void cop(){
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\JavaProject\\hsp_java\\Text5.txt"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("D:\\JavaProject\\hsp_java\\Text6.txt" ));
            String line = "";
            while ((line = bufferedReader.readLine()) != null){
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

            bufferedReader.close(); //
            bufferedWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    public void cop1(){

        try {
//            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("D:\\JavaProject\\hsp_java\\Text6.txt"));
//            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("D:\\JavaProject\\hsp_java\\Text7.txt"));

            BufferedInputStream bufferedInputStream = new BufferedInputStream(Files.newInputStream(Paths.get("D:\\JavaProject\\hsp_java\\Text6.txt")));
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(Files.newOutputStream(Paths.get("D:\\JavaProject\\hsp_java\\Text7.txt")));
            byte[] bytes = new byte[8];
            int len;

            while ((len = bufferedInputStream.read(bytes)) != -1){
                bufferedOutputStream.write(bytes , 0 , len);
            }

            bufferedInputStream.close();
            bufferedOutputStream.close();


        }  catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
