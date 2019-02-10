package com.plivo.contactapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import lombok.Getter;
import lombok.Setter;

/**
 * @author raghav on 10/2/19.
 */
@Entity
@Table(name = "contact_book",
    uniqueConstraints = @UniqueConstraint(columnNames = {"email_id"},name = "unique_key_email"),
    indexes = {
    @Index(name = "idx_contact_book_name",
        columnList = "name")
})
@Getter
@Setter
public class ContactBookEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "email_id", length = 60,nullable = false)
    private String emailId;

    @Column(name = "name", length = 60,nullable = false)
    private String name;

    @Column(name = "mobile_no", length = 60,nullable = false)
    private String mobileNumber;


}
