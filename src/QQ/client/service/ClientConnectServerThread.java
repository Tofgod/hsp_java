package QQ.client.service;

import QQ.model.Message;
import QQ.model.MessageType;
import QQ.model.User;


import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ClientConnectServerThread extends Thread{

    private Socket socket ;

    public ClientConnectServerThread(Socket socket) {
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        while (true){
            System.out.println("客户端持续读取服务端的消息");
            try {
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                Message msg = (Message)objectInputStream.readObject(); // 如果服务端没发消息过来 线程会阻塞

                if (msg.getMesType().equals(MessageType.MESSAGE_SEND_ONLINE_USERS)){  //好友在线用户类别
                    HashMap<String, User> userDB = msg.getUserDB();
                    Set<Map.Entry<String, User>> entries = userDB.entrySet();
                    Iterator<Map.Entry<String, User>> iterator = entries.iterator();

                    System.out.println("获取在线列表成功，内容如下");
                    while (iterator.hasNext()) {
                        Map.Entry<String, User> next =  iterator.next();
                        System.out.println(next.getKey()); // 用户名
                    }
                }else if(msg.getMesType().equals(MessageType.MESSAGE_COMM_MES)){
                    System.out.println("收到消息 来自于" + msg.getSendUserId() + "内容是 ： " + msg.getContent());
                }else if(msg.getMesType().equals(MessageType.MESSAGE_SEND_FOR_ALL_USERS)){
                    System.out.println("收到消息 来自于" + msg.getSendUserId() + "内容是 ： " + msg.getContent());
                }else if(msg.getMesType().equals(MessageType.MESSAGE_SEND_FILE)){
                    System.out.println("收到消息 来自于" + msg.getSendUserId() + "的文件：" + msg.getContent());
                    String mkdir = "/Users/crilv/Desktop/java项目/chapter10/src/QQ/file/get/" + msg.getContent() ;

                    //方式一
                    FileOutputStream fileOutputStream = new FileOutputStream(mkdir);
                    fileOutputStream.write(msg.getFileByte());
                    fileOutputStream.flush();
                    fileOutputStream.close();


//                   方式二
//                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(mkdir));
//                    bufferedOutputStream.write(msg.getFileByte());
//                    bufferedOutputStream.flush();
//                    bufferedOutputStream.close();

                }else if(msg.getMesType().equals(MessageType.MESSAGE_SERVER_AD)){
                    System.out.println("收到消息 来自于服务器的消息推送，内容是 ： " + msg.getContent());
                }


            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
