package fei.tcc.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by thiagoretondar on 13/11/16.
 */
public class LastDatetimeUsedDto implements Serializable {

    private static final long serialVersionUID = 26707537925224248L;

    private Long userId;

    @JsonFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss")
    private LocalDateTime lastAppUsageDatetime;

    @JsonFormat(pattern = "yyyy-MM-dd'T'hh:mm:ss")
    private LocalDateTime lastLocationUsageDatetime;

    public LastDatetimeUsedDto() {
    }

    public LastDatetimeUsedDto(Long userId, LocalDateTime lastAppUsageDatetime, LocalDateTime lastLocationUsageDatetime) {
        this.userId = userId;
        this.lastAppUsageDatetime = lastAppUsageDatetime;
        this.lastLocationUsageDatetime = lastLocationUsageDatetime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getLastAppUsageDatetime() {
        return lastAppUsageDatetime;
    }

    public void setLastAppUsageDatetime(LocalDateTime lastAppUsageDatetime) {
        this.lastAppUsageDatetime = lastAppUsageDatetime;
    }

    public LocalDateTime getLastLocationUsageDatetime() {
        return lastLocationUsageDatetime;
    }

    public void setLastLocationUsageDatetime(LocalDateTime lastLocationUsageDatetime) {
        this.lastLocationUsageDatetime = lastLocationUsageDatetime;
    }
}
