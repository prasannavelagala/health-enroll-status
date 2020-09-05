package com.health.enroll.serviceImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.health.enroll.domain.Dependent;
import com.health.enroll.domain.Enrollment;
import com.health.enroll.dto.DependentDto;
import com.health.enroll.dto.EnrollmentDto;
import com.health.enroll.persistence.EnrollRepository;
import com.health.enroll.service.EnrollService;

@Service
public class EnrollServiceImpl implements EnrollService{

	@Autowired
    private EnrollRepository enrollRepository;

	@Override
	public List<EnrollmentDto> getAllEnrollees() {
		List<EnrollmentDto> enrollmentDtoList = new ArrayList<>();
		enrollRepository.findAll().forEach(enroll->{
			EnrollmentDto enrollmentDto=new EnrollmentDto();
			enrollmentDto.setId(enroll.getId());
			enrollmentDto.setName(enroll.getName());
			enrollmentDto.setActivationStatus(enroll.getActivationStatus());
			enrollmentDto.setBirthDate(enroll.getBirthDate());
			buildDependentsUnderEnroll(enroll, enrollmentDto);
			enrollmentDtoList.add(enrollmentDto);
		});
		return enrollmentDtoList;
	}

	@Override
	public EnrollmentDto getEnrollee(Integer enrollId) {
		Optional<Enrollment> enrollOptional = enrollRepository.findById(enrollId);
		EnrollmentDto enrollmentDto = null;
		if(enrollOptional.isPresent()) {
			Enrollment enroll = enrollOptional.get();
			enrollmentDto=new EnrollmentDto();
			enrollmentDto.setId(enroll.getId());
			enrollmentDto.setName(enroll.getName());
			enrollmentDto.setActivationStatus(enroll.getActivationStatus());
			enrollmentDto.setBirthDate(enroll.getBirthDate());
			buildDependentsUnderEnroll(enroll, enrollmentDto);
		}
		return enrollmentDto;
	}

	@Override
	public void addEnrollee(EnrollmentDto enrollmentDto) {
		Enrollment enroll=new Enrollment();
		enroll.setId(enrollmentDto.getId());
		enroll.setName(enrollmentDto.getName());
		enroll.setPhoneNumber(enrollmentDto.getPhoneNumber());
		enroll.setActivationStatus(enrollmentDto.getActivationStatus());
		enroll.setBirthDate(enrollmentDto.getBirthDate());
		enrollRepository.save(enroll);
	}

	@Override
	public void updateEnrollee(EnrollmentDto enrollmentDto) {
		Optional<Enrollment> enrollOptional = enrollRepository.findById(enrollmentDto.getId());
		if(enrollOptional.isPresent()) {
			Enrollment enroll = enrollOptional.get();
			enroll.setActivationStatus(enrollmentDto.getActivationStatus());
			enroll.setBirthDate(enrollmentDto.getBirthDate());
			enroll.setPhoneNumber(enrollmentDto.getPhoneNumber());
			enroll.setName(enrollmentDto.getName());
			enrollRepository.save(enroll);
		}
		
	}

	@Override
	public void deleteEnrollee(Integer enrollId) {
		enrollRepository.deleteById(enrollId);
	}
	
	private void buildDependentsUnderEnroll(Enrollment enroll, EnrollmentDto enrollmentDto) {
		Set<Dependent> dependentesList= enroll.getDependentes();
		if(!CollectionUtils.isEmpty(dependentesList)) {
			Set<DependentDto> dependentes=new HashSet<DependentDto>();
			for(Dependent dependent: dependentesList) {
				DependentDto dependentDto=new DependentDto();
				dependentDto.setId(dependent.getId());
				dependentDto.setName(dependent.getName());
				dependentDto.setBirthDate(dependent.getBirthDate());
				dependentes.add(dependentDto);
			}
			enrollmentDto.setDependentes(dependentes);
		}
	}

}
