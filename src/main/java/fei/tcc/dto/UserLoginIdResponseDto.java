package fei.tcc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by thiagoretondar on 16/11/16.
 */
public class UserLoginIdResponseDto implements Serializable {

    private static final long serialVersionUID = -5457146046208461580L;

    @JsonProperty("logged")
    private boolean logged;

    @JsonProperty("user_id")
    private Integer userId;

    public UserLoginIdResponseDto() {
    }

    public UserLoginIdResponseDto(boolean logged, Integer userId) {
        this.logged = logged;
        this.userId = userId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
