package network;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Test02 {
    public static void main(String[] args) {
        // tcp 编程 udp 编程
        try {
            ServerSocket serverSocket = new ServerSocket(9999);

            System.out.println("监听9999 等待链接");


            // 可以创建多个 accept 多并发
            Socket accept = serverSocket.accept();

            System.out.println(accept.getClass() + "链接成功");

            InputStream inputStream = accept.getInputStream();

            byte[] bytes = new byte[1024];
            int redline = 0 ;
            while ((redline = inputStream.read(bytes)) != -1){
                System.out.println(new String(bytes , 0 , redline));
            }

            inputStream.close();
            accept.close();
            serverSocket.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
