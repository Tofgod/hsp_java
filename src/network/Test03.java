package network;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class Test03 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
            System.out.println("链接成功");

            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("hello,aaa".getBytes());

            outputStream.close();
            socket.close();

            System.out.println("客户端退出");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
