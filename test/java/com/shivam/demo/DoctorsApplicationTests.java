package com.shivam.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.shivam.demo.entity.Doctor;
import com.shivam.demo.repo.DoctorRepo;
@DataJpaTest

class DoctorsApplicationTests {
	@Autowired
	private DoctorRepo underTest;

	
	@Test
   void addDoctorTest()
   {
	   Doctor doctor=new Doctor("Amar","Tyagi","Delhi","sergon",false,"amar@gmail.com");
  Doctor saved=underTest.save(doctor);
  assertNotNull(saved);
  assertEquals(saved.getAddress(), doctor.getAddress());
  assertEquals(saved.getAddress(),"abc");
  
  underTest.deleteAll();

  
   }
	@Test
	void deleteDoctorTest()
	{
		 Doctor doctor=new Doctor("Amar","Tyagi","Delhi","sergon",false,"amar@gmail.com");
		  Doctor saved=underTest.save(doctor);
		long  id=saved.getId();
		  System.out.println(id);
		underTest.deleteById(id);
		  assertEquals(0, underTest.findAll().size());
		  underTest.deleteAll();
	
		 
	}
	
	
	@Test
	void findAllDoctorTest()
	{ Doctor doctor=new Doctor("Amar","Tyagi","Delhi","sergon",false,"amar@gmail.com");
	 Doctor doctor1=new Doctor("Rishabh","Tyagi","Banglore","dentist",false,"risabh@gmail.com");
	 underTest.save(doctor1);
	 underTest.save(doctor);
	 int expectedTotalDoctors=2;
	 
	  assertEquals(expectedTotalDoctors, underTest.findAll().size());
	  underTest.deleteAll();
	  
		
	}
	@Test
	void updateDoctorTest()
	{Doctor doctor=new Doctor("Amar","Tyagi","Delhi","sergon",false,"amar@gmail.com");
	
	  Doctor saved=underTest.save(doctor);
	  long id=saved.getId();
	  String address="Mumbai";
	  saved.setAddress(address);
	  underTest.save(saved);
	  System.out.println("save work");
	 Doctor updated=underTest.findById(id).get();
	 assertEquals(updated.getAddress(),address);
	underTest.deleteAll();
	}


}
