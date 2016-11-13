package fei.tcc.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by thiagoretondar on 30/10/16.
 */
public class MostUsedAppsDto implements Serializable {

    private static final long serialVersionUID = 8076597393741920722L;

    @NotNull
    private String name;

    @NotNull
    private Integer hours;

    @NotNull
    private Integer minutes;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

}
