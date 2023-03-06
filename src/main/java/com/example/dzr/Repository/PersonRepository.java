package com.example.dzr.Repository;

import com.example.dzr.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person,Long> {

    Person findPersonById(Long id);
}
