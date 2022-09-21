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

import com.siga.domain.TypePieceJointe;
import com.siga.repository.TypePieceJointeRepository;

@RestController
@RequestMapping("/api")
public class RestTypePieceJointeController {


	@Autowired
	private TypePieceJointeRepository typePieceJointeRepository;
	
	@RequestMapping(value="/typePieceJointe",method=RequestMethod.POST)
	public ResponseEntity <TypePieceJointe> saveTypePieceJointe(@RequestBody TypePieceJointe typePieceJointe)
	{
		
		Date dateCreation=new Date();
		typePieceJointe.setDateCreation(dateCreation);
		TypePieceJointe result= typePieceJointeRepository.save(typePieceJointe);
		return new ResponseEntity<TypePieceJointe>(result,HttpStatus.CREATED);
		
		
	}
	
	@RequestMapping(value="/typePieceJointe",method=RequestMethod.GET)
	public ResponseEntity<List<TypePieceJointe>> findAllTypesPieceJointe()
	{
		
		List <TypePieceJointe> typesPieceJointe=typePieceJointeRepository.findAll();
		return new ResponseEntity<List<TypePieceJointe>> (typesPieceJointe,HttpStatus.OK);
	}
	

	@RequestMapping(value="/typePieceJointe",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteAll()
	{
	
		typePieceJointeRepository.deleteAll();
		return new ResponseEntity<String>("All deleted succfully.",HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	@RequestMapping(value="/typePieceJointe/{idTypePieceJointe}",method=RequestMethod.DELETE)
	public ResponseEntity<TypePieceJointe> deleteTypePieceJointe(@PathVariable ("idTypePieceJointe")  Long idTypePieceJointe)
	{
		
		typePieceJointeRepository.delete(idTypePieceJointe);
		return new ResponseEntity<TypePieceJointe>(HttpStatus.ACCEPTED);
		
	}
	
	
	@RequestMapping(value="/typePieceJointe/{idTypePieceJointe}",method=RequestMethod.GET)
	public ResponseEntity <TypePieceJointe> findOne(@PathVariable ("idTypePieceJointe") Long idTypePieceJointe)
	{
		
		TypePieceJointe result=typePieceJointeRepository.findOne(idTypePieceJointe);
		return new ResponseEntity<TypePieceJointe>(result,HttpStatus.ACCEPTED);
	}
	 
	
	
}
