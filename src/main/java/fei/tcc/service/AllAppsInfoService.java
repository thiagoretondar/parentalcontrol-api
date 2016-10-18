package fei.tcc.service;

import fei.tcc.dto.AllAppsInfoDto;
import fei.tcc.dto.AppUsageInfoDto;
import fei.tcc.entity.AppUsageEntity;
import fei.tcc.repository.AppTotalTimeRepository;
import fei.tcc.repository.AppUsageRepository;
import fei.tcc.repository.LocationUsedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by thiagoretondar on 10/10/16.
 */
@Service
public class AllAppsInfoService {

    private AppUsageRepository appUsageRepository;

    private LocationUsedRepository locationUsedRepository;

    private AppTotalTimeRepository appTotalTimeRepository;
    private Integer quantityAdded;

    @Autowired
    public AllAppsInfoService(AppUsageRepository appUsageRepository, LocationUsedRepository locationUsedRepository,
                              AppTotalTimeRepository appTotalTimeRepository) {
        this.appUsageRepository = appUsageRepository;
        this.locationUsedRepository = locationUsedRepository;
        this.appTotalTimeRepository = appTotalTimeRepository;
    }

    public void save(AllAppsInfoDto allAppsInfoDto) {
        List<AppUsageInfoDto> appUsageInfoList = allAppsInfoDto.getAppUsageInfoList();
        appUsageInfoList.forEach(appUsage -> {
            quantityAdded = 0;

            String appName = appUsage.getAppName();
            Long userId = allAppsInfoDto.getUserId();

            List<AppUsageEntity> appUsageEntityList = new ArrayList<AppUsageEntity>();

            List<LocalDateTime> dateTimes = appUsage.getDateTimes();
            dateTimes.forEach(dateTime -> {
                AppUsageEntity appUsageEntity = new AppUsageEntity();
                appUsageEntity.setAppName(appName);
                appUsageEntity.setDateTimeUsed(dateTime);
                appUsageEntity.setUserId(userId);

                appUsageEntityList.add(appUsageEntity);
                quantityAdded++;

                if (quantityAdded == 10000) {
                    saveInBatchAndResetQuantityAdded(appUsageEntityList);
                }
            });

            if (!appUsageEntityList.isEmpty()) {
                saveInBatchAndResetQuantityAdded(appUsageEntityList);
            }

        });

    }

    private void saveInBatchAndResetQuantityAdded(List<AppUsageEntity> appUsageEntityList) {
        appUsageRepository.save(appUsageEntityList);
        quantityAdded = 0;
        appUsageEntityList.clear();
    }

}
