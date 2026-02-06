package IO.file;

import org.junit.jupiter.api.Test;

import java.io.File;

public class Test02 {
    public static void main(String[] args) {

    }

    @Test
    public void getInfo(){
        String filePath = "/Users/crilv/Desktop/java项目/chapter10/text.txt";
        File file = new File(filePath);

        System.out.println(file.getName());
        System.out.println(file.getAbsoluteFile()); //绝对路径
        System.out.println(file.length()); // 字节大小
        System.out.println(file.getParentFile()); // 父目录
        System.out.println(file.exists()); //是否存在
        System.out.println(file.isDirectory()); // 是不是目录
        System.out.println(file.isFile()); // 是不是文件
    }

    @Test
    public void setDri(){
        // 创建目录
        String filePath = "/Users/crilv/Desktop/java项目/chapter10/text.txt";
        File file = new File(filePath);
        if (file.exists()){
           if ( file.delete()){
               System.out.println("删除成功");
           }
        }

        //  file.mkdir() // 创建目录   多级目录不存在 就失败
        //  file.mkdirs() // 创建目录  多级目录可以不存在 也会成功

    }




}
