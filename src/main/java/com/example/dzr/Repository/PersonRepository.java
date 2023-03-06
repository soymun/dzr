package com.example.dzr.Repository;

import com.example.dzr.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person,Long> {

    List<Person> getPersonByUserId(Long id);
}
