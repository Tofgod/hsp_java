package QQ.server.qqService;

import QQ.client.service.UserClientService;
import QQ.model.Message;
import QQ.model.MessageType;
import QQ.model.User;
import QQ.utils.Utility;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class QQServer {
    private ServerSocket ss = null;

    //ConcurrentHashMap 可以处理并发 可以多线程安全的
    // HashMap 没有线程安全的 多线程情况下 不安全的

    private static HashMap<String , User> userDB = new HashMap<>();

    static {
        userDB.put("100",new User("100" , "12"));
        userDB.put("200",new User("200" , "12"));
        userDB.put("300",new User("300" , "12"));
        userDB.put("400",new User("400" , "12"));

    }

    public static boolean checkUser(User user){
        User user1 = userDB.get(user.getUserId());
        if (user1 == null){
            System.out.println("用户不存在");
            return false;
        }
        if (!user1.getPassword().equals(user.getPassword())){
            System.out.println("密码错误");
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        QQServer qqServer = new QQServer();
    }

    public QQServer() {
        System.out.println("9999端口监听"); // 并实时监听链接状况 加入线程 开启与用户的socket链接
        try {


            ss = new ServerSocket(9999);
            new ServerAdThread().start();

            while (true){
                System.out.println("等待链接");
                Socket accept = ss.accept();  // 这个操作是在建立链接   会阻塞  一直等待链接 直到链接上
                ObjectInputStream objectInputStream = new ObjectInputStream(accept.getInputStream());
                User user = (User) objectInputStream.readObject();

                System.out.println(user.getUserId() + "发起链接");

                Message message = new Message();

                if (checkUser(user)){
                    message.setContent("登录成功");
                    message.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                    System.out.println(user.getUserId() + "登录成功");

                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(accept.getOutputStream());
                    objectOutputStream.writeObject(message);

                    //登录成功创建线程跟客户端保持通讯
                    ServerConnectClientThread serverConnectClientThread = new ServerConnectClientThread(accept, user);
                    serverConnectClientThread.start();
                    //线程加入线程池
                    ManageServerConnectClientThread.addServerConnectClientThread(user.getUserId(),serverConnectClientThread);

                }else{
                    message.setMesType(MessageType.MESSAGE_LOGIN_FAIL);
                    message.setContent("登录失败");
                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(accept.getOutputStream());
                    objectOutputStream.writeObject(message);
                    accept.close();
                    System.out.println(user.getUserId() + "登录失败");
                }


            }


        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                ss.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
