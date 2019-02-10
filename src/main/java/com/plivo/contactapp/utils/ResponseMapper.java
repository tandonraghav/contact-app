package com.plivo.contactapp.utils;

import com.plivo.contactapp.entity.ContactBookEntity;
import com.plivo.contactapp.models.ContactBook;

/**
 * @author raghav on 10/2/19.
 */
public class ResponseMapper {

    public static ContactBook fromEntity(ContactBookEntity contactBookEntity){
        ContactBook contactBook=new ContactBook();
        contactBook.setEmailId(contactBookEntity.getEmailId());
        contactBook.setName(contactBookEntity.getName());
        contactBook.setMobile(contactBookEntity.getMobileNumber());
        return contactBook;
    }

    public static ContactBookEntity toEntity(ContactBook contactBook){
        ContactBookEntity contactBookEntity=new ContactBookEntity();
        contactBookEntity.setEmailId(contactBook.getEmailId());
        contactBookEntity.setName(contactBook.getName());
        contactBookEntity.setMobileNumber(contactBook.getMobile());
        return contactBookEntity;
    }

}
