package fei.tcc.dto;

import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import java.util.List;

/**
 * Created by thiagoretondar on 10/10/16.
 */
public class AppUsageInfoDto implements Serializable {

    private static final long serialVersionUID = -7361830687953752697L;

    @NotEmpty
    private String appName;

    @NotEmpty
    private List<Long> dateTimes;

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public List<Long> getDateTimes() {
        return dateTimes;
    }

    public void setDateTimes(List<Long> dateTimes) {
        this.dateTimes = dateTimes;
    }

}
