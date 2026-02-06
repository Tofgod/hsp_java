package IO.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

public class Test01 {
    public static void main(String[] args) {

        // 文件在程序中是按照流的形式进行操作的
        // 输入流 文件数据 -》 程序内存
        // 输出流 程序内存 -〉 文件数据

        // 创建文件
        // new File()  // 传入文件路径
        // 创建新文件 createNewFile
        // File 可以串行化  可以比较
    }

    @Test
    public void create(){
        String filePath = "/Users/crilv/Desktop/java项目/chapter10/text.txt";
        File f = new File(filePath);
        try {
            f.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("创建成功");
    }

    @Test
    public void create1(){

        String filePath = "/Users/crilv/Desktop/java项目/chapter10/";
        File f = new File(filePath);
        String filePath1 = "text1.txt";
        File f1 = new File(f,filePath1);
        try {
            f1.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("创建成功");
    }

    @Test
    public void create2(){
        String filePath = "/Users/crilv/Desktop/java项目/chapter10/";
        String filePath1 = "text2.txt";
        File f1 = new File(filePath,filePath1);

        try {
            f1.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("创建成功");
    }
}


