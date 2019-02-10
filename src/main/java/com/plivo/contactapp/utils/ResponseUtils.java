package com.plivo.contactapp.utils;


import com.plivo.contactapp.models.ApiOutput;
import com.plivo.contactapp.models.ErrorCode;
import com.plivo.contactapp.models.Response;

public class ResponseUtils {

    public static <T extends ApiOutput> Response failResponse(ErrorCode errorCode,
        String errorMessage) {
        Response output = new Response();
        output.setSuccess(Boolean.FALSE);
        output.setErrorCode(errorCode);
        output.setErrorMessage(errorMessage);
        return output;
    }

    public static  <T extends ApiOutput> Response successResponse(T obj) {
        Response output = new Response();
        output.setSuccess(Boolean.TRUE);
        output.setResult(obj);
        return output;
    }
}
