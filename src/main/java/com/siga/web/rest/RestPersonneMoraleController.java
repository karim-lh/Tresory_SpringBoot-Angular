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

import com.siga.domain.PersonneMorale;
import com.siga.repository.PersonneMoraleRepository;

@RestController
@RequestMapping("/api")
public class RestPersonneMoraleController {

	@Autowired
	private PersonneMoraleRepository PersonneMoraleRepository;
	
	@RequestMapping(value="/PersonneMorale",method=RequestMethod.POST)
	public ResponseEntity <PersonneMorale> savePersonneMorale(@RequestBody PersonneMorale personneMorale)
	{
		
		Date dateCreation=new Date();
		personneMorale.setIdanttifiant(personneMorale.getLibelle());
		PersonneMorale result= PersonneMoraleRepository.save(personneMorale);
		return new ResponseEntity<PersonneMorale>(result,HttpStatus.CREATED);
		
		
	}
	
	@RequestMapping(value="/PersonneMorale",method=RequestMethod.GET)
	public ResponseEntity<List<PersonneMorale>> findAllFamillesCompte()
	{
		
		List <PersonneMorale> personnes=PersonneMoraleRepository.findAll();
		return new ResponseEntity<List<PersonneMorale>> (personnes,HttpStatus.OK);
	}
	

	@RequestMapping(value="/PersonneMorale",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteAll()
	{
	
		PersonneMoraleRepository.deleteAll();
		return new ResponseEntity<String>("All deleted succfully.",HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	@RequestMapping(value="/PersonneMorale/{idPersonneMorale}",method=RequestMethod.DELETE)
	public ResponseEntity<PersonneMorale> deletePersonneMorale(@PathVariable ("idPersonneMorale")  Long idPersonneMorale)
	{
		
		PersonneMoraleRepository.delete(idPersonneMorale);
		return new ResponseEntity<PersonneMorale>(HttpStatus.ACCEPTED);
		
	}
	
	
	@RequestMapping(value="/PersonneMorale/{idPersonneMorale}",method=RequestMethod.GET)
	public ResponseEntity <PersonneMorale> findOne(@PathVariable ("idPersonneMorale") Long idPersonneMorale)
	{
		
		PersonneMorale result=PersonneMoraleRepository.findOne(idPersonneMorale);
		return new ResponseEntity<PersonneMorale>(result,HttpStatus.ACCEPTED);
	}
	
}
