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

import com.siga.domain.FamilleCompte;
import com.siga.repository.FamilleCompteRepository;

@RestController
@RequestMapping("/api")
public class RestFamilleCompteController {

	

	@Autowired
	private FamilleCompteRepository familleCompteRepository;
	
	@RequestMapping(value="/familleCompte",method=RequestMethod.POST)
	public ResponseEntity <FamilleCompte> saveFamilleCompte(@RequestBody FamilleCompte familleCompte)
	{
		
		Date dateCreation=new Date();
		familleCompte.setDateCreation(dateCreation);
		FamilleCompte result= familleCompteRepository.save(familleCompte);
		return new ResponseEntity<FamilleCompte>(result,HttpStatus.CREATED);
		
		
	}
	
	@RequestMapping(value="/familleCompte",method=RequestMethod.GET)
	public ResponseEntity<List<FamilleCompte>> findAllFamillesCompte()
	{
		
		List <FamilleCompte> famillesCompte=familleCompteRepository.findAll();
		return new ResponseEntity<List<FamilleCompte>> (famillesCompte,HttpStatus.OK);
	}
	

	@RequestMapping(value="/familleCompte",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteAll()
	{
	
		familleCompteRepository.deleteAll();
		return new ResponseEntity<String>("All deleted succfully.",HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	@RequestMapping(value="/familleCompte/{idFamilleCompte}",method=RequestMethod.DELETE)
	public ResponseEntity<FamilleCompte> deleteFamilleCompte(@PathVariable ("idFamilleCompte")  Long idFamilleCompte)
	{
		
		familleCompteRepository.delete(idFamilleCompte);
		return new ResponseEntity<FamilleCompte>(HttpStatus.ACCEPTED);
		
	}
	
	
	@RequestMapping(value="/familleCompte/{idFamilleCompte}",method=RequestMethod.GET)
	public ResponseEntity <FamilleCompte> findOne(@PathVariable ("idFamilleCompte") Long idFamilleCompte)
	{
		
		FamilleCompte result=familleCompteRepository.findOne(idFamilleCompte);
		return new ResponseEntity<FamilleCompte>(result,HttpStatus.ACCEPTED);
	}
	 
	
	
	
}
