package com.SpringS.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Person, Integer> {
  void findByLanguage(String lang);
}
