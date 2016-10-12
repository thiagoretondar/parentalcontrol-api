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
import java.util.List;

/**
 * Created by thiagoretondar on 10/10/16.
 */
@Service
public class AllAppsInfoService {

    private AppUsageRepository appUsageRepository;

    private LocationUsedRepository locationUsedRepository;

    private AppTotalTimeRepository appTotalTimeRepository;

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
            String appName = appUsage.getAppName();

            List<LocalDateTime> dateTimes = appUsage.getDateTimes();
            dateTimes.forEach(dateTime -> {
                AppUsageEntity appUsageEntity = new AppUsageEntity();
                appUsageEntity.setAppName(appName);
                appUsageEntity.setDateTimeUsed(dateTime);
                // TODO best way of saving this is by one or by batch?
                //appUsageRepository.save(appUsageEntity);
            });
        });

    }

}
