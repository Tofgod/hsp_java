package network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

public class Test01 {
    public static void main(String[] args) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println(localHost); // 获取本机 ip 地址
            InetAddress loopbackAddress = InetAddress.getLoopbackAddress();
            System.out.println(loopbackAddress);
            InetAddress lms = InetAddress.getByName("LM");
            System.out.println( "" + lms);

            InetAddress allByName = InetAddress.getByName("www.baidu.com");
            System.out.println(allByName);

            String hostName = allByName.getHostName();
            String hostAddress = allByName.getHostAddress(); // 获取主机地址
            System.out.println(hostAddress);


        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}
