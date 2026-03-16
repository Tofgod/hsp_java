package QQ.server.qqService;

import QQ.model.Message;
import QQ.model.MessageType;
import QQ.utils.Utility;

import java.util.Iterator;

public class ServerAdThread extends Thread{

    private boolean loop = true; //是否显示菜单
    private String key = ""; //键盘输入

    @Override
    public void run() {
        while (loop){
            System.out.println("服务器启动");
            System.out.println("1. 消息推送");
            System.out.println("9. 关闭服务器");

            System.out.println("请输入你的选择：");
            key = Utility.readString(1);

            switch (key){
                // 消息推送
                case "1":
                    System.out.print("请输入要发送给全部用户的信息：");
                    String content = Utility.readString(500);
                    sendMesForAll(content);
                    break;
                case "9":
                    System.out.println("关闭服务器"); // 待完成
                    loop = false;
                    break;
            }
        }
    }

    public void sendMesForAll(String content){
        Message message = new Message();
        message.setContent(content);
        message.setMesType(MessageType.MESSAGE_SERVER_AD);
        Iterator<String> iterator = ManageServerConnectClientThread.hm.keySet().iterator();
        while (iterator.hasNext()) {
            String next =  iterator.next();
            ServerConnectClientThread serverConnectClientThread = ManageServerConnectClientThread.getServerConnectClientThread(next);
            serverConnectClientThread.sendMessage(message);
        }
    }
}
