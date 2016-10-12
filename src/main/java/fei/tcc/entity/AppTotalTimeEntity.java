package fei.tcc.entity;

import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;

/**
 * Created by thiagoretondar on 10/11/16.
 */
@Entity
@Table(name = "app_total_time")
public class AppTotalTimeEntity {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private Integer id;

    @Column(name = "app_name")
    private String appName;

    @Column(name = "total_time")
    private Double totalTime;

    @Column(name = "used_id")
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public Double getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(Double totalTime) {
        this.totalTime = totalTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}
