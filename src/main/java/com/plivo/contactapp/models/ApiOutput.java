package com.plivo.contactapp.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Getter;
import lombok.Setter;

/**
 * @author raghav on 10/2/19.
 */
@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class ApiOutput {

    private ErrorCode errorCode;

    private String errorMessage;

    public ApiOutput(){}

    public ApiOutput(ErrorCode errorCode,String errorMessage){
        this.errorMessage=errorMessage;
        this.errorCode=errorCode;
    }
}
