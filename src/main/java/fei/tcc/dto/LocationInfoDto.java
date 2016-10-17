package fei.tcc.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by thiagoretondar on 10/10/16.
 */
public class LocationInfoDto implements Serializable {

    private static final long serialVersionUID = 2546732389189334144L;

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

}
