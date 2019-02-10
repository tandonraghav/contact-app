package com.plivo.contactapp.service;

import com.plivo.contactapp.entity.ContactBookEntity;
import com.plivo.contactapp.models.ContactBook;
import com.plivo.contactapp.models.ErrorCode;
import com.plivo.contactapp.repository.ContactBookRepository;
import com.plivo.contactapp.utils.ResponseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author raghav on 10/2/19.
 */
@Service
public class ContactBookServiceImpl implements ContactBookService {

    @Autowired private ContactBookRepository contactBookRepository;

    @Override
    public ContactBook create(ContactBook contactBook) {
        String email= contactBook.getEmailId();
        ContactBookEntity contact=contactBookRepository.findByEmailId(email);
        if(contact!=null){
            return new ContactBook(ErrorCode.CONTACT_EXISTS);
        }
        ContactBookEntity contactBookEntity=ResponseMapper.toEntity(contactBook);
        ContactBookEntity contactFromDB = contactBookRepository.save(contactBookEntity);
        return ResponseMapper.fromEntity(contactFromDB);
    }

    @Override
    public ContactBook update(ContactBook contactBook) {
        ContactBookEntity contactBookEntity=contactBookRepository.findByEmailId(contactBook.getEmailId());
        if(contactBookEntity==null) return new ContactBook(ErrorCode.CONTACT_NOT_FOUND);
        contactBookEntity.setMobileNumber(contactBook.getMobile());
        contactBookEntity.setName(contactBook.getName());
        ContactBookEntity contactFromDB=contactBookRepository.save(contactBookEntity);
        return ResponseMapper.fromEntity(contactFromDB);
    }

    @Override
    public ContactBook get(Long emailId, Long name) {
        return null;
    }

    @Override
    public boolean delete(Long emailId) {
        return false;
    }


}
