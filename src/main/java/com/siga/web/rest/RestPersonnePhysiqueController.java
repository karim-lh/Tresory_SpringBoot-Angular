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

import com.siga.domain.PersonnePhysique;
import com.siga.repository.PersonnePhysiqueRepository;

@RestController
@RequestMapping("/api")
public class RestPersonnePhysiqueController {

	@Autowired
	private PersonnePhysiqueRepository PersonnePhysiqueRepository;
	
	@RequestMapping(value="/PersonnePhysique",method=RequestMethod.POST)
	public ResponseEntity <PersonnePhysique> savePersonnePhysique(@RequestBody PersonnePhysique personnePhysique)
	{
		
		Date dateCreation=new Date();
		
		String idan=personnePhysique.getNomPersonne()+personnePhysique.getPrenomPersonne();
		personnePhysique.setIdanttifiant(idan);
		PersonnePhysique result= PersonnePhysiqueRepository.save(personnePhysique);
		return new ResponseEntity<PersonnePhysique>(result,HttpStatus.CREATED);
		
		
	}
	
	@RequestMapping(value="/PersonnePhysique",method=RequestMethod.GET)
	public ResponseEntity<List<PersonnePhysique>> findAllFamillesCompte()
	{
		
		List <PersonnePhysique> personnes=PersonnePhysiqueRepository.findAll();
		return new ResponseEntity<List<PersonnePhysique>> (personnes,HttpStatus.OK);
	}
	

	@RequestMapping(value="/PersonnePhysique",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteAll()
	{
	
		PersonnePhysiqueRepository.deleteAll();
		return new ResponseEntity<String>("All deleted succfully.",HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	@RequestMapping(value="/PersonnePhysique/{idPersonnePhysique}",method=RequestMethod.DELETE)
	public ResponseEntity<PersonnePhysique> deletePersonnePhysique(@PathVariable ("idPersonnePhysique")  Long idPersonnePhysique)
	{
		
		PersonnePhysiqueRepository.delete(idPersonnePhysique);
		return new ResponseEntity<PersonnePhysique>(HttpStatus.ACCEPTED);
		
	}
	
	
	@RequestMapping(value="/PersonnePhysique/{idPersonnePhysique}",method=RequestMethod.GET)
	public ResponseEntity <PersonnePhysique> findOne(@PathVariable ("idPersonnePhysique") Long idPersonnePhysique)
	{
		
		PersonnePhysique result=PersonnePhysiqueRepository.findOne(idPersonnePhysique);
		return new ResponseEntity<PersonnePhysique>(result,HttpStatus.ACCEPTED);
	}
	 
	
	
	
}
