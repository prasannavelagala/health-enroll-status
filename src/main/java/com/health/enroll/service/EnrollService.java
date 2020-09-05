package com.health.enroll.service;

import java.util.List;

import com.health.enroll.dto.EnrollmentDto;


public interface EnrollService {

	List<EnrollmentDto> getAllEnrollees();

	EnrollmentDto getEnrollee(Integer enrollId);

	void addEnrollee(EnrollmentDto enrollmentDto);

	void updateEnrollee(EnrollmentDto enrollmentDto);

	void deleteEnrollee(Integer enrollId);

}
