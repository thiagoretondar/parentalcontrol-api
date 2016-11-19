package fei.tcc.controller;

import fei.tcc.dto.ParentCreationDto;
import fei.tcc.dto.ParentLoginDto;
import fei.tcc.dto.UserLoginIdResponseDto;
import fei.tcc.exception.ParentAlreadyExistsException;
import fei.tcc.service.ParentService;
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
public class ParentController {

    private ParentService parentService;

    @Autowired
    public ParentController(final ParentService parentService) {
        this.parentService = parentService;
    }

    @ResponseStatus(value = CREATED)
    @RequestMapping(method = POST, value = "/create", consumes = APPLICATION_JSON_UTF8_VALUE)
    public UserLoginIdResponseDto create(@RequestBody @Valid ParentCreationDto parentCreationDto) throws ParentAlreadyExistsException {
        return parentService.create(parentCreationDto);
    }

    @RequestMapping(method = POST, value = "/login", consumes = APPLICATION_JSON_UTF8_VALUE)
    public UserLoginIdResponseDto login(@RequestBody @Valid ParentLoginDto parentLoginDto) {
        return parentService.login(parentLoginDto);
    }

}
