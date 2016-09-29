package fei.tcc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by thiagoretondar on 9/12/16.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @ResponseStatus(value = CREATED)
    @RequestMapping(method = POST, value = "/create", consumes = APPLICATION_JSON_UTF8_VALUE)
    public void create() {
        // TODO implement register user method
    }

    @RequestMapping(method = POST, value = "/login", consumes = APPLICATION_JSON_UTF8_VALUE)
    public void login() {
        // TODO implement login user method
    }

}
