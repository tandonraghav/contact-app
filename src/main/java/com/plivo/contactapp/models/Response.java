package com.plivo.contactapp.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * @author raghav on 10/2/19.
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T extends ApiOutput> {

    private boolean success = false;

    private ErrorCode errorCode;

    private String errorMessage;

    private T result;

}
