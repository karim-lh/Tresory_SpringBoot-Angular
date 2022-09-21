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

import com.siga.domain.Banque;
import com.siga.repository.BanqueRepository;

@RestController
@RequestMapping("/api")
public class RestBanqueController {


	

	@Autowired
	private BanqueRepository banqueRepository;
	
	@RequestMapping(value="/banque",method=RequestMethod.POST)
	public ResponseEntity <Banque> saveBanque(@RequestBody Banque banque)
	{
		
		Date dateCreation=new Date();
		banque.setDateAjoute(dateCreation);
		Banque result= banqueRepository.save(banque);
		return new ResponseEntity<Banque>(result,HttpStatus.CREATED);
		
		
	}
	
	@RequestMapping(value="/banque",method=RequestMethod.GET)
	public ResponseEntity<List<Banque>> findAllBanques()
	{
		
		List <Banque> banques= banqueRepository.findAll();
		return new ResponseEntity<List<Banque>> (banques,HttpStatus.OK);
	}
	

	@RequestMapping(value="/banque",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteAll()
	{
	
		banqueRepository.deleteAll();
		return new ResponseEntity<String>("All deleted succfully.",HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	@RequestMapping(value="/banque/{idBanque}",method=RequestMethod.DELETE)
	public ResponseEntity<Banque> deleteBanque(@PathVariable ("idBanque")  Long idBanque)
	{
		
		banqueRepository.delete(idBanque);
		return new ResponseEntity<Banque>(HttpStatus.ACCEPTED);
		
	}
	
	
	@RequestMapping(value="/banque/{idBanque}",method=RequestMethod.GET)
	public ResponseEntity <Banque> findOne(@PathVariable ("idBanque") Long idBanque)
	{
		
		Banque result=banqueRepository.findOne(idBanque);
		return new ResponseEntity<Banque>(result,HttpStatus.ACCEPTED);
	}
	 
	
}
