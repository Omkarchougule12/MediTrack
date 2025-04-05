package com.tka.MediTrack.service;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.MediTrack.entity.Appointment;
import com.tka.MediTrack.repository.AppointmentRepository;

@Service
public class AppointmentService {
	
	@Autowired
	AppointmentRepository appointmentRepository;

	public Appointment addAppointment(Appointment ap) {
		// TODO Auto-generated method stub
		return appointmentRepository.save(ap);
		
	}

	public List<Appointment> getAllApointment() {
		// TODO Auto-generated method stub
		return appointmentRepository.findAll();
	}

	public String deleteAppointment(long id) throws AttributeNotFoundException {
		// TODO Auto-generated method stub
		Appointment app= appointmentRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("appointment of this id is not found"));
		appointmentRepository.delete(app);
		 return "appointment deleted";
	}

}
