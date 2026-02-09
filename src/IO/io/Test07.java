package IO.io;

import org.junit.jupiter.api.Test;

import java.io.*;

public class Test07 {
    public static void main(String[] args) {
        // 打印流 只有输出流  打印内容到指定位置


    }

    @Test
    public void set(){

        String path = "/Users/crilv/Desktop/java项目/chapter10/Text8.txt";
        PrintStream printStream = System.out;
        printStream.print("1  ");  // 默认在控制台
        try {
            System.setOut(new PrintStream(path));  // 这样也可以
            System.out.print("1");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

//        try {
//            PrintStream printStream = new PrintStream(path);
//            printStream.write('1');
//            printStream.close();
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }

    }


    @Test
    public  void  set1(){

//        PrintWriter printWriter = new PrintWriter(System.out);
//        printWriter.println("1");
//        printWriter.close();  // 默认在控制台
        String path = "/Users/crilv/Desktop/java项目/chapter10/Text9.txt";
        try {
            PrintWriter printWriter = new PrintWriter(path);
            printWriter.write("1");
            printWriter.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
