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

import com.siga.domain.PieceComptable;
import com.siga.repository.PieceComptableRepository;

@RestController
@RequestMapping("/api")
public class RestPieceComptableController {



	@Autowired
	private PieceComptableRepository pieceComptableRepository;
	
	@RequestMapping(value="/pieceComptable",method=RequestMethod.POST)
	public ResponseEntity <PieceComptable> savePieceComptable(@RequestBody PieceComptable pieceComptable)
	{
		
		Date dateCreation=new Date();
		pieceComptable.setDatePieceComptable(dateCreation);
		PieceComptable result= pieceComptableRepository.save(pieceComptable);
		return new ResponseEntity<PieceComptable>(result,HttpStatus.CREATED);
		
		
	}
	
	@RequestMapping(value="/pieceComptable",method=RequestMethod.GET)
	public ResponseEntity<List<PieceComptable>> findAllPieceComptables()
	{
		
		List <PieceComptable> pieces=pieceComptableRepository.findAll();
		return new ResponseEntity<List<PieceComptable>> (pieces,HttpStatus.OK);
	}
	

	@RequestMapping(value="/pieceComptable",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteAll()
	{
	
		pieceComptableRepository.deleteAll();
		return new ResponseEntity<String>("All deleted succfully.",HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	@RequestMapping(value="/pieceComptable/{idPieceComptable}",method=RequestMethod.DELETE)
	public ResponseEntity<PieceComptable> deletePieceComptable(@PathVariable ("idPieceComptable")  Long idPieceComptable)
	{
		
		pieceComptableRepository.delete(idPieceComptable);
		return new ResponseEntity<PieceComptable>(HttpStatus.ACCEPTED);
		
	}
	
	
	@RequestMapping(value="/pieceComptable/{idPieceComptable}",method=RequestMethod.GET)
	public ResponseEntity <PieceComptable> findOne(@PathVariable ("idPieceComptable") Long idPieceComptable)
	{
		
		PieceComptable result=pieceComptableRepository.findOne(idPieceComptable);
		return new ResponseEntity<PieceComptable>(result,HttpStatus.ACCEPTED);
	}
}
