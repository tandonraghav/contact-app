package com.plivo.contactapp.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author raghav on 10/2/19.
 */
@JsonInclude(Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
public class ContactBook extends ApiOutput{

    @NotNull
    @Size(min = 1, max = 60,message = "email id must be between 1 and 60 chars long")
    private String emailId;

    @NotNull
    @Size(min = 1, max = 60,message = "name must be between 1 and 60 chars long")
    private String name;

    @NotNull
    @Size(min = 1, max = 60,message = "mobile number must be between 1 and 60 chars long")
    private String mobile;

    public ContactBook(ErrorCode errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public ContactBook(ErrorCode errorCode) {
        super(errorCode, errorCode.getDescription());
    }
}
