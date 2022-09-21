package com.siga.web.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.siga.domain.Devise;
import com.siga.repository.DeviseRepository;

@RestController
@RequestMapping("/api")
public class RestDeviseController {

	
	@Autowired
	private DeviseRepository deviseRepository;
	
	@RequestMapping(value="/devise",method=RequestMethod.POST)
	public ResponseEntity <Devise> saveDevise(@RequestBody Devise devise)
	{
		
	
		Devise result= deviseRepository.save(devise);
		return new ResponseEntity<Devise>(result,HttpStatus.CREATED);
		
		
	}
	
	@RequestMapping(value="/devise",method=RequestMethod.GET)
	public ResponseEntity<List<Devise>> findAllDevises()
	{
		
		List <Devise> devises=deviseRepository.findAll();
		return new ResponseEntity<List<Devise>> (devises,HttpStatus.OK);
	}
	

	@RequestMapping(value="/devise",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteAll()
	{
	
		deviseRepository.deleteAll();
		return new ResponseEntity<String>("All deleted succfully.",HttpStatus.ACCEPTED);
		
	}
  	
	
	
	
	@RequestMapping(value="/devise/{idDevise}",method=RequestMethod.DELETE)
	public ResponseEntity<Devise> deleteDevise(@PathVariable ("idDevise")  Long idDevise)
	{
		
		deviseRepository.delete(idDevise);
		return new ResponseEntity<Devise>(HttpStatus.ACCEPTED);
		
	}
	
	
	@RequestMapping(value="/devise/{idDevise}",method=RequestMethod.GET)
	public ResponseEntity <Devise> findOne(@PathVariable ("idDevise") Long idDevise)
	{
		
		Devise result=deviseRepository.findOne(idDevise);
		return new ResponseEntity<Devise>(result,HttpStatus.ACCEPTED);
	}
	 
	
	
}
