package com.health.enroll.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.health.enroll.domain.Enrollment;

@Repository
public interface EnrollRepository extends CrudRepository<Enrollment, Integer> {
	
}

