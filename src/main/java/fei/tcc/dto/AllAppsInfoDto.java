package fei.tcc.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * Created by thiagoretondar on 10/10/16.
 */
public class AllAppsInfoDto implements Serializable {

    private static final long serialVersionUID = -4294330496906557133L;

    @NotNull
    private List<AppUsageInfoDto> appUsageInfoList;

    @NotNull
    private List<LocationInfoDto> locationInfoList;

    public List<AppUsageInfoDto> getAppUsageInfoList() {
        return appUsageInfoList;
    }

    public void setAppUsageInfoList(List<AppUsageInfoDto> appUsageInfoList) {
        this.appUsageInfoList = appUsageInfoList;
    }

    public List<LocationInfoDto> getLocationInfoList() {
        return locationInfoList;
    }

    public void setLocationInfoList(List<LocationInfoDto> locationInfoList) {
        this.locationInfoList = locationInfoList;
    }
}
