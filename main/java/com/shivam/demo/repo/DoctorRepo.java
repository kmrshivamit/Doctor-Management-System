package com.shivam.demo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.shivam.demo.entity.Doctor;

@Repository
public interface DoctorRepo extends JpaRepository<Doctor, Long> {

	public List<Doctor> findByAddress(String address);
      
	
}
