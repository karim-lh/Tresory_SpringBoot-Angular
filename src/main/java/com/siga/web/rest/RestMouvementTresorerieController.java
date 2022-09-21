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

import com.siga.domain.MouvementTresorerie;
import com.siga.repository.MouvementTresorerieRepository;

@RestController
@RequestMapping("/api")
public class RestMouvementTresorerieController {



	@Autowired
	private MouvementTresorerieRepository mouvementTresorerieRepository;
	
	@RequestMapping(value="/mouvementTresorerie",method=RequestMethod.POST)
	public ResponseEntity <MouvementTresorerie> saveMouvementTresorerie(@RequestBody MouvementTresorerie mouvementTresorerie)
	{
		

		MouvementTresorerie result= mouvementTresorerieRepository.save(mouvementTresorerie);
		return new ResponseEntity<MouvementTresorerie>(result,HttpStatus.CREATED);
		
		
	}
	
	@RequestMapping(value="/mouvementTresorerie",method=RequestMethod.GET)
	public ResponseEntity<List<MouvementTresorerie>> findAllMouvementTresoreries()
	{
		
		List <MouvementTresorerie> mouvementsTresorerie=mouvementTresorerieRepository.findAll();
	
		
		return new ResponseEntity<List<MouvementTresorerie>> (mouvementsTresorerie,HttpStatus.OK);
	}
	
	@RequestMapping(value="/all-depense",method=RequestMethod.GET)
	public ResponseEntity<List<MouvementTresorerie>> findAllDepense()
	{
		
		List <MouvementTresorerie> mouvementsTresorerie=mouvementTresorerieRepository.findAllByTypeMouvement("depense");
	
		
		return new ResponseEntity<List<MouvementTresorerie>> (mouvementsTresorerie,HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/all-recette",method=RequestMethod.GET)
	public ResponseEntity<List<MouvementTresorerie>> findAllRecette()
	{
		
		List <MouvementTresorerie> mouvementsTresorerie=mouvementTresorerieRepository.findAllByTypeMouvement("recette");
	
		
		return new ResponseEntity<List<MouvementTresorerie>> (mouvementsTresorerie,HttpStatus.OK);
	}
	

	@RequestMapping(value="/mouvementTresorerie",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteAll()
	{
	
		mouvementTresorerieRepository.deleteAll();
		return new ResponseEntity<String>("All deleted succfully.",HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	@RequestMapping(value="/mouvementTresorerie/{idMouvementTresorerie}",method=RequestMethod.DELETE)
	public ResponseEntity<MouvementTresorerie> deleteMouvementTresorerie(@PathVariable ("idMouvementTresorerie")  Long idMouvementTresorerie)
	{
		
		mouvementTresorerieRepository.delete(idMouvementTresorerie);
		return new ResponseEntity<MouvementTresorerie>(HttpStatus.ACCEPTED);
		
	}
	
	
	@RequestMapping(value="/mouvementTresorerie/{idMouvementTresorerie}",method=RequestMethod.GET)
	public ResponseEntity <MouvementTresorerie> findOne(@PathVariable ("idMouvementTresorerie") Long idMouvementTresorerie)
	{
		
		MouvementTresorerie result=mouvementTresorerieRepository.findOne(idMouvementTresorerie);
		return new ResponseEntity<MouvementTresorerie>(result,HttpStatus.ACCEPTED);
	}
}
