package File;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Test01 {
    public static void main(String[] args) {


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
                bufferedOutputStream.write(bytes);
                System.out.println(2);
            }

            bufferedOutputStream.close();
            bufferedInputStream.close();
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
                bufferedOutputStream.write(bytes);
                System.out.println(1);
            }

            bufferedOutputStream.close();
            bufferedInputStream.close();
            socket.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
