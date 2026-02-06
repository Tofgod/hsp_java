package IO.io;

import org.junit.jupiter.api.Test;

import java.io.*;

public class Test02 {
    public static void main(String[] args) {


        //FileReader -> InputStreamReader -> Reader

        // FileReader 入参 File  String 路径

        // FileWriter 字符输出流

    }
    @Test  // 类比字节流即可
    public void get (){

        String filePath = "/Users/crilv/Desktop/java项目/chapter10/text3.txt";
        File file = new File(filePath);

        FileReader fileReader = null;
        try {
             fileReader = new FileReader(file);

             char [] chars = new char[8];
             int len = 0;

             while ((len = fileReader.read(chars)) != -1){
                 System.out.println(new String(chars , 0 , len));
             }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test  // 类比字节流即可
    public void set (){

        String filePath = "/Users/crilv/Desktop/java项目/chapter10/text5.txt";
        File file = new File(filePath);

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);

            fileWriter.write('a');
            fileWriter.write("231");
            fileWriter.write(new char[]{'a','6'} , 0 ,1);
            fileWriter.write("2313132131",0,5);

            // 写完必须刷新 或者关闭 否则无法写入
//            fileWriter.close();
            fileWriter.flush(); //刷新



        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
