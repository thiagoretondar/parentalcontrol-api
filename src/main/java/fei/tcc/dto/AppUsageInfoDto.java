package fei.tcc.dto;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by thiagoretondar on 10/10/16.
 */
public class AppUsageInfoDto implements Serializable {

    private static final long serialVersionUID = -7361830687953752697L;

    @NotEmpty
    private String appName;

    @NotEmpty
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private List<LocalDateTime> dateTimes;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public List<LocalDateTime> getDateTimes() {
        return dateTimes;
    }

    public void setDateTimes(List<LocalDateTime> dateTimes) {
        this.dateTimes = dateTimes;
    }

}
