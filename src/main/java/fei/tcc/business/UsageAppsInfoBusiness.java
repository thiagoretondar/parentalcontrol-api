package fei.tcc.business;

import fei.tcc.dto.AllAppsInfoDto;
import fei.tcc.dto.LastDatetimeUsedDto;
import fei.tcc.service.AppLocationInfoService;
import fei.tcc.service.AppMostUsedService;
import fei.tcc.service.AppUsageService;
import fei.tcc.service.UserService;
import org.apache.log4j.Logger;
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

    private final static Logger LOGGER = Logger.getLogger(UsageAppsInfoBusiness.class);

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
            LOGGER.info("User ID exists. Starting saving information received");
            // TODO refactor: maybe create a general exception to try any of those actions
            Long lastAppUsageDatetime = appUsageService.saveAll(allAppsInfoDto.getAppUsageInfoList(), userId);
            Long lastLocationUsageDatetime = appLocationInfoService.saveAll(allAppsInfoDto.getLocationInfoList(), userId);
            appMostUsedService.saveAll(allAppsInfoDto.getMostUsedAppsList(), userId);

            LastDatetimeUsedDto lastDatetimeUsedDto = new LastDatetimeUsedDto(userId, lastAppUsageDatetime, lastLocationUsageDatetime);
            LOGGER.info("Returning response: " + lastDatetimeUsedDto.toString());

            return lastDatetimeUsedDto;
        }

        LOGGER.warn("User ID received isn't stored in database: " + userId);
        return new LastDatetimeUsedDto();

    }

}
