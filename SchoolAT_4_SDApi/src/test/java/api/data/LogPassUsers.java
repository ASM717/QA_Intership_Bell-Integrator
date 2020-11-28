package api.data;

import java.util.HashMap;
import java.util.Map;

public class LogPassUsers {
    private String email;
    private String password;

    public LogPassUsers() {
        super();
    }

    public LogPassUsers(String email) {
        this.email = email;
    }

    public LogPassUsers(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
