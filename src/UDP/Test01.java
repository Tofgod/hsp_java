package UDP;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.*;

public class Test01 {
    public static void main(String[] args) {
        // udp 数据报 不保证数据能到达  也不确定什么时候到达
        // 数据包包含了 双反的ip地址 端口 以及 内容  无需建立链接
        // udp 没有明确的服务端 客户端之分 只有 接收端发送端
        // DatagramSocket 完成了 接受分发送  发送数据 会将数据封装到 装包 DatagramPacket 对象中进行发送  接受到数据后进行拆包
        // DatagramSocket  可以指定端口等待数据
        // 最大的包是64k


    }

    @Test void  get(){
        try {

            DatagramSocket datagramSocket = new DatagramSocket(9999);
            byte[] bytes = new byte[64 * 1024];//64k
            DatagramPacket datagramPacket = new DatagramPacket(bytes , bytes.length); // 创建空数据包
            //
            System.out.println("等待接受数据");
            datagramSocket.receive(datagramPacket); // 接受并填充数据到 datagramPacket
            int length = datagramPacket.getLength();
            byte[] data = datagramPacket.getData();
            String s = new String(data, 0 , length);
            System.out.println(s);

            datagramSocket.close();

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    @Test void  send(){
        try {

            DatagramSocket datagramSocket = new DatagramSocket(9998); // 我的端口
            String s = "你好， 我是9998" ;
            byte[] bytes1 = s.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(bytes1 , bytes1.length , InetAddress.getLocalHost() , 9999); // 创建数据包指定端口
            datagramSocket.send(datagramPacket);
            datagramSocket.close();

        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }



}
