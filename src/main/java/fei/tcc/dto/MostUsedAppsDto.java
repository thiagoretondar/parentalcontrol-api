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
    private String time;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
