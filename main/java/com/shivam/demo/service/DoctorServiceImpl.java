package com.shivam.demo.service;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.shivam.demo.entity.Doctor;
import com.shivam.demo.exception.ResourceNotFoundException;
import com.shivam.demo.repo.DoctorRepo;

@Service
public class DoctorServiceImpl implements DoctorService {

	@Autowired
	DoctorRepo doctorRepo;

	@Override
	public Doctor addDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorRepo.save(doctor);
	}

	@Override
	public List<Doctor> getDoctors() {
		// TODO Auto-generated method stub
		
	     List<Doctor> doctors=doctorRepo.findAll();
	     if(doctors.size()==0)
	    	 throw new ResourceNotFoundException("No element present");
	     else
	    	 return doctors;
	}

	@Override
	public Doctor getDoctor(long id) {
		// TODO Auto-generated method stub
		return doctorRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("User not found with id"+ id));
	}

	@Override
	public void deleteDoctor(long id) {
		// TODO Auto-generated method stub
		Doctor d=doctorRepo.findById(id).orElseThrow(()->new NoSuchElementException());
	 doctorRepo.delete(d);
	}

	@Override
	public Doctor updateDoctor(Doctor doctor) {
		// TODO Auto-generated method stub
		return doctorRepo.save(doctor);
	}

	@Override
	public List<Doctor> getDoctorsByLocation(String location) {
		// TODO Auto-generated method stub
		List<Doctor> doctors= doctorRepo.findByAddress(location);
		if(doctors==null)
			throw new ResourceNotFoundException("There is no doctor with given addres s"+ location);
		return doctors;
	}

	

}
