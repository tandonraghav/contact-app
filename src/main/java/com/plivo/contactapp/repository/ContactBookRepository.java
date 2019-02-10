package com.plivo.contactapp.repository;

import com.plivo.contactapp.entity.ContactBookEntity;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author raghav on 10/2/19.
 */
@Repository
public interface ContactBookRepository extends PagingAndSortingRepository<ContactBookEntity,Long> {

    ContactBookEntity findByEmailId(String email);

    List<ContactBookEntity> findByName(String name,Pageable pageable);

    List<ContactBookEntity> findByName(String name);
}
