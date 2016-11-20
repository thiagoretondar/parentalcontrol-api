package fei.tcc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by thiagoretondar on 20/11/16.
 */
public class ParentLoginIdResponseDto {

    @JsonProperty("logged")
    private boolean logged;

    @JsonProperty("parent_id")
    private Long parent_id;

    public ParentLoginIdResponseDto() {
    }

    public ParentLoginIdResponseDto(boolean logged, Long parent_id) {
        this.logged = logged;
        this.parent_id = parent_id;
    }

    public boolean isLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }
}
