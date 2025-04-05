package com.tka.MediTrack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tka.MediTrack.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

	
}
