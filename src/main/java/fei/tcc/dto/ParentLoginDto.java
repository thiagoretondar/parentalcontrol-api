package fei.tcc.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by thiagoretondar on 10/1/16.
 */
public class ParentLoginDto implements Serializable {

    private static final long serialVersionUID = 9050568808240031898L;

    @NotNull(message = "Username field cannot be null")
    private String username;

    @NotNull(message = "Password field cannot be null")
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
