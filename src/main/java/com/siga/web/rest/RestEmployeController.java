package com.siga.web.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.siga.domain.Employe;
import com.siga.repository.EmployeRepository;

@RestController
@RequestMapping("/api")
public class RestEmployeController {
	@Autowired
	private EmployeRepository employeRepository;
	
	@RequestMapping(value="/employe",method=RequestMethod.POST)
	public ResponseEntity <Employe> saveEmploye(@RequestBody Employe employe)
	{
		
		Date dateCreation=new Date();
		//employe.setDateCreation(dateCreation);
		Employe result= employeRepository.save(employe);
		return new ResponseEntity<Employe>(result,HttpStatus.CREATED);
		
		
	}
	
	@RequestMapping(value="/employe",method=RequestMethod.GET)
	public ResponseEntity<List<Employe>> findAllFamillesCompte()
	{
		
		List <Employe> famillesCompte=employeRepository.findAll();
		return new ResponseEntity<List<Employe>> (famillesCompte,HttpStatus.OK);
	}
	

	@RequestMapping(value="/employe",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteAll()
	{
	
		employeRepository.deleteAll();
		return new ResponseEntity<String>("All deleted succfully.",HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	@RequestMapping(value="/employe/{idEmploye}",method=RequestMethod.DELETE)
	public ResponseEntity<Employe> deleteEmploye(@PathVariable ("idEmploye")  Long idEmploye)
	{
		
		employeRepository.delete(idEmploye);
		return new ResponseEntity<Employe>(HttpStatus.ACCEPTED);
		
	}
	
	
	@RequestMapping(value="/employe/{idEmploye}",method=RequestMethod.GET)
	public ResponseEntity <Employe> findOne(@PathVariable ("idEmploye") Long idEmploye)
	{
		
		Employe result=employeRepository.findOne(idEmploye);
		return new ResponseEntity<Employe>(result,HttpStatus.ACCEPTED);
	}
	 
}
