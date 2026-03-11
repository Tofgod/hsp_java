package netTest;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Test01 {
    public static void main(String[] args) {

        while (true){
            try {

                Scanner scanner = new Scanner(System.in);
                String next = scanner.next();

                Socket socket = new Socket(InetAddress.getLocalHost(), 9999); // 服务要链接的ip 以及端口

                OutputStream outputStream = socket.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                bufferedWriter.write(next);
                bufferedWriter.flush();
                socket.shutdownOutput();

                InputStream inputStream = socket.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String s = bufferedReader.readLine();
                System.out.println(s);

                if (s.equals("关闭")){
                    break;
                }



            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }


    @Test void receive(){
        while (true){
            try {

                ServerSocket serverSocket = new ServerSocket(9999);  // 服务的运行端口
                Socket accept = serverSocket.accept();

                InputStream inputStream = accept.getInputStream();
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String s = bufferedReader.readLine();

                OutputStream outputStream = accept.getOutputStream();
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                System.out.println(s);

                if (s.equals("name")){
                    bufferedWriter.write("nova");
                }else if (s.equals("hobby")){
                    bufferedWriter.write("编写 java程序");
                }else{
                    bufferedWriter.write("关闭");
                }

                bufferedWriter.flush();
                accept.shutdownOutput();
                accept.close();



            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


}
