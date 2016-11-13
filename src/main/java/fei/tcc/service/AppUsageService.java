package fei.tcc.service;

import fei.tcc.dto.AppUsageInfoDto;
import fei.tcc.entity.AppUsageEntity;
import fei.tcc.repository.AppUsageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thiagoretondar on 30/10/16.
 */
@Service
public class AppUsageService {

    private AppUsageRepository appUsageRepository;

    private Integer quantityAdded;

    private LocalDateTime lastDatetime;

    @Autowired
    public AppUsageService(AppUsageRepository appUsageRepository) {
        this.appUsageRepository = appUsageRepository;
    }

    public LocalDateTime saveAll(List<AppUsageInfoDto> appUsageInfoList, Long userId) {
        lastDatetime = LocalDateTime.of(1900, Month.JANUARY, 1, 0, 0);
        appUsageInfoList.forEach(appUsage -> {
            quantityAdded = 0;

            String appName = appUsage.getAppName();

            List<AppUsageEntity> appUsageEntityList = new ArrayList<>();

            List<LocalDateTime> dateTimes = appUsage.getDateTimes();
            dateTimes.forEach(dateTime -> {
                AppUsageEntity appUsageEntity = new AppUsageEntity();
                appUsageEntity.setAppName(appName);
                appUsageEntity.setDateTimeUsed(dateTime);
                appUsageEntity.setUserId(userId);

                appUsageEntityList.add(appUsageEntity);
                quantityAdded++;

                if (dateTime.isAfter(lastDatetime)) {
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
