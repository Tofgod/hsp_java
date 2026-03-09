package network;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Test022 {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
            byte[] bytes = new byte[1024];
            int len = 0 ;
            while ((len = inputStream.read(bytes)) != -1){
                System.out.println(new String(bytes , 0 , len));
            }


            OutputStream outputStream = accept.getOutputStream();
            outputStream.write("2222".getBytes());

            accept.shutdownOutput(); // 结束标记


            outputStream.close();
            inputStream.close();
            accept.close();
            serverSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test void p(){
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("nihao , 111".getBytes());

            socket.shutdownOutput(); // 结束标记

            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len = 0 ;
            while ((len = inputStream.read(bytes)) != -1){
                System.out.println(new String(bytes , 0 , len));
            }


            outputStream.close();
            inputStream.close();
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
