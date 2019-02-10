package com.plivo.contactapp.service;


import com.plivo.contactapp.models.ContactBook;
import com.plivo.contactapp.models.ContactBookList;
import java.util.List;

/**
 * @author raghav on 10/2/19.
 */
public interface ContactBookService {

    ContactBook create(ContactBook contactBook);

    ContactBook update(ContactBook contactBook);

    ContactBookList findByName(String name,int pageNo,int size);

    ContactBook findByEmailId(String emailId);

    ContactBook delete(String emailId);
}
