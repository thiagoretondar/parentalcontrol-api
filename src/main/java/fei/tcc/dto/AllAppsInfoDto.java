package fei.tcc.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Created by thiagoretondar on 10/10/16.
 */
public class AllAppsInfoDto implements Serializable {

    private static final long serialVersionUID = -4294330496906557133L;

    private AppUsageInfoDto appUsageInfoDto;

    private List<LocationInfoDto> locationInfoDto;

    public AppUsageInfoDto getAppUsageInfoDto() {
        return appUsageInfoDto;
    }

    public void setAppUsageInfoDto(AppUsageInfoDto appUsageInfoDto) {
        this.appUsageInfoDto = appUsageInfoDto;
    }

    public List<LocationInfoDto> getLocationInfoDto() {
        return locationInfoDto;
    }

    public void setLocationInfoDto(List<LocationInfoDto> locationInfoDto) {
        this.locationInfoDto = locationInfoDto;
    }

}
