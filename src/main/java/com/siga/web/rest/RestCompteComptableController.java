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

import com.siga.domain.CompteComptable;
import com.siga.repository.CompteComptableRepository;

@RestController
@RequestMapping("/api")
public class RestCompteComptableController {

	@Autowired
	private CompteComptableRepository compteComptableRepository;
	
	@RequestMapping(value="/compteComptable",method=RequestMethod.POST)
	public ResponseEntity <CompteComptable> savecompteComptable(@RequestBody CompteComptable compteComptable)
	{
		
	
		CompteComptable result= compteComptableRepository.save(compteComptable);
		return new ResponseEntity<CompteComptable>(result,HttpStatus.CREATED);
		
		
	}
	
	@RequestMapping(value="/compteComptable",method=RequestMethod.GET)
	public ResponseEntity<List<CompteComptable>> findAllcompteComptables()
	{
		
		List <CompteComptable> compteComptables=compteComptableRepository.findAll();
		return new ResponseEntity<List<CompteComptable>> (compteComptables,HttpStatus.OK);
	}
	

	@RequestMapping(value="/compteComptable",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteAll()
	{
	
		compteComptableRepository.deleteAll();
		return new ResponseEntity<String>("All deleted succfully.",HttpStatus.ACCEPTED);
		
	}
  	
	
	
	
	@RequestMapping(value="/compteComptable/{idcompteComptable}",method=RequestMethod.DELETE)
	public ResponseEntity<CompteComptable> deletecompteComptable(@PathVariable ("idcompteComptable")  Long idcompteComptable)
	{
		
		compteComptableRepository.delete(idcompteComptable);
		return new ResponseEntity<CompteComptable>(HttpStatus.ACCEPTED);
		
	}
	
	
	@RequestMapping(value="/compteComptable/{idcompteComptable}",method=RequestMethod.GET)
	public ResponseEntity <CompteComptable> findOne(@PathVariable ("idcompteComptable") Long idcompteComptable)
	{
		
		CompteComptable result=compteComptableRepository.findOne(idcompteComptable);
		return new ResponseEntity<CompteComptable>(result,HttpStatus.ACCEPTED);
	}
	 
}
