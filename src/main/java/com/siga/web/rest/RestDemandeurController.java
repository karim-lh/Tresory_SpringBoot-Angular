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

import com.siga.domain.Demandeur;
import com.siga.repository.DemandeurRepository;
@RequestMapping("/api")
@RestController
public class RestDemandeurController {

	@Autowired
	private DemandeurRepository demandeurRepository;
	
	@RequestMapping(value="/demandeur",method=RequestMethod.POST)
	public ResponseEntity <Demandeur> saveDemandeur(@RequestBody Demandeur demandeur)
	{
		
		Date dateCreation=new Date();
		//demandeur.setDateMouvement(dateCreation);
		Demandeur result= demandeurRepository.save(demandeur);
		return new ResponseEntity<Demandeur>(result,HttpStatus.CREATED);
		
		
	}
	
	@RequestMapping(value="/demandeur",method=RequestMethod.GET)
	public ResponseEntity<List<Demandeur>> findAllDemandeurs()
	{
		
		List <Demandeur> demandeurs=demandeurRepository.findAll();
		return new ResponseEntity<List<Demandeur>> (demandeurs,HttpStatus.OK);
	}
	

	@RequestMapping(value="/demandeur",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteAll()
	{
	
		demandeurRepository.deleteAll();
		return new ResponseEntity<String>("All deleted succfully.",HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	@RequestMapping(value="/demandeur/{idDemandeur}",method=RequestMethod.DELETE)
	public ResponseEntity<Demandeur> deleteDemandeur(@PathVariable ("idDemandeur")  Long idDemandeur)
	{
		
		demandeurRepository.delete(idDemandeur);
		return new ResponseEntity<Demandeur>(HttpStatus.ACCEPTED);
		
	}
	
	
	@RequestMapping(value="/demandeur/{idDemandeur}",method=RequestMethod.GET)
	public ResponseEntity <Demandeur> findOne(@PathVariable ("idDemandeur") Long idDemandeur)
	{
		
		Demandeur result=demandeurRepository.findOne(idDemandeur);
		return new ResponseEntity<Demandeur>(result,HttpStatus.ACCEPTED);
	}
}
