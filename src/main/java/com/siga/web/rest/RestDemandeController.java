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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.siga.domain.Demande;
import com.siga.domain.History;
import com.siga.repository.DemandeRepository;

@RestController
@RequestMapping("/api")
public class RestDemandeController {

	@Autowired
	private DemandeRepository demandeRepository;
	
	@RequestMapping(value="/demande",method=RequestMethod.POST)
	public ResponseEntity <Demande> saveDemande(@RequestBody Demande demande)
	{
		
		Date dateCreation=new Date();
		//demande.setDateMouvement(dateCreation);
		demande.setDateCreation(dateCreation);
		Demande result= demandeRepository.save(demande);
		return new ResponseEntity<Demande>(result,HttpStatus.CREATED);
		
		
	}
	
	@RequestMapping(value="/demande",method=RequestMethod.GET)
	public ResponseEntity<List<Demande>> findAllDemandes()
	{
		
		List <Demande> demandes=demandeRepository.findAll();
		return new ResponseEntity<List<Demande>> (demandes,HttpStatus.OK);
	}
	

	@RequestMapping(value="/demande",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteAll()
	{
	
		demandeRepository.deleteAll();
		return new ResponseEntity<String>("All deleted succfully.",HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	@RequestMapping(value="/demande/{idDemande}",method=RequestMethod.DELETE)
	public ResponseEntity<Demande> deleteDemande(@PathVariable ("idDemande")  Long idDemande)
	{
		
		demandeRepository.delete(idDemande);
		return new ResponseEntity<Demande>(HttpStatus.ACCEPTED);
		
	}
	
	
	@RequestMapping(value="/demande/{idDemande}",method=RequestMethod.GET)
	public ResponseEntity <Demande> findOne(@PathVariable ("idDemande") Long idDemande)
	{
		
		Demande result=demandeRepository.findOne(idDemande);
		return new ResponseEntity<Demande>(result,HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(value="/demandeHistory",method=RequestMethod.GET)
	public ResponseEntity <List<History>> getHistory(@RequestParam Long idDemande)
	{
		
		Demande result=demandeRepository.findOne(idDemande);
		List <History> h=result.getHistories();
		return new ResponseEntity<List<History>>(h,HttpStatus.ACCEPTED);
	}
}
