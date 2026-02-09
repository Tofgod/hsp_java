package IO.io;

import java.util.Scanner;

public class Test05 {
    public static void main(String[] args) {

        // 标准输入输出流   类型            默认设备
        // System.in     inputStream     键盘
        // System.out    outputStream   显示器

        System.out.println(
                System.in.getClass()  // class java.io.BufferedInputStream  运行类型
        );

        Scanner scanner = new Scanner(System.in);  //

        scanner.next(); // 拿到键盘输入的字节流

    }
}
