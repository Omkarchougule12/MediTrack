package com.tka.MediTrack.controller;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.MediTrack.entity.Appointment;
import com.tka.MediTrack.repository.AppointmentRepository;
import com.tka.MediTrack.service.AppointmentService;

@RestController
@RequestMapping("hospital")
@CrossOrigin
public class AppointmentController {
	
	
	@Autowired
	AppointmentService appointmentService;
	
	@PostMapping("addappointment")
	public Appointment addAppointment(@RequestBody Appointment ap) {
		return appointmentService.addAppointment(ap);
		
	}
	
	@GetMapping("getallappointment")
	public List<Appointment> getAllApointment(){
		return appointmentService.getAllApointment();
	}
	
	
	@DeleteMapping("deleteappointment/{id}")
	public String deleteAppointment(@PathVariable long id) throws AttributeNotFoundException {
		return appointmentService.deleteAppointment(id);
	}

}
