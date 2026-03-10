package TCP;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Test01 {
    public static void main(String[] args) {
        // netstat cmd指令 查看当前电脑的端口运行情况   -an    | more  分页显示

        // 客服端跟服务的进行链接的时候 客户端也是由端口的 是由tcp ip协议自动创建随机端口

    }

    @Test void get(){
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

            FileOutputStream fileOutputStream = new FileOutputStream("D:\\JavaProject\\hsp_java\\b.png");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

            byte[] bytes = new byte[1024];
            int len = 0 ;
            while ((len = bufferedInputStream.read(bytes)) != -1){
                bufferedOutputStream.write(bytes);         // 边度边写
//                System.out.println(2);
            }




            OutputStream outputStream = accept.getOutputStream();
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write("签收完毕");
            bufferedWriter.flush(); // 把内容刷新到通道


            accept.shutdownOutput();


//            bufferedWriter.close();
//            bufferedInputStream.close();
//            bufferedOutputStream.close();
            accept.close();
            serverSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Test void send(){
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 9999);

            FileInputStream fileInputStream = new FileInputStream("D:\\JavaProject\\hsp_java\\a.png");
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);

            OutputStream outputStream = socket.getOutputStream();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

            byte[] bytes = new byte[1024];
            int len = 0 ;
            while ((len = bufferedInputStream.read(bytes)) != -1){
//                Thread.sleep(1000);
                bufferedOutputStream.write(bytes);
//                System.out.println(1);
            }

            socket.shutdownOutput();

            InputStream inputStream = socket.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String s = bufferedReader.readLine();
            System.out.println(s);


//            bufferedOutputStream.close();
//            bufferedInputStream.close();
            socket.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
