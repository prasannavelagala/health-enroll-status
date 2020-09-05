package com.health.enroll.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.health.enroll.domain.Dependent;
import com.health.enroll.dto.DependentDto;
import com.health.enroll.persistence.DependentRepository;
import com.health.enroll.service.DependentService;

public class DependentServiceImpl implements DependentService{

	@Autowired
    private DependentRepository dependentRepository;
	
	@Override
	public void addDependents(List<DependentDto> dependents) {
		List<Dependent> dependentList = new ArrayList<>();
		for(DependentDto dependentDto: dependents) {
			Dependent dependent=new Dependent();
			dependent.setId(dependentDto.getId());
			dependent.setName(dependentDto.getName());
			dependent.setBirthDate(dependentDto.getBirthDate());
			dependent.setEnrollId(dependentDto.getEnrollId());
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
			dependent.setEnrollId(dependentDto.getEnrollId());
			dependent.setId(dependentDto.getId());
			dependentList.add(dependent);
		}
		dependentRepository.saveAll(dependentList);
	}

	@Override
	public void deleteDependentsUnderEnrollee(Integer enrollId) {
		dependentRepository.findById(enrollId);
	}

}
