package com.health.enroll.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.health.enroll.domain.Dependent;
import com.health.enroll.domain.Enrollment;
import com.health.enroll.dto.DependentDto;
import com.health.enroll.dto.EnrollmentDto;
import com.health.enroll.persistence.DependentRepository;
import com.health.enroll.persistence.EnrollRepository;
import com.health.enroll.service.DependentService;

@Service
public class DependentServiceImpl implements DependentService{

	@Autowired
    private DependentRepository dependentRepository;
	
	@Autowired
    private EnrollRepository enrollRepository;
	
	@Override
	public void addDependents(List<DependentDto> dependents) {
		List<Dependent> dependentList = new ArrayList<>();
		for(DependentDto dependentDto: dependents) {
			Dependent dependent=new Dependent();
			dependent.setId(dependentDto.getId());
			dependent.setName(dependentDto.getName());
			dependent.setBirthDate(dependentDto.getBirthDate());
			EnrollmentDto enrollmentDto = dependentDto.getEnrollmentDto();
			Optional<Enrollment> enroll=enrollRepository.findById(enrollmentDto.getId());
			if(enroll.isPresent()) {
				dependent.setEnrollment(enroll.get());
			}
			dependentList.add(dependent);
		}
		dependentRepository.saveAll(dependentList);
	}

	@Override
	public void updateDependents(List<DependentDto> dependents) {
		List<Dependent> dependentList = new ArrayList<>();
		for(DependentDto dependentDto: dependents) {
			Dependent dependent=new Dependent();
			dependent.setName(dependentDto.getName());
			dependent.setBirthDate(dependentDto.getBirthDate());
			EnrollmentDto enrollmentDto = dependentDto.getEnrollmentDto();
			Optional<Enrollment> enroll=enrollRepository.findById(enrollmentDto.getId());
			if(enroll.isPresent()) {
				dependent.setEnrollment(enroll.get());
			}
			dependent.setId(dependentDto.getId());
			dependentList.add(dependent);
		}
		dependentRepository.saveAll(dependentList);
	}

	@Override
	public void deleteDependentsUnderEnrollee(Integer dependentId) {
		dependentRepository.deleteById(dependentId);
	}

}
