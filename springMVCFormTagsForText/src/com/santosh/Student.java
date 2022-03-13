package com.santosh;

import java.util.HashMap;
import java.util.Map;

public class Student {

	private String firstName;
	private String lastName;
	private String country;
	private Map<String, String> countryOptionMap = new HashMap<String, String>();
	private String sex;
	private String[] operatngSystem;
	

	public String[] getOperatngSystem() {
		return operatngSystem;
	}

	public void setOperatngSystem(String[] operatngSystem) {
		this.operatngSystem = operatngSystem;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Student() {
		super();
		countryOptionMap.put("IND", "India");
		countryOptionMap.put("BR", "Brazil");
		countryOptionMap.put("SR", "Shrilanka");
	}

	public Map<String, String> getCountryOptionMap() {
		return countryOptionMap;
	}

}
