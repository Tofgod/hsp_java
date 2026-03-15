package QQ.server.qqService;

import QQ.client.service.ManageClientConnectServerThread;
import QQ.model.Message;
import QQ.model.MessageType;
import QQ.model.User;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ServerConnectClientThread extends Thread{

    private Socket socket  ;
    private User user;

    public ServerConnectClientThread(Socket socket, User user) {
        this.socket = socket;
        this.user = user;
    }

    @Override
    public void run() { // 可以发送 接受消息
        while (true){
            try {
                InputStream inputStream = socket.getInputStream();

                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                Message msg = (Message)objectInputStream.readObject();

                if (msg.getMesType().equals(MessageType.MESSAGE_GET_ONLINE_USERS)){
                    System.out.println(msg.getSendUserId() + "要获取在线用户列表");
                    Message message = new Message();
                    message.setUserDB(ManageServerConnectClientThread.getAllOnlineUsers());
                    message.setMesType(MessageType.MESSAGE_SEND_ONLINE_USERS);
                    sendMessage(message);
                    System.out.println("发送列表成功");
                } else if (msg.getMesType().equals(MessageType.MESSAGE_EXIT)){
                    socket.close();
                    System.out.println("结束了跟用户" + msg.getSendUserId() + "的 socket链接");
                    ManageServerConnectClientThread.delServerConnectClientThread(msg.getSendUserId());
                    System.out.println("删除了跟用户" + msg.getSendUserId() + "的 线程 ");
                    break;
                } else if(msg.getMesType().equals(MessageType.MESSAGE_COMM_MES)){
                    String targetUserId = msg.getTargetUserId();
                    //获取目标线程转发用户的消息
                    System.out.println("接受到" + msg.getSendUserId() + "向" +  msg.getTargetUserId() + "发送的消息：" + msg.getContent() );
                    ServerConnectClientThread serverConnectClientThread = ManageServerConnectClientThread.getServerConnectClientThread(targetUserId);
                    //将消息存起来
                    if(serverConnectClientThread != null){  // 如果用户在线
                        serverConnectClientThread.sendMessage(msg); // 发送消息
                    }
                }else if(msg.getMesType().equals(MessageType.MESSAGE_SEND_FOR_ALL_USERS)){
                    String targetUserId = msg.getTargetUserId();
                    //获取目标线程转发用户的消息
                    System.out.println("接受到" + msg.getSendUserId() + "向" +  msg.getTargetUserId() + "发送的消息：" + msg.getContent() );
                    ServerConnectClientThread serverConnectClientThread = ManageServerConnectClientThread.getServerConnectClientThread(targetUserId);
                    //将消息存起来
                    if(serverConnectClientThread != null){  // 如果用户在线
                        serverConnectClientThread.sendMessage(msg); // 发送消息
                    }
                }




            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }

        }
    }

    private void sendMessage(Message msg){
        try {
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(msg);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public Socket getSocket() {
        return socket;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
