package com.health.enroll.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.health.enroll.domain.Dependent;

@Repository
public interface DependentRepository extends CrudRepository<Dependent, Integer> {

}
