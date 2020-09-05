package com.health.enroll.service;

import java.util.List;

import com.health.enroll.dto.DependentDto;

public interface DependentService {

	void addDependents(List<DependentDto> dependents);

	void updateDependents(List<DependentDto> dependents);

	void deleteDependentsUnderEnrollee(Integer dependentId);

}
