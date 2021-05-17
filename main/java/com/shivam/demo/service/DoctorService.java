package com.shivam.demo.service;

import java.util.List;

import com.shivam.demo.entity.Doctor;

public interface DoctorService {

	public Doctor addDoctor(Doctor doctor);

	public List<Doctor> getDoctors();

	public Doctor getDoctor(long id);

	public void deleteDoctor(long id);

	public Doctor updateDoctor(Doctor doctor);

	public List<Doctor> getDoctorsByLocation(String location);


}
