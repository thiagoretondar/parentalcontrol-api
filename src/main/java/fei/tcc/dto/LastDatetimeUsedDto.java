package fei.tcc.dto;

import java.io.Serializable;

/**
 * Created by thiagoretondar on 13/11/16.
 */
public class LastDatetimeUsedDto implements Serializable {

    private static final long serialVersionUID = 26707537925224248L;

    private Long userId;

    private Long lastAppUsageDatetime;

    private Long lastLocationUsageDatetime;

    public LastDatetimeUsedDto() {
    }

    public LastDatetimeUsedDto(Long userId, Long lastAppUsageDatetime, Long lastLocationUsageDatetime) {
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

    public Long getLastAppUsageDatetime() {
        return lastAppUsageDatetime;
    }

    public void setLastAppUsageDatetime(Long lastAppUsageDatetime) {
        this.lastAppUsageDatetime = lastAppUsageDatetime;
    }

    public Long getLastLocationUsageDatetime() {
        return lastLocationUsageDatetime;
    }

    public void setLastLocationUsageDatetime(Long lastLocationUsageDatetime) {
        this.lastLocationUsageDatetime = lastLocationUsageDatetime;
    }

    @Override
    public String toString() {
        return "LastDatetimeUsedDto{" +
                "userId=" + userId +
                ", lastAppUsageDatetime=" + lastAppUsageDatetime +
                ", lastLocationUsageDatetime=" + lastLocationUsageDatetime +
                '}';
    }
}
