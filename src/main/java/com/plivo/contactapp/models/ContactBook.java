package com.plivo.contactapp.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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

    private static final String EMAIL_PATTERN =
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    @NotNull
    @Size(min = 1, max = 60,message = " must be between 1 and 60 chars long")
    @Pattern(regexp = EMAIL_PATTERN,message = "Invalid")
    private String emailId;

    @NotNull
    @Size(min = 1, max = 60,message = " must be between 1 and 60 chars long")
    private String name;

    @NotNull
    @Size(min = 1, max = 10,message = " must be between 1 and 10 chars long")
    @Pattern(regexp = "\\d{10}")
    private String mobile;

    public ContactBook(ErrorCode errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public ContactBook(ErrorCode errorCode) {
        super(errorCode, errorCode.getDescription());
    }
}
