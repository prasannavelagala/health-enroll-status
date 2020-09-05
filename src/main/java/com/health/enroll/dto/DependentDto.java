package com.health.enroll.dto;

public class DependentDto {

private Integer id;
	
	private String name;
	
	private String birthDate;
	
	private Integer enrollId;
	

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

	public Integer getEnrollId() {
		return enrollId;
	}

	public void setEnrollId(Integer enrollId) {
		this.enrollId = enrollId;
	}

}
