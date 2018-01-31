package com.arjen.demo.dao;

import com.arjen.demo.domain.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

/**
 * Created by Administrator on 2018/1/30.
 */
public interface PersonRepository extends MongoRepository<Person,String> {
    Person findByName(String name);
    @Query("{'age': ?0}")
    List<Person> withQueryFindByAge(Integer age);
}
