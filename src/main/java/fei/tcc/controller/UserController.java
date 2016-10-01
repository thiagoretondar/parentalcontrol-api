package fei.tcc.controller;

import fei.tcc.dto.ParentCreationDto;
import fei.tcc.dto.ParentLoginDto;
import fei.tcc.service.ParentCreationService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/parent")
public class UserController {

    private ParentCreationService parentCreationService;

    @Autowired
    public UserController(final ParentCreationService parentCreationService) {
        this.parentCreationService = parentCreationService;
    }

    @ResponseStatus(value = CREATED)
    @RequestMapping(method = POST, value = "/create", consumes = APPLICATION_JSON_UTF8_VALUE)
    public Integer create(@RequestBody @Valid ParentCreationDto parentCreationDto) {
        return parentCreationService.create(parentCreationDto);
    }

    @RequestMapping(method = POST, value = "/login", consumes = APPLICATION_JSON_UTF8_VALUE)
    public void login(@RequestBody @Valid ParentLoginDto parentLoginDto) {
        // TODO implement login user method
    }

}
