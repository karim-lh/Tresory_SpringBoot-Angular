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

import com.siga.domain.Pays;
import com.siga.repository.PaysRepository;
@RestController
@RequestMapping("/api")
public class RestPaysController {

	
	@Autowired
	private PaysRepository paysRepository;
	
	@RequestMapping(value="/pays",method=RequestMethod.POST)
	public ResponseEntity <Pays> savePays(@RequestBody Pays pays)
	{
		
		
		Pays result= paysRepository.save(pays);
		return new ResponseEntity<Pays>(result,HttpStatus.CREATED);
		
		
	}
	
	@RequestMapping(value="/pays",method=RequestMethod.GET)
	public ResponseEntity<List<Pays>> findAllPays()
	{
		
		List <Pays> pays=paysRepository.findAll();
		return new ResponseEntity<List<Pays>> (pays,HttpStatus.OK);
	}
	

	@RequestMapping(value="/pays",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteAll()
	{
	
		paysRepository.deleteAll();
		return new ResponseEntity<String>("All deleted succfully.",HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	@RequestMapping(value="/pays/{idPays}",method=RequestMethod.DELETE)
	public ResponseEntity<Pays> deletePays(@PathVariable ("idPays")  Long idPays)
	{
		
		paysRepository.delete(idPays);
		return new ResponseEntity<Pays>(HttpStatus.ACCEPTED);
		
	}
	
	
	@RequestMapping(value="/pays/{idPays}",method=RequestMethod.GET)
	public ResponseEntity <Pays> findOne(@PathVariable ("idPays") Long idPays)
	{
		
		Pays result=paysRepository.findOne(idPays);
		return new ResponseEntity<Pays>(result,HttpStatus.ACCEPTED);
	}
	 
	
}
