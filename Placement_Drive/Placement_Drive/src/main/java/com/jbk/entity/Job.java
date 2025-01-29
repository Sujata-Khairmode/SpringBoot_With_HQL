package com.jbk.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Job {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String j_role;
	private String experience;
	private float salaryPackage;
	private String qualification;
	private int passYear;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJ_role() {
		return j_role;
	}
	public void setJ_role(String j_role) {
		this.j_role = j_role;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public float getSalaryPackage() {
		return salaryPackage;
	}
	public void setSalaryPackage(float salaryPackage) {
		this.salaryPackage = salaryPackage;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public int getPassYear() {
		return passYear;
	}
	public void setPassYear(int passYear) {
		this.passYear = passYear;
	}
	public Job() {
		super();
		
	}
	public Job(int id, String j_role, String experience, float salaryPackage, String quealification, int passYear) {
		super();
		this.id = id;
		this.j_role = j_role;
		this.experience = experience;
		this.salaryPackage = salaryPackage;
		this.qualification = quealification;
		this.passYear = passYear;
	}
	@Override
	public String toString() {
		return "Job [id=" + id + ", j_role=" + j_role + ", experience=" + experience + ", salaryPackage="
				+ salaryPackage + ", quealification=" + qualification + ", passYear=" + passYear + "]";
	}
	
	

}
