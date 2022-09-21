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

import com.siga.domain.FluxTresorerie;
import com.siga.repository.FluxTresorerieRepository;

@RestController
@RequestMapping("/api")
public class RestFluxTresorerieController {

	

	@Autowired
	private FluxTresorerieRepository fluxTreosorerieRepository;
	
	@RequestMapping(value="/fluxTreosorerie",method=RequestMethod.POST)
	public ResponseEntity <FluxTresorerie> saveFluxTresorerie(@RequestBody FluxTresorerie fluxTreosorerie)
	{
		
		Date dateCreation=new Date();
		fluxTreosorerie.setDateCreation(dateCreation);
		FluxTresorerie result= fluxTreosorerieRepository.save(fluxTreosorerie);
		return new ResponseEntity<FluxTresorerie>(result,HttpStatus.CREATED);
		
		
	}
	
	@RequestMapping(value="/fluxTreosorerie",method=RequestMethod.GET)
	public ResponseEntity<List<FluxTresorerie>> findAllFluxTresoreries()
	{
		
		List <FluxTresorerie> fluxTreosoreries= fluxTreosorerieRepository.findAll();
		return new ResponseEntity<List<FluxTresorerie>> (fluxTreosoreries,HttpStatus.OK);
	}
	

	@RequestMapping(value="/fluxTreosorerie",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteAll()
	{
	
		fluxTreosorerieRepository.deleteAll();
		return new ResponseEntity<String>("All deleted succfully.",HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	@RequestMapping(value="/fluxTreosorerie/{idFluxTresorerie}",method=RequestMethod.DELETE)
	public ResponseEntity<FluxTresorerie> deleteFluxTresorerie(@PathVariable ("idFluxTresorerie")  Long idFluxTresorerie)
	{
		
		fluxTreosorerieRepository.delete(idFluxTresorerie);
		return new ResponseEntity<FluxTresorerie>(HttpStatus.ACCEPTED);
		
	}
	
	
	@RequestMapping(value="/fluxTreosorerie/{idFluxTresorerie}",method=RequestMethod.GET)
	public ResponseEntity <FluxTresorerie> findOne(@PathVariable ("idFluxTresorerie") Long idFluxTresorerie)
	{
		
		FluxTresorerie result=fluxTreosorerieRepository.findOne(idFluxTresorerie);
		return new ResponseEntity<FluxTresorerie>(result,HttpStatus.ACCEPTED);
	}
	 
}
