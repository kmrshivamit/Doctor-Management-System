package com.shivam.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shivam.demo.entity.Doctor;
import com.shivam.demo.service.DoctorService;

@RestController
public class DoctorController {

	@Autowired
	DoctorService doctorService;

	@PostMapping("/doctor")
	public Doctor addDoctor(@Valid @RequestBody Doctor doctor) {
		return doctorService.addDoctor(doctor);
	}

	@GetMapping("/doctor")
	public List<Doctor> getDoctors() {
		return doctorService.getDoctors();
	}

	@GetMapping("/doctor/id/{id}")
	public Doctor getDoctor(@Valid @PathVariable long id) {
		return doctorService.getDoctor(id);
	}

	@DeleteMapping("/doctor/{id}")
	public void deleteDoctor(@Valid @PathVariable long id) {
		doctorService.deleteDoctor(id);
	}

	@PutMapping("/doctor")
	public Doctor updateDoctor(@Valid @RequestBody Doctor doctor) {
		return doctorService.updateDoctor(doctor);
	}

	@GetMapping("/doctor/address/{address}")
	public List<Doctor> getDoctorsByAddress(@Valid @PathVariable String address)
	{
		return doctorService.getDoctorsByLocation(address);
	}
}
