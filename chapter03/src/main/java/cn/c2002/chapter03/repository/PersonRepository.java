package cn.c2002.chapter03.repository;

import cn.c2002.chapter03.domain.Person;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository  extends CrudRepository<Person, String> {
//    通过姓名来找人
    List<Person> findByLastname(String lastname);
    Page<Person> findPersonByLastname(String lastname, Pageable page);
    List<Person> findByFirstnameAndLastname(String firstname, String lastname);
    List<Person> findByAddress_City(String city);
    List<Person> findByFamilyList_Username(String username);

}
