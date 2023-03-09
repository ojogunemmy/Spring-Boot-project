package com.SpringS.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TechRepository extends JpaRepository<Person, Integer> {

}
