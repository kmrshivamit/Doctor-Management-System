package com.shivam.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Doctor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@NotBlank
	@Size(min = 2, message = "first name should have at least 2 characters")
	private String firstName;
	private String lastName;
	@NotNull
	private String address;
	@NotNull
	private String specialization;
	@NotNull
	@Email
	private String email;
	@NotNull
	private boolean isAvailable;

	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Doctor(String firstNam, String lastName, String address, String specialization, boolean isAvailable,
			String email) {
		super();
		this.firstName = firstNam;
		this.lastName = lastName;
		this.address = address;
		this.email = email;
		this.specialization = specialization;
		this.isAvailable = isAvailable;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
