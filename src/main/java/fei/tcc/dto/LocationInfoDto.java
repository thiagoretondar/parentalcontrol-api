package fei.tcc.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Created by thiagoretondar on 10/10/16.
 */
public class LocationInfoDto implements Serializable {

    private static final long serialVersionUID = 2546732389189334144L;

    @NotNull
    private Double positionX;

    @NotNull
    private Double positionY;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Double getPositionX() {
        return positionX;
    }

    public void setPositionX(Double positionX) {
        this.positionX = positionX;
    }

    public Double getPositionY() {
        return positionY;
    }

    public void setPositionY(Double positionY) {
        this.positionY = positionY;
    }

}