package com.tka.MediTrack.service;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.MediTrack.entity.Patient;
import com.tka.MediTrack.repository.PatientRepository;

@Service
public class PatientService {
	
	@Autowired
	PatientRepository patientRepository;

	public Patient addPatient(Patient pt) {
		// TODO Auto-generated method stub
		return patientRepository.save(pt);
		
	}

	public List<Patient> getAllPatient() {
		// TODO Auto-generated method stub
		return patientRepository.findAll();
	}

	public String deletePatient(long id) throws AttributeNotFoundException {
		// TODO Auto-generated method stub
	  Patient p1=	patientRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("patient of this id is not found"));
	  patientRepository.delete(p1);
	  return "patient deleted successfully";
		
	}

	public Patient updatepatient(long id, Patient p) throws AttributeNotFoundException {
		// TODO Auto-generated method stub
		Patient p1 = patientRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("patient of this id is not found"));
		p1.setAge(p.getAge());
		p1.setBlood(p.getBlood());
		p1.setDose(p.getDose());
		p1.setFees(p.getFees());
		p1.setName(p.getName());
		p1.setPrescription(p.getPrescription());
		p1.setUrgency(p.getUrgency());
		
		p1 = patientRepository.save(p1);
		return p1;
	}

	public Patient getpatientbyid(long id) throws AttributeNotFoundException {
		// TODO Auto-generated method stub
	Patient p =	patientRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("patient of this id is not found"));
		return p;
	}

}
