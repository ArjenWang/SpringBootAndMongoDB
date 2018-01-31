package com.arjen.demo.web;

import com.arjen.demo.dao.PersonRepository;
import com.arjen.demo.domain.Location;
import com.arjen.demo.domain.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by Administrator on 2018/1/30.
 */
@RestController
public class DataController {
    @Autowired
    PersonRepository personRepository;
    @RequestMapping("/save")
    public Person save(){
        Person p=new Person("waj",12);
        Collection<Location> locations=new LinkedHashSet<Location>();
        Location location1=new Location("sh1","2017");
        Location location2=new Location("sh2","2018");
        locations.add(location1);
        locations.add(location2);
        p.setLocations(locations);
        return personRepository.save(p);
    }
    @RequestMapping("q1")
    public Person q1(String name){
        return personRepository.findByName(name);
    }

    @RequestMapping("q2")
    public List<Person> q1(Integer age){
        return personRepository.withQueryFindByAge(age);
    }
}
