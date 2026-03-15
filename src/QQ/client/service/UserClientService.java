package QQ.client.service;

import QQ.model.Message;
import QQ.model.MessageType;
import QQ.model.User;
import QQ.utils.Utility;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Vector;

public class UserClientService {

    private User user = null;

    public UserClientService(User user) {
        this.user = user;
    }

    public boolean checkUser(){
        boolean b = false;

        try {

            Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(this.user);

            //读取 message 对象
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Message msg = (Message) objectInputStream.readObject();
            System.out.println(msg.getContent());
            System.out.println(msg.getMesType());

            if (msg.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){
                b = true;
                ClientConnectServerThread clientConnectServerThread = new ClientConnectServerThread(socket);
                clientConnectServerThread.start();
                //线程加入线程池
                ManageClientConnectServerThread.addClientConnectServerThread(this.user.getUserId() , clientConnectServerThread);
            }else {
                socket.close();
            }

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return b;
    }

    public void getOnlineUsers(){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLINE_USERS);
        message.setSendUserId(user.getUserId());
        sendMess(message);
    }

    public void userExit(){
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_EXIT);
        message.setSendUserId(user.getUserId());
        sendMess(message);
        System.exit(0); //关闭进程 所有线程会关闭
    }

    public void sendMessToOther(String targetUserId , String content){

        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_COMM_MES);
        message.setSendUserId(user.getUserId());
        message.setTargetUserId(targetUserId);
        message.setContent(content);
        sendMess(message);
    }

    public void sendMessToAll(String content){

        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_SEND_FOR_ALL_USERS);
        message.setSendUserId(user.getUserId());
        message.setContent(content);
        sendMess(message);
    }

    public void sendMess(Message message){
        message.setSendUserId(user.getUserId());
        ClientConnectServerThread clientConnectServerThread = ManageClientConnectServerThread.getClientConnectServerThread(user.getUserId());
        Socket socket = clientConnectServerThread.getSocket(); // 获取到线程内的 socket

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(message); // 发送请求
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
