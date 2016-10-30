package fei.tcc.service;

import fei.tcc.dto.AllAppsInfoDto;
import fei.tcc.entity.AppUsageEntity;
import fei.tcc.entity.LocationUsedEntity;
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

        saveAllAppsInfo(allAppsInfoDto);

        saveAllLocationInfo(allAppsInfoDto);

    }

    private void saveAllLocationInfo(AllAppsInfoDto allAppsInfoDto) {
        List<LocationUsedEntity> locationUsedEntityList = new ArrayList<>();
        Long userId = allAppsInfoDto.getUserId();

        allAppsInfoDto.getLocationInfoList().forEach(locationInfo -> {
            locationUsedEntityList.add(new LocationUsedEntity(
                    locationInfo.getDatetime(),
                    locationInfo.getLatitude(),
                    locationInfo.getLongitude(),
                    userId
            ));
        });

        locationUsedRepository.save(locationUsedEntityList);
    }

    private void saveAllAppsInfo(AllAppsInfoDto allAppsInfoDto) {
        allAppsInfoDto.getAppUsageInfoList().forEach(appUsage -> {
            quantityAdded = 0;

            String appName = appUsage.getAppName();
            Long userId = allAppsInfoDto.getUserId();

            List<AppUsageEntity> appUsageEntityList = new ArrayList<>();

            List<LocalDateTime> dateTimes = appUsage.getDateTimes();
            dateTimes.forEach(dateTime -> {
                AppUsageEntity appUsageEntity = new AppUsageEntity();
                appUsageEntity.setAppName(appName);
                appUsageEntity.setDateTimeUsed(dateTime);
                appUsageEntity.setUserId(userId);

                appUsageEntityList.add(appUsageEntity);
                quantityAdded++;

                if (quantityAdded == 10000) {
                    saveAppUsageInBatchAndResetQuantityAdded(appUsageEntityList);
                }
            });

            if (!appUsageEntityList.isEmpty()) {
                saveAppUsageInBatchAndResetQuantityAdded(appUsageEntityList);
            }

        });
    }

    private void saveAppUsageInBatchAndResetQuantityAdded(List<AppUsageEntity> appUsageEntityList) {
        appUsageRepository.save(appUsageEntityList);
        quantityAdded = 0;
        appUsageEntityList.clear();
    }

}
