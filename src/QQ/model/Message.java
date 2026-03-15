package QQ.model;


import sun.dc.pr.PRError;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 消息对象
 * */
public class Message implements Serializable {

    private static final long serialVersionUID = 1L; // 增强序列化

    private String targetUserId;
    private String sendUserId;
    private String content;
    private String sendTime;

    private String mesType; // [接口中定义消息类型]

    private HashMap<String , User> userDB = new HashMap<>();

    public HashMap<String, User> getUserDB() {
        return userDB;
    }

    public void setUserDB(HashMap<String, User> userDB) {
        this.userDB = userDB;
    }

    public String getMesType() {
        return mesType;
    }

    public void setMesType(String mesType) {
        this.mesType = mesType;
    }

    public String getSendUserId() {
        return sendUserId;
    }

    public void setSendUserId(String sendUserId) {
        this.sendUserId = sendUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getTargetUserId() {
        return targetUserId;
    }

    public void setTargetUserId(String targetUserId) {
        this.targetUserId = targetUserId;
    }
}
