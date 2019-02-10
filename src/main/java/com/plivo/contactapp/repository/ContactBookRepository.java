package com.plivo.contactapp.repository;

import com.plivo.contactapp.entity.ContactBookEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author raghav on 10/2/19.
 */
@Repository
public interface ContactBookRepository extends JpaRepository<ContactBookEntity,Long> {

    ContactBookEntity findByEmailId(String email);

    List<ContactBookEntity> findByName(String name);
}
