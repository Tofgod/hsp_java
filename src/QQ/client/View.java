package QQ.client;

import QQ.client.service.UserClientService;
import QQ.model.Message;
import QQ.model.User;
import QQ.utils.Utility;
import org.junit.jupiter.api.Test;

public class View {

    private boolean loop = true; //是否显示菜单
    private String key = ""; //键盘输入
    private UserClientService userClientService ;


    public static void main(String[] args) {
        new View().mainView();
    }


    public void mainView(){
        while (loop){
            System.out.println("欢迎登录");
            System.out.println("1. 登录");
            System.out.println("9. 退出");

            System.out.print("请输入你的选择：");
            key = Utility.readString(1);

            switch (key){
                // 根据用户的输入
                case "1":
                    System.out.println("登录系统");
                    System.out.print("请输入用户 id : ");
                    String userId = Utility.readString(50);
                    System.out.print("请输入密码  :");
                    String password = Utility.readString(50);
                    // 需要到服务端该用户是否合法
                    userClientService = new UserClientService(new User(userId, password));

                    if (userClientService.checkUser()){
                        menu();
                    }else{
                        System.out.println("登录失败");
                    }

                    break;
                case "9":
                    System.out.println("退出系统");
                    loop = false;
                    break;
            }
        }
    }

    private void menu( ){
        while (loop){

            System.out.println("1.显示在线用户列表");
            System.out.println("2.群发消息");
            System.out.println("3.私聊消息");
            System.out.println("4.发送文件");
            System.out.println("9.退出系统");
            key = Utility.readString(1);

            switch (key){
                // 根据用户的输入
                case "1":
                    userClientService.getOnlineUsers();
                    System.out.println("显示在线用户");
                    break;
                case "2":
                    System.out.println("群发消息");
                    System.out.print("请输入你要发送的话 ：");
                    String content1 = Utility.readString(500);
                    userClientService.sendMessToAll(content1);
                    break;
                case "3":
                    System.out.println("私聊消息");

                    System.out.print("请输入你要发送的用户id ：");
                    String targetUserId = Utility.readString(500);
                    System.out.print("请输入你要发送的用户id的话 ：");
                    String content = Utility.readString(500);

                    userClientService.sendMessToOther(targetUserId , content );
                    break;
                case "4":
                    System.out.println("发送文件");
                    System.out.println("私聊消息");

                    System.out.print("请输入你要发送的用户id ：");
                    String targetUserId1 = Utility.readString(500);
                    System.out.print("请输入发送的文件名 ：");
                    String fileName = Utility.readString(500);
                    userClientService.sendFile(targetUserId1 , fileName );

                    break;
                case "9":
                    System.out.println("退出系统");
                    loop = false;
                    userClientService.userExit();
                    break;
            }
        }
    }
}
