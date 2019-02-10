package com.plivo.contactapp.controller;

import com.plivo.contactapp.models.ContactBook;
import com.plivo.contactapp.models.ContactBookList;
import com.plivo.contactapp.models.Response;
import com.plivo.contactapp.service.ContactBookService;
import com.plivo.contactapp.utils.ResponseUtils;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public Response<ContactBook> update(@Valid @RequestBody ContactBook contactBook){
        ContactBook contactBookResponse=contactBookService.update(contactBook);
        if(contactBookResponse.getErrorCode()!=null){
            return ResponseUtils.failResponse(contactBookResponse.getErrorCode(),contactBookResponse.getErrorMessage());
        }else{
            return ResponseUtils.successResponse(contactBookResponse);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public Response<ContactBook> delete(@RequestParam String emailId){
        ContactBook contactBookResponse=contactBookService.delete(emailId);
        if(contactBookResponse.getErrorCode()!=null){
            return ResponseUtils.failResponse(contactBookResponse.getErrorCode(),contactBookResponse.getErrorMessage());
        }else{
            return ResponseUtils.successResponse(contactBookResponse);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchByName")
    public Response<ContactBookList> findByName(@RequestParam String name,
        @RequestParam(required = false,defaultValue = "0") int pageNo,
        @RequestParam(required = false,defaultValue = "10") int size){
        ContactBookList contactBookResponse =  contactBookService.findByName(name,pageNo,size);
        if(contactBookResponse.getErrorCode()!=null){
            return ResponseUtils.failResponse(contactBookResponse.getErrorCode(),contactBookResponse.getErrorMessage());
        }else{
            return ResponseUtils.successResponse(contactBookResponse);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/searchByEmail")
    public Response<ContactBook> findByEmail(@RequestParam String emailId){
        ContactBook contactBookResponse =  contactBookService.findByEmailId(emailId);
        if(contactBookResponse.getErrorCode()!=null){
            return ResponseUtils.failResponse(contactBookResponse.getErrorCode(),contactBookResponse.getErrorMessage());
        }else{
            return ResponseUtils.successResponse(contactBookResponse);
        }
    }
}
