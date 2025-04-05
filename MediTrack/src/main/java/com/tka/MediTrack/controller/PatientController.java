package com.tka.MediTrack.controller;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tka.MediTrack.entity.Patient;
import com.tka.MediTrack.service.PatientService;

@RestController
@RequestMapping("hospital")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientController {
	
	@Autowired
	PatientService patientService;
	
	@PostMapping("addpatient")
	public Patient addPatient(@RequestBody Patient pt ) {
		 return patientService.addPatient(pt);
	}
	
	
	@GetMapping("getallpatient")
	public List<Patient> getAllPatient(){
		return patientService.getAllPatient();
	}
	
	
	@DeleteMapping("deletepatient/{id}")
	public ResponseEntity<String> deletePatient(@PathVariable long id) throws AttributeNotFoundException{
		String msg= patientService.deletePatient(id);
		return ResponseEntity.ok(msg);
		
	}
	
	@PutMapping("updatepatient/{id}")
	public ResponseEntity<Patient>updatepatient(@PathVariable long id , @RequestBody Patient p) throws AttributeNotFoundException{
		Patient p1=patientService.updatepatient(id,p);
		return ResponseEntity.ok(p1);
	} 
	
	@GetMapping("getpatientbyid/{id}")
	public ResponseEntity<Patient> getpatientbyid(@PathVariable long id) throws AttributeNotFoundException{
	  Patient p =	patientService. getpatientbyid(id);
	  return ResponseEntity.ok(p);
	}

}
