package com.health.enroll.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.health.enroll.dto.DependentDto;
import com.health.enroll.service.DependentService;

@RestController
public class DependentController {

	@Autowired
	private DependentService dependentService;
	
	@PostMapping("/dependents")
    public void addBook(@RequestBody List<DependentDto> dependentDtos) {
		dependentService.addDependents(dependentDtos);
    }

    @PutMapping("/dependents/{id}")
    public void updateDependents(@RequestBody List<DependentDto> enrodependentDto) {
    	dependentService.updateDependents(enrodependentDto);
    }

    @DeleteMapping("/dependents/{id}")
    public void deleteDependent(@PathVariable Integer enrollId) {
    	dependentService.deleteDependentsUnderEnrollee(enrollId);
    }
}
