package fei.tcc.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by thiagoretondar on 10/10/16.
 */
public class LocationInfoDto implements Serializable {

    private static final long serialVersionUID = 2546732389189334144L;

    @NotNull
    @JsonProperty("lat")
    private Double latitude;

    @NotNull
    @JsonProperty("lon")
    private Double longitude;

    @NotEmpty
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    @JsonProperty("datetime")
    private LocalDateTime datetime;

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

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }
}
