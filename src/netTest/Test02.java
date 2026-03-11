package netTest;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Test02 {

    @Test void AA(){
        try {
            DatagramSocket datagramSocket = new DatagramSocket(9998);
            String s = "aaaa";
            byte[] bytes1 = s.getBytes();
            DatagramPacket datagramPacket = new DatagramPacket(bytes1, bytes1.length , InetAddress.getLocalHost() , 9999);
            datagramSocket.send(datagramPacket);

            byte[] bytes = new byte[64 * 1024];
            DatagramPacket datagramPacket1 = new DatagramPacket(bytes, bytes.length);
            datagramSocket.receive(datagramPacket1);
            int length = datagramPacket1.getLength();
            byte[] data = datagramPacket1.getData();
            String s1 = new String(data, 0, length);
            System.out.println(s1);


        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test void BB(){
        try {
            DatagramSocket datagramSocket = new DatagramSocket(9999);
            byte[] bytes = new byte[64 * 1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
            datagramSocket.receive(datagramPacket);
            int length = datagramPacket.getLength();
            byte[] data = datagramPacket.getData();
            String s = new String(data, 0, length);
            System.out.println(s);

            String s1 = "aaaa11";
            byte[] bytes1 = s1.getBytes();
            DatagramPacket datagramPacket1= new DatagramPacket(bytes1, bytes1.length , InetAddress.getLocalHost() , 9998);
            datagramSocket.send(datagramPacket1);


        } catch (SocketException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
