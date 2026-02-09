package IO.prpperties;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.Properties;

public class Test01 {
    public static void main(String[] args) {
        // 从 xxx.properties 文件读取数据 内容 id=1
        Properties properties = new Properties();
    }

    @Test
    public void set(){
        Properties properties = new Properties();
//        properties.setProperty("id","1111111");  // 如果是中文 会变成 Unicode 码
        try {
            properties.load(new FileReader("/Users/crilv/Desktop/java项目/chapter10/a.properties")); //读取
            System.out.println(properties.getProperty("id"));
            properties.setProperty("id","1111111");
            properties.setProperty("name","你好");
            // properties.store(new FileOutputStream("/Users/crilv/Desktop/java项目/chapter10/a.properties") , null) ; //修改 null 是注释
            properties.store(new FileOutputStream("/Users/crilv/Desktop/java项目/chapter10/a.properties") , "123111") ; //修改 第二个参数 是注释

            properties.list(System.out);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
