package com.health.enroll.dto;

import java.util.Set;

import com.health.enroll.domain.Dependent;

public class EnrollmentDto {

	private Integer id;
	
	private String name;
	
	private boolean activationStatus;
	
	private String phoneNumber;
	
	private String birthDate;
	
	private Set<DependentDto> dependentes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean getActivationStatus() {
		return activationStatus;
	}

	public void setActivationStatus(boolean activationStatus) {
		this.activationStatus = activationStatus;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public Set<DependentDto> getDependentes() {
		return dependentes;
	}

	public void setDependentes(Set<DependentDto> dependentes) {
		this.dependentes = dependentes;
	}
	
}
