package com.plivo.contactapp.service;


import com.plivo.contactapp.models.ContactBook;

/**
 * @author raghav on 10/2/19.
 */
public interface ContactBookService {

    ContactBook create(ContactBook contactBook);

    ContactBook update(ContactBook contactBook);

    ContactBook get(Long emailId,Long name);

    boolean delete(Long emailId);
}
