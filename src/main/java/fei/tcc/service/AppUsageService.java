package fei.tcc.service;

import fei.tcc.dto.AppUsageInfoDto;
import fei.tcc.entity.AppUsageEntity;
import fei.tcc.repository.AppUsageRepository;
import org.apache.log4j.Logger;
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

    private final static int MAX_SAVING_IN_BATCH = 1000;

    private final static Logger LOGGER = Logger.getLogger(AppUsageService.class);

    @Autowired
    public AppUsageService(AppUsageRepository appUsageRepository) {
        this.appUsageRepository = appUsageRepository;
    }

    public Long saveAll(List<AppUsageInfoDto> appUsageInfoList, Long userId) {
        LOGGER.info("Received an amount of " + appUsageInfoList.size() + " app for user id " + userId);

        lastDatetime = 0L;
        appUsageInfoList.forEach(appUsage -> {
            quantityAdded = 0;
            List<AppUsageEntity> appUsageEntityList = new ArrayList<>();
            List<Long> dateTimes = appUsage.getDateTimes();

            String appName = appUsage.getAppName();
            LOGGER.info("Received an amount of " + dateTimes.size() + " datetime of app name " + appName + " for user id " + userId );

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

                if (quantityAdded == MAX_SAVING_IN_BATCH) {
                    LOGGER.info("Saving " + MAX_SAVING_IN_BATCH + " infos for user id " + userId);
                    saveAppUsageInBatchAndResetQuantityAdded(appUsageEntityList);
                }
            });

            if (!appUsageEntityList.isEmpty()) {
                LOGGER.info("Saving " + appUsageEntityList.size() + " infos for user id " + userId);
                saveAppUsageInBatchAndResetQuantityAdded(appUsageEntityList);
            }
        });

        LOGGER.info("Returning biggest date in milliseconds: " + lastDatetime + " for user id " + userId);
        return lastDatetime;
    }

    private void saveAppUsageInBatchAndResetQuantityAdded(List<AppUsageEntity> appUsageEntityList) {
        appUsageRepository.save(appUsageEntityList);
        quantityAdded = 0;
        appUsageEntityList.clear();
    }

}
