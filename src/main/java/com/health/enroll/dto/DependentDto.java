package com.health.enroll.dto;

public class DependentDto {

private Integer id;
	
	private String name;
	
	private String birthDate;
	
	private EnrollmentDto enrollmentDto;
	

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

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public EnrollmentDto getEnrollmentDto() {
		return enrollmentDto;
	}

	public void setEnrollmentDto(EnrollmentDto enrollmentDto) {
		this.enrollmentDto = enrollmentDto;
	}

}
