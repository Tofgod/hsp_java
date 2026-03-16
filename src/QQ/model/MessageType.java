package QQ.model;

public interface MessageType {

    // 不同的常量值表示不同的消息类型
    String MESSAGE_LOGIN_SUCCEED = "1";
    String MESSAGE_LOGIN_FAIL = "2";
    String MESSAGE_COMM_MES = "3";  // 普通消息
    String MESSAGE_GET_ONLINE_USERS = "4"; // 请求用户列表
    String MESSAGE_SEND_ONLINE_USERS = "5"; // 用户列表信息
    String MESSAGE_EXIT = "6"; //退出
    String MESSAGE_SEND_FOR_ALL_USERS = "7";
    String MESSAGE_SEND_FILE = "8";
    String MESSAGE_SERVER_AD = "9";

}
