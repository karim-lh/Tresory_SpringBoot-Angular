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

import com.siga.domain.Societe;
import com.siga.repository.SocieteRepository;

@RestController
@RequestMapping("/api")
public class RestSocieteController {

	

	@Autowired
	private SocieteRepository societeRepository;
	
	@RequestMapping(value="/societe",method=RequestMethod.POST)
	public ResponseEntity <Societe> saveSociete(@RequestBody Societe societe)
	{
		
		Date dateCreation=new Date();
		societe.setDateCreation(dateCreation);
		Societe result= societeRepository.save(societe);
		return new ResponseEntity<Societe>(result,HttpStatus.CREATED);
		
		
	}
	
	@RequestMapping(value="/societe",method=RequestMethod.GET)
	public ResponseEntity<List<Societe>> findAllSocietes()
	{
		
		List <Societe> societies=societeRepository.findAll();
		return new ResponseEntity<List<Societe>> (societies,HttpStatus.OK);
	}
	

	@RequestMapping(value="/societe",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteAll()
	{
	
		societeRepository.deleteAll();
		return new ResponseEntity<String>("All deleted succfully.",HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	@RequestMapping(value="/societe/{idSociete}",method=RequestMethod.DELETE)
	public ResponseEntity<Societe> deleteSociete(@PathVariable ("idSociete")  Long idSociete)
	{
		
		societeRepository.delete(idSociete);
		return new ResponseEntity<Societe>(HttpStatus.ACCEPTED);
		
	}
	
	
	@RequestMapping(value="/societe/{idSociete}",method=RequestMethod.GET)
	public ResponseEntity <Societe> findOne(@PathVariable ("idSociete") Long idSociete)
	{
		
		Societe result=societeRepository.findOne(idSociete);
		return new ResponseEntity<Societe>(result,HttpStatus.ACCEPTED);
	}
	 
	
	
}
