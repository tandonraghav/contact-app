package com.plivo.contactapp.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author raghav on 10/2/19.
 */
@JsonInclude(Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
public class ContactBookList extends ApiOutput {

    List<ContactBook> contactBooks;
    ContactBook contactBook;
}
