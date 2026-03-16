package QQ.server.qqService;

import QQ.model.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class UsersMessages {

    //考虑线程安全 使用 线程安全的 map list
    // ConcurrentHashMap
    public static HashMap<String , ArrayList<Message>> usersMessages = new HashMap<>();


    public static ArrayList<Message> getUserMes(String userId){
        return usersMessages.get(userId);
    }

    public static void setUserMes(String userId , Message message ){
        ArrayList<Message> messages = usersMessages.get(userId);
        if (messages == null){
            ArrayList<Message> messagesList = new ArrayList<>();
            messagesList.add(message);
            usersMessages.put(userId,messagesList);
        }else{
            messages.add(message);
            usersMessages.put(userId,messages);
        }
    }

    public static ArrayList<Message> delUserMes(String userId){
        return usersMessages.remove(userId);
    }







}
