package fei.tcc.business;

import fei.tcc.dto.AllAppsInfoDto;
import fei.tcc.service.AppLocationInfoService;
import fei.tcc.service.AppMostUsedService;
import fei.tcc.service.AppUsageService;
import fei.tcc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void save(AllAppsInfoDto allAppsInfoDto) {

        Long userId = allAppsInfoDto.getUserId();

        if (userService.existsUserWithId(userId)) {
            // TODO refactor: maybe create a general exception to try any of those actions
            appUsageService.saveAll(allAppsInfoDto.getAppUsageInfoList(), userId);
            appLocationInfoService.saveAll(allAppsInfoDto.getLocationInfoList(), userId);
            appMostUsedService.saveAll(allAppsInfoDto.getMostUsedAppsList(), userId);
        }

    }

}
