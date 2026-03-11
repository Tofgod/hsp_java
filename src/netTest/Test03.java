package netTest;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Test03 {
    public static void main(String[] args) {

    }


    @Test void khd(){
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
            OutputStream outputStream = socket.getOutputStream();
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
            bufferedWriter.write("1");
            bufferedWriter.flush();

            socket.shutdownOutput();
            //socket.shutdownOutput() 是 Java 中 Socket 类提供的一
            // 个方法，用于关闭当前套接字的输出流，
            // 但保持输入流仍然打开。这一操作通常被称为半关闭（half-close），
            // 允许一端停止发送数据，而仍能接收来自另一端的数据。
            //不可逆性：一旦调用 shutdownOutput()，就无法重新启用输出流。如果需要重新发送数据，必须建立新的连接。


            InputStream inputStream = socket.getInputStream();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

            FileOutputStream fileOutputStream = new FileOutputStream("D:\\JavaProject\\hsp_java\\c.png");
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);


            byte[] bytes = new byte[1024];
            int len = 0 ;
            while ((len = bufferedInputStream.read(bytes)) != -1){
                bufferedOutputStream.write(bytes,0,len);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Test void serve(){
        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String s = bufferedReader.readLine();

            System.out.println(s);

            String fileName = "";
            if (s.equals("1")){
                fileName= "D:\\JavaProject\\hsp_java\\a.png";
            }else{
                fileName= "D:\\JavaProject\\hsp_java\\d.png";
            }

            OutputStream outputStream = accept.getOutputStream();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);

            FileInputStream fileInputStream = new FileInputStream(fileName);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            byte[] bytes = new byte[1024];
            int len = 0 ;
            while ((len = bufferedInputStream.read(bytes)) != -1){
                bufferedOutputStream.write(bytes,0,len);
            }
            bufferedOutputStream.flush();

            accept.shutdownOutput();




        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
