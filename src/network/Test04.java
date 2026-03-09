package network;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Test04 {
    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(9999);
            Socket accept = serverSocket.accept();


            InputStream inputStream = accept.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String s = bufferedReader.readLine();
            System.out.println(s);

            bufferedReader.close();
            accept.close();
            serverSocket.close();

//            OutputStream outputStream = accept.getOutputStream();
//            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
//            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);



        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Test void p(){
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), 9999);


            OutputStream outputStream = socket.getOutputStream();

            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write("你好");
            bufferedWriter.newLine(); // 表示写入的内容结束  要求对方使用readLine(); 来读取
            bufferedWriter.flush();

            bufferedWriter.close();
            socket.close();



//            InputStream inputStream = socket.getInputStream();
//            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
