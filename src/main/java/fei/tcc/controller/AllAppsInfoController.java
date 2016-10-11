package fei.tcc.controller;

import fei.tcc.dto.AllAppsInfoDto;
import fei.tcc.service.AllAppsInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by thiagoretondar on 10/10/16.
 */
@RestController
@RequestMapping("/app")
public class AllAppsInfoController {

    private AllAppsInfoService allAppsInfoService;

    @Autowired
    public AllAppsInfoController(AllAppsInfoService allAppsInfoService) {
        this.allAppsInfoService = allAppsInfoService;
    }

    @RequestMapping(method = POST, consumes = APPLICATION_JSON_UTF8_VALUE)
    public void save(@RequestBody @Valid AllAppsInfoDto allAppsInfoDto) {

        allAppsInfoService.save(allAppsInfoDto);

    }

}
