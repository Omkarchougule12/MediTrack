package com.tka.MediTrack.service;

import java.util.List;

import javax.management.AttributeNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tka.MediTrack.entity.Medicine;
import com.tka.MediTrack.repository.MedicineRepository;

@Service
public class MedicineService {
	
	@Autowired
	MedicineRepository medicineRepository;

	public Medicine addMedicine(Medicine md) {
		// TODO Auto-generated method stub
		return medicineRepository.save(md);
	}

	public List<Medicine> getAllMedicine() {
		// TODO Auto-generated method stub
		return medicineRepository.findAll();
	}

	public Medicine getmedicinebyid(long id) throws AttributeNotFoundException {
		// TODO Auto-generated method stub
	Medicine m1 =	medicineRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("medicine of this id is not found"));
		return m1;
	}

	public Medicine updatemedicine(long id, Medicine m) throws AttributeNotFoundException {
		// TODO Auto-generated method stub
	Medicine medicine =	medicineRepository.findById(id).orElseThrow(()->new AttributeNotFoundException("medicine of this id is not found"));
	medicine.setDrugname(m.getDrugname());
	medicine.setStock(m.getStock());
    Medicine updatedmedicine =	medicineRepository.save(medicine);
		return updatedmedicine;
	}

	public String deletemedicine(long id) throws AttributeNotFoundException {
		// TODO Auto-generated method stub
	Medicine m1 =	medicineRepository.findById(id).orElseThrow(()-> new AttributeNotFoundException("medicine of this id is not found"));
	medicineRepository.delete(m1);
		return "medicine deleted";
	}
	
	
	
	

}
