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

import com.siga.domain.TypePieceComptable;
import com.siga.repository.TypePieceComptableRepository;

@RestController
@RequestMapping("/api")
public class RestTypePieceComptableController {

	@Autowired
	private TypePieceComptableRepository typePieceComptableRepository;
	
	@RequestMapping(value="/typePieceComptable",method=RequestMethod.POST)
	public ResponseEntity <TypePieceComptable> saveTypePieceComptable(@RequestBody TypePieceComptable typePieceComptable)
	{
		
		Date dateCreation=new Date();
		typePieceComptable.setDateCreation(dateCreation);
		TypePieceComptable result= typePieceComptableRepository.save(typePieceComptable);
		return new ResponseEntity<TypePieceComptable>(result,HttpStatus.CREATED);
		
		
	}
	
	@RequestMapping(value="/typePieceComptable",method=RequestMethod.GET)
	public ResponseEntity<List<TypePieceComptable>> findAllTypesPieceComptable()
	{
		
		List <TypePieceComptable> typesPieceComptable=typePieceComptableRepository.findAll();
		return new ResponseEntity<List<TypePieceComptable>> (typesPieceComptable,HttpStatus.OK);
	}
	

	@RequestMapping(value="/typePieceComptable",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteAll()
	{
	
		typePieceComptableRepository.deleteAll();
		return new ResponseEntity<String>("All deleted succfully.",HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	@RequestMapping(value="/typePieceComptable/{idTypePieceComptable}",method=RequestMethod.DELETE)
	public ResponseEntity<TypePieceComptable> deleteTypePieceComptable(@PathVariable ("idTypePieceComptable")  Long idTypePieceComptable)
	{
		
		typePieceComptableRepository.delete(idTypePieceComptable);
		return new ResponseEntity<TypePieceComptable>(HttpStatus.ACCEPTED);
		
	}
	
	
	@RequestMapping(value="/typePieceComptable/{idTypePieceComptable}",method=RequestMethod.GET)
	public ResponseEntity <TypePieceComptable> findOne(@PathVariable ("idTypePieceComptable") Long idTypePieceComptable)
	{
		
		TypePieceComptable result=typePieceComptableRepository.findOne(idTypePieceComptable);
		return new ResponseEntity<TypePieceComptable>(result,HttpStatus.ACCEPTED);
	}
	 
	
	
}
