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
import org.springframework.web.bind.annotation.RestController;

import com.tka.MediTrack.entity.Medicine;
import com.tka.MediTrack.service.MedicineService;

@RestController
@RequestMapping("hospital")
@CrossOrigin(origins = "http://localhost:4200")
public class MedicineController {

	@Autowired
	MedicineService medicineService;
	
	@PostMapping("addmedicine")
	public Medicine addMedicine(@RequestBody Medicine md) {
		return medicineService.addMedicine(md);
		
	}
	
	@GetMapping("getallmedicine")
	public List<Medicine> getAllMedicine(){
		return medicineService.getAllMedicine();
	}
	
	
	@GetMapping("getmedicinebyid/{id}")
	public ResponseEntity<Medicine> getmedicinebyid(@PathVariable long id) throws AttributeNotFoundException{
		Medicine m1=  medicineService.getmedicinebyid(id);
		return ResponseEntity.ok(m1);
	}
	
	
	@PutMapping("updatemedicine/{id}")
	public ResponseEntity<Medicine> updatemedicine(@PathVariable long id , @RequestBody Medicine m) throws AttributeNotFoundException  {
		Medicine m1 = medicineService.updatemedicine(id,m);
		return ResponseEntity.ok(m1);
	}
	
	
	@DeleteMapping("deletemedicine/{id}")
	public ResponseEntity<String> deletemedicine(@PathVariable long id) throws AttributeNotFoundException{
		String msg = medicineService.deletemedicine(id);
		return ResponseEntity.ok(msg);
	}
}
