package fei.tcc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by thiagoretondar on 16/11/16.
 */
public class UserLoginIdResponseDto implements Serializable {

    private static final long serialVersionUID = -5457146046208461580L;

    @JsonProperty("registered")
    private boolean registered;

    @JsonProperty("user_id")
    private Long userId;

    public UserLoginIdResponseDto() {
    }

    public UserLoginIdResponseDto(boolean logged, Long userId) {
        this.registered = logged;
        this.userId = userId;
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
