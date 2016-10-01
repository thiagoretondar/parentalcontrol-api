package fei.tcc.controller;

import fei.tcc.dto.UserCreationDto;
import fei.tcc.dto.UserLoginDto;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
    public void create(@RequestBody @Valid UserCreationDto userCreationDto) {
        // TODO implement register user method
    }

    @RequestMapping(method = POST, value = "/login", consumes = APPLICATION_JSON_UTF8_VALUE)
    public void login(@RequestBody @Valid UserLoginDto userLoginDto) {
        // TODO implement login user method
    }

}
