package com.plivo.contactapp.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import springfox.documentation.annotations.ApiIgnore;

/**
 * @author raghav on 10/2/19.
 */
@Getter
@Setter
@JsonInclude(Include.NON_NULL)
@ApiIgnore
public class ApiOutput {

    @ApiModelProperty(hidden = true)
    private ErrorCode errorCode;

    @ApiModelProperty(hidden = true)
    private String errorMessage;

    public ApiOutput(){}

    public ApiOutput(ErrorCode errorCode,String errorMessage){
        this.errorMessage=errorMessage;
        this.errorCode=errorCode;
    }
}
