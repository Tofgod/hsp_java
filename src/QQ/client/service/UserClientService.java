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

    public void sendFile(String targetUserId , String fileName ){

        String mkdir = "/Users/crilv/Desktop/java项目/chapter10/src/QQ/file/send/" + fileName ;
        File file = new File(mkdir);
        if (!file.exists()){
            System.out.println("要发送的文件不存在");
            return;
        }


        Message message = new Message();
        message.setSendUserId(user.getUserId());
        message.setTargetUserId(targetUserId);
        message.setMesType(MessageType.MESSAGE_SEND_FILE);
        message.setContent(fileName);
        ClientConnectServerThread clientConnectServerThread = ManageClientConnectServerThread.getClientConnectServerThread(user.getUserId());
        Socket socket = clientConnectServerThread.getSocket(); // 获取到线程内的 socket

        try {


            // 方式一
            byte[] bytes = new byte[(int)file.length()];
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(bytes); // 读入到字节数组
            message.setFileByte(bytes);
            message.setFileLen((int)file.length());
            fileInputStream.close();


            // 方式二
//            BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(mkdir));
//            byte[] bytes = new byte[1024];
//            byte[] allBytes = new byte[0];
//            int len ;
//            int allLen = 0;
//            while ((len = bufferedInputStream.read(bytes)) != -1){
//                allBytes = mergeArrays(allBytes , bytes);
//                allLen +=len;
//            }
//            message.setFileByte(allBytes);
//            message.setFileLen(allLen);
//
//            bufferedInputStream.close();
//
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(message); // 发送请求


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] mergeArrays(byte[] arr1, byte[] arr2) {
        byte[] result = new byte[arr1.length + arr2.length];
        System.arraycopy(arr1, 0, result, 0, arr1.length);
        System.arraycopy(arr2, 0, result, arr1.length, arr2.length);
        return result;
    }



}
