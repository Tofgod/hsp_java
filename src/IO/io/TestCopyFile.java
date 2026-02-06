package IO.io;

import org.junit.jupiter.api.Test;

import java.io.*;

public class TestCopyFile {
    public static void main(String[] args) {
        // 文件拷贝
    }

    @Test
    public void copyFile(){
        String filePath = "/Users/crilv/Desktop/java项目/chapter10/a.png";   // 源文件
        String targetPath = "/Users/crilv/Desktop/java项目/chapter10/text4.txt"; // 目标文件
        File file1 = new File(filePath);
        File file2 = new File(targetPath);

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {

            fileInputStream = new FileInputStream(file1);
            fileOutputStream = new FileOutputStream(file2);

            byte [] bytes = new byte[1024]; // 一次读取多少
            int len = 0;

            while ((len = fileInputStream.read(bytes)) != -1){
                fileOutputStream.write(bytes , 0 ,len);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                fileInputStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }



    }
}
