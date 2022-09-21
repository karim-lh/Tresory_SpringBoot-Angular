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

import com.siga.domain.AgenceBancaire;
import com.siga.repository.AgenceBancaireRepository;

@RestController
@RequestMapping("/api")
public class RestAgenceBancaireController {

	@Autowired
	private AgenceBancaireRepository agenceBancaireRepository;
	
	@RequestMapping(value="/agenceBancaire",method=RequestMethod.POST)
	public ResponseEntity<AgenceBancaire> saveAgenceBancaire(@RequestBody AgenceBancaire agenceBancaire)
	{
		//agenceBancaire.getSiege().add(agenceBancaire);
		Date dateAjoute= new Date();
		agenceBancaire.setDateAjoute(dateAjoute);
		AgenceBancaire result=agenceBancaireRepository.save(agenceBancaire);
		return new ResponseEntity<AgenceBancaire>(result,HttpStatus.OK);
	}
	
	@RequestMapping(value="/agenceBancaire",method=RequestMethod.GET )
	public ResponseEntity<List<AgenceBancaire> > findAll()
	{
		List<AgenceBancaire> agencesBancaire=agenceBancaireRepository.findAll();
		return new ResponseEntity<List<AgenceBancaire>> (agencesBancaire,HttpStatus.OK);
	}
	
	

	@RequestMapping(value="/agenceBancaire/{idAgenceBancaire}",method=RequestMethod.GET)
	public ResponseEntity <AgenceBancaire> findOne(@PathVariable ("idAgenceBancaire") Long idAgenceBancaire)
	{
		
		AgenceBancaire result=agenceBancaireRepository.findOne(idAgenceBancaire);
		return new ResponseEntity<AgenceBancaire>(result,HttpStatus.ACCEPTED);
	}
	 
	
}
