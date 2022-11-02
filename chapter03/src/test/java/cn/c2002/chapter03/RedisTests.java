package cn.c2002.chapter03;

import cn.c2002.chapter03.domain.Address;
import cn.c2002.chapter03.domain.Family;
import cn.c2002.chapter03.domain.Person;
import cn.c2002.chapter03.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class RedisTests {
    @Autowired
    private PersonRepository repository;
    @Test
    public void selectPerson() {
        List<Person> list = repository.findByAddress_City("北京");
        System.out.println(list);}
    @Test
    public void savePerson(){
        Person person =new Person("张","有才");
        Person person2 =new Person("James","Harden");

        Address address=new Address("北京","China");
        person.setAddress(address);

        List<Family> list =new ArrayList<>();
        Family dad =new Family("父亲","张良");
        Family mom =new Family("母亲","李香君");
        list.add(dad);
        list.add(mom);
        person.setFamilyList(list);
        Person save = repository.save(person);
        Person save2 = repository.save(person2);
        System.out.println(save);
        System.out.println(save2);
    }
    @Test
    public void updatePerson() {
        Person person = repository.findByFirstnameAndLastname("张","小明").get(0);
        person.setFirstname("李");
        Person update = repository.save(person);
        System.out.println(update);
    }
    @Test
    public void deletePerson() {
        Person person = repository.findByFirstnameAndLastname("李","小明").get(0);
        repository.delete(person);
    }
    @Test
    public void operatePerson(){
        Optional<Person> optionalPerson=repository.findById("001bcd76-2e8e-46f7-bdfe-f31faafddb79");
        System.out.println("optionPerson:"+optionalPerson);
    }

}
