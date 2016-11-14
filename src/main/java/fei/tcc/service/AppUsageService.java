package fei.tcc.service;

import fei.tcc.dto.AppUsageInfoDto;
import fei.tcc.entity.AppUsageEntity;
import fei.tcc.repository.AppUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

import static java.time.Instant.ofEpochMilli;

/**
 * Created by thiagoretondar on 30/10/16.
 */
@Service
public class AppUsageService {

    private AppUsageRepository appUsageRepository;

    private Integer quantityAdded;

    private long lastDatetime;

    @Autowired
    public AppUsageService(AppUsageRepository appUsageRepository) {
        this.appUsageRepository = appUsageRepository;
    }

    public Long saveAll(List<AppUsageInfoDto> appUsageInfoList, Long userId) {
        lastDatetime = 0L;
        appUsageInfoList.forEach(appUsage -> {
            quantityAdded = 0;

            String appName = appUsage.getAppName();

            List<AppUsageEntity> appUsageEntityList = new ArrayList<>();

            List<Long> dateTimes = appUsage.getDateTimes();
            dateTimes.forEach(dateTime -> {
                LocalDateTime dateTimeConverted = ofEpochMilli(dateTime).atZone(ZoneId.systemDefault()).toLocalDateTime();
                AppUsageEntity appUsageEntity = new AppUsageEntity();
                appUsageEntity.setAppName(appName);
                appUsageEntity.setDateTimeUsed(dateTimeConverted);
                appUsageEntity.setUserId(userId);

                appUsageEntityList.add(appUsageEntity);
                quantityAdded++;

                if (dateTime.longValue() > lastDatetime) {
                    lastDatetime = dateTime;
                }

                if (quantityAdded == 10000) {
                    saveAppUsageInBatchAndResetQuantityAdded(appUsageEntityList);
                }
            });

            if (!appUsageEntityList.isEmpty()) {
                saveAppUsageInBatchAndResetQuantityAdded(appUsageEntityList);
            }
        });

        return lastDatetime;
    }

    private void saveAppUsageInBatchAndResetQuantityAdded(List<AppUsageEntity> appUsageEntityList) {
        appUsageRepository.save(appUsageEntityList);
        quantityAdded = 0;
        appUsageEntityList.clear();
    }

}
