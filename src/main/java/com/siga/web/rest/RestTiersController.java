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

import com.siga.domain.Tiers;
import com.siga.repository.TiersRepository;

@RestController
@RequestMapping("/api")
public class RestTiersController {


	@Autowired
	private TiersRepository tiersRepository;
	
	@RequestMapping(value="/tiers",method=RequestMethod.POST)
	public ResponseEntity <Tiers> saveTiers(@RequestBody Tiers tiers)
	{
		
		Date dateCreation=new Date();
		tiers.setDateAjoute(dateCreation);
		Tiers result= tiersRepository.save(tiers);
		return new ResponseEntity<Tiers>(result,HttpStatus.CREATED);
		
		
	}
	
	@RequestMapping(value="/tiers",method=RequestMethod.GET)
	public ResponseEntity<List<Tiers>> findAllTiers()
	{
		
		List <Tiers> tiers=tiersRepository.findAll();
		return new ResponseEntity<List<Tiers>> (tiers,HttpStatus.OK);
	}
	

	@RequestMapping(value="/tiers",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteAll()
	{
	
		tiersRepository.deleteAll();
		return new ResponseEntity<String>("All deleted succfully.",HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	@RequestMapping(value="/tiers/{idTiers}",method=RequestMethod.DELETE)
	public ResponseEntity<Tiers> deleteTiers(@PathVariable ("idTiers")  Long idTiers)
	{
		
		tiersRepository.delete(idTiers);
		return new ResponseEntity<Tiers>(HttpStatus.ACCEPTED);
		
	}
	
	
	@RequestMapping(value="/tiers/{idTiers}",method=RequestMethod.GET)
	public ResponseEntity <Tiers> findOne(@PathVariable ("idTiers") Long idTiers)
	{
		
		Tiers result=tiersRepository.findOne(idTiers);
		return new ResponseEntity<Tiers>(result,HttpStatus.ACCEPTED);
	}
	 
	
	
}
