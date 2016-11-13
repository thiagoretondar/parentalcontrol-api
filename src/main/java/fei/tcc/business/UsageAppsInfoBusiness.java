package fei.tcc.business;

import fei.tcc.dto.AllAppsInfoDto;
import fei.tcc.dto.LastDatetimeUsedDto;
import fei.tcc.service.AppLocationInfoService;
import fei.tcc.service.AppMostUsedService;
import fei.tcc.service.AppUsageService;
import fei.tcc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/**
 * Created by thiagoretondar on 30/10/16.
 */
@Service
public class UsageAppsInfoBusiness {

    private UserService userService;

    private AppUsageService appUsageService;

    private AppLocationInfoService appLocationInfoService;

    private AppMostUsedService appMostUsedService;

    @Autowired
    public UsageAppsInfoBusiness(UserService userService, AppUsageService appUsageService,
                                 AppLocationInfoService appLocationInfoService, AppMostUsedService appMostUsedService) {
        this.userService = userService;
        this.appUsageService = appUsageService;
        this.appLocationInfoService = appLocationInfoService;
        this.appMostUsedService = appMostUsedService;
    }

    public LastDatetimeUsedDto save(AllAppsInfoDto allAppsInfoDto) {
        Long userId = allAppsInfoDto.getUserId();

        if (userService.existsUserWithId(userId)) {
            // TODO refactor: maybe create a general exception to try any of those actions
            LocalDateTime lastAppUsageDatetime = appUsageService.saveAll(allAppsInfoDto.getAppUsageInfoList(), userId);
            LocalDateTime lastLocationUsageDatetime = appLocationInfoService.saveAll(allAppsInfoDto.getLocationInfoList(), userId);
            appMostUsedService.saveAll(allAppsInfoDto.getMostUsedAppsList(), userId);

            return new LastDatetimeUsedDto(userId, lastAppUsageDatetime, lastLocationUsageDatetime);
        }

        return new LastDatetimeUsedDto();

    }

}
