package QQ.server.qqService;

import QQ.client.service.ClientConnectServerThread;
import QQ.model.User;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class ManageServerConnectClientThread {
    public static HashMap<String , ServerConnectClientThread> hm = new HashMap<>();


    public static void addServerConnectClientThread(String userId , ServerConnectClientThread serverConnectClientThread){
        hm.put(userId,serverConnectClientThread);
    }

    public static ServerConnectClientThread getServerConnectClientThread(String userId){
        return hm.get(userId);
    }

    public static ServerConnectClientThread delServerConnectClientThread(String userId){
        return hm.remove(userId);
    }

    public static HashMap <String , User> getAllOnlineUsers(){
        HashMap<String, ServerConnectClientThread> hm = ManageServerConnectClientThread.hm;
        Set<Map.Entry<String, ServerConnectClientThread>> entries = hm.entrySet();
        Iterator<Map.Entry<String, ServerConnectClientThread>> iterator = entries.iterator();

        HashMap <String , User> userDB = new HashMap<>();
        while (iterator.hasNext()) {
            Map.Entry<String, ServerConnectClientThread> next =  iterator.next();
            String userId = next.getKey(); // 在线用户的 id
            userDB.put(userId,next.getValue().getUser()); // 拿取线程的 user
        }

        return userDB;



//                      两种便利的方式
//                    Set<String> strings = hm.keySet(); // 获取所有的key
//                    for( String s :strings){
//                        ServerConnectClientThread serverConnectClientThread = hm.get(s);
//                        userDB.put(s , serverConnectClientThread.user); // 拿取线程的 user
//                    }
//
//                    Iterator<String> iterator1 = hm.keySet().iterator();
//                    while (iterator1.hasNext()) {
//                        String next =  iterator1.next();
//                    }


    }




}
