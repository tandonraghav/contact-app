package com.plivo.contactapp.models;

import lombok.Getter;

/**
 * @author raghav on 10/2/19.
 */
public enum ErrorCode {

    INVALID_INPUT("Invalid Input"),
    AUTH_FAILED("Auth Failed"),
    CONTACT_EXISTS("Contact Already Exists For Specified Email Id"),
    CONTACT_NOT_FOUND("Contact Not found With email Id");

    @Getter
    private String description;

    ErrorCode(String description) {
        this.description = description;
    }

}
