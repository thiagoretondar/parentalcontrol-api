package fei.tcc.business;

import fei.tcc.dto.AllAppsInfoDto;
import fei.tcc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by thiagoretondar on 30/10/16.
 */
@Service
public class UsageAppsInfoBusiness {

    private UserService userService;

    @Autowired
    public UsageAppsInfoBusiness(UserService userService) {
        this.userService = userService;
    }

    public void save(AllAppsInfoDto allAppsInfoDto) {

        if (userService.existsUserWithId(allAppsInfoDto.getUserId())) {
            // save services
        }

    }

}
