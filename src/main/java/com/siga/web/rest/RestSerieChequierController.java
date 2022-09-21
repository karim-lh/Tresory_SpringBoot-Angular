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

import com.siga.domain.SerieChequier;
import com.siga.repository.SerieChequierRepository;

@RestController
@RequestMapping("/api")
public class RestSerieChequierController {

	

	@Autowired
	private SerieChequierRepository serieChequierRepository;
	
	@RequestMapping(value="/serieChequier",method=RequestMethod.POST)
	public ResponseEntity <SerieChequier> saveSerieChequier(@RequestBody SerieChequier serieChequier)
	{
		
		
		SerieChequier result= serieChequierRepository.save(serieChequier);
		return new ResponseEntity<SerieChequier>(result,HttpStatus.CREATED);
		
		
	}
	
	@RequestMapping(value="/serieChequier",method=RequestMethod.GET)
	public ResponseEntity<List<SerieChequier>> findAllSeriesChequier()
	{
		
		List <SerieChequier> seriesChequier=serieChequierRepository.findAll();
		return new ResponseEntity<List<SerieChequier>> (seriesChequier,HttpStatus.OK);
	}
	

	@RequestMapping(value="/serieChequier",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteAll()
	{
	
		serieChequierRepository.deleteAll();
		return new ResponseEntity<String>("All deleted succfully.",HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	@RequestMapping(value="/serieChequier/{idSerieChequier}",method=RequestMethod.DELETE)
	public ResponseEntity<SerieChequier> deleteSerieChequier(@PathVariable ("idSerieChequier")  Long idSerieChequier)
	{
		
		serieChequierRepository.delete(idSerieChequier);
		return new ResponseEntity<SerieChequier>(HttpStatus.ACCEPTED);
		
	}
	
	
	@RequestMapping(value="/serieChequier/{idSerieChequier}",method=RequestMethod.GET)
	public ResponseEntity <SerieChequier> findOne(@PathVariable ("idSerieChequier") Long idSerieChequier)
	{
		
		SerieChequier result=serieChequierRepository.findOne(idSerieChequier);
		return new ResponseEntity<SerieChequier>(result,HttpStatus.ACCEPTED);
	}
	 
	
}
