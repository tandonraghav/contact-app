package com.plivo.contactapp.service;

import com.plivo.contactapp.entity.ContactBookEntity;
import com.plivo.contactapp.models.ContactBook;
import com.plivo.contactapp.models.ContactBookList;
import com.plivo.contactapp.models.ErrorCode;
import com.plivo.contactapp.repository.ContactBookRepository;
import com.plivo.contactapp.utils.ResponseMapper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
    public ContactBook findByEmailId(String emailId) {
        ContactBookEntity contactBookEntity=contactBookRepository.findByEmailId(emailId);
        if(contactBookEntity==null) return new ContactBook(ErrorCode.CONTACT_NOT_FOUND);
        return ResponseMapper.fromEntity(contactBookEntity);
    }

    @Override
    public ContactBook delete(String emailId) {
        ContactBookEntity contactBookEntity=contactBookRepository.findByEmailId(emailId);
        if(contactBookEntity==null) return new ContactBook(ErrorCode.CONTACT_NOT_FOUND);
        contactBookRepository.delete(contactBookEntity.getId());
        return new ContactBook();
    }

    @Override
    public ContactBookList findByName(String name,int pageNo,int size) {
        List<ContactBook> contactBooks=new ArrayList<>();
        if(StringUtils.hasText(name)){
            if(pageNo==0) pageNo=0;
            if(size==0) size=10;
            Pageable pageable = new PageRequest(pageNo,size);

            List<ContactBookEntity> contactBookEntities=contactBookRepository.findByName(name,pageable);

            if(contactBookEntities!=null && contactBookEntities.size()>0){
                for(ContactBookEntity c:contactBookEntities){
                    contactBooks.add(ResponseMapper.fromEntity(c));
                }
            }
        }

        ContactBookList contactBookList=new ContactBookList();
        contactBookList.setContactBooks(contactBooks);
        return contactBookList;
    }




}
