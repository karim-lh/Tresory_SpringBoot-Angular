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

import com.siga.domain.CompteTresorerie;
import com.siga.repository.CompteTresorerieRepository;
@RestController
@RequestMapping("/api")
public class RestCompteTresorerieController {


	

	@Autowired
	private CompteTresorerieRepository compteTresorerieRepository;
	
	@RequestMapping(value="/compteTresorerie",method=RequestMethod.POST)
	public ResponseEntity <CompteTresorerie> saveCompteTresorerie(@RequestBody CompteTresorerie compteTresorerie)
	{
		
		Date dateCreation=new Date();
		compteTresorerie.setDateOouverture(dateCreation);
		CompteTresorerie result= compteTresorerieRepository.save(compteTresorerie);
		return new ResponseEntity<CompteTresorerie>(result,HttpStatus.CREATED);
		
		
	}
	
	@RequestMapping(value="/compteTresorerie",method=RequestMethod.GET)
	public ResponseEntity<List<CompteTresorerie>> findAllCompteTresoreries()
	{
		
		List <CompteTresorerie> compteTresoreries= compteTresorerieRepository.findAll();
		return new ResponseEntity<List<CompteTresorerie>> (compteTresoreries,HttpStatus.OK);
	}
	

	@RequestMapping(value="/compteTresorerie",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteAll()
	{
	
		compteTresorerieRepository.deleteAll();
		return new ResponseEntity<String>("All deleted succfully.",HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	@RequestMapping(value="/compteTresorerie/{idCompteTresorerie}",method=RequestMethod.DELETE)
	public ResponseEntity<CompteTresorerie> deleteCompteTresorerie(@PathVariable ("idCompteTresorerie")  Long idCompteTresorerie)
	{
		
		compteTresorerieRepository.delete(idCompteTresorerie);
		return new ResponseEntity<CompteTresorerie>(HttpStatus.ACCEPTED);
		
	}
	
	
	@RequestMapping(value="/compteTresorerie/{idCompteTresorerie}",method=RequestMethod.GET)
	public ResponseEntity <CompteTresorerie> findOne(@PathVariable ("idCompteTresorerie") Long idCompteTresorerie)
	{
		
		CompteTresorerie result=compteTresorerieRepository.findOne(idCompteTresorerie);
		return new ResponseEntity<CompteTresorerie>(result,HttpStatus.ACCEPTED);
	}
	 
}
