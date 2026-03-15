package QQ.model;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 1L; // 增强序列化

    private String userId ;
    private String password ;

    public User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
