package fei.tcc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by thiagoretondar on 10/10/16.
 */
@RestController
@RequestMapping("/app")
public class AllAppsInfoController {

    @RequestMapping(method = POST, consumes = APPLICATION_JSON_UTF8_VALUE)
    public void save() {
        // save info of apps
    }

}
