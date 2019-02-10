package com.plivo.contactapp.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import com.plivo.contactapp.models.ErrorCode;
import com.plivo.contactapp.models.Response;
import com.plivo.contactapp.utils.ResponseUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author raghav on 10/2/19.
 */
@ControllerAdvice(basePackages = {"com.plivo.contactapp.controller"})
@RestController
public class ExceptionHandler {


    @ResponseStatus(BAD_REQUEST)
    @ResponseBody
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
    public Response methodArgumentNotValidException(MethodArgumentNotValidException e) {
        BindingResult result = e.getBindingResult();
        FieldError fieldError = result.getFieldErrors().get(0);
        return ResponseUtils.failResponse(ErrorCode.INVALID_INPUT,
            fieldError.getField() + " " +fieldError.getDefaultMessage());
    }

}
