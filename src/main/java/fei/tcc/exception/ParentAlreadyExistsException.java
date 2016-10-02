package fei.tcc.exception;

import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

/**
 * Created by thiagoretondar on 10/2/16.
 */
@ResponseStatus(value = BAD_REQUEST)
public class ParentAlreadyExistsException extends Exception {

    public ParentAlreadyExistsException() {
        super();
    }

}
