package com.plivo.contactapp.controller;

import com.plivo.contactapp.models.ContactBook;
import com.plivo.contactapp.models.Response;
import com.plivo.contactapp.service.ContactBookService;
import com.plivo.contactapp.utils.ResponseUtils;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author raghav on 10/2/19.
 */
@RestController
public class ContactBookController {

    @Autowired private ContactBookService contactBookService;

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public Response<ContactBook> create(@Valid @RequestBody ContactBook contactBook){
        ContactBook contactBookResponse=contactBookService.create(contactBook);
        if(contactBookResponse.getErrorCode()!=null){
            return ResponseUtils.failResponse(contactBookResponse.getErrorCode(),contactBookResponse.getErrorMessage());
        }else{
            return ResponseUtils.successResponse(contactBookResponse);
        }
    }
}
