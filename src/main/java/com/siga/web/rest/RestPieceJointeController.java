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

import com.siga.domain.PieceJointe;
import com.siga.repository.PieceJointeRepository;

@RestController
@RequestMapping("/api")
public class RestPieceJointeController {


	@Autowired
	private PieceJointeRepository pieceJointeRepository;
	
	@RequestMapping(value="/pieceJointe",method=RequestMethod.POST)
	public ResponseEntity <PieceJointe> savePieceJointe(@RequestBody PieceJointe pieceJointe)
	{
		
		Date dateCreation=new Date();
	//	pieceJointe.setDateCreation(dateCreation);
		PieceJointe result= pieceJointeRepository.save(pieceJointe);
		return new ResponseEntity<PieceJointe>(result,HttpStatus.CREATED);
		
		
	}
	
	@RequestMapping(value="/pieceJointe",method=RequestMethod.GET)
	public ResponseEntity<List<PieceJointe>> findAllPieceJointes()
	{
		
		List <PieceJointe> pieces=pieceJointeRepository.findAll();
		return new ResponseEntity<List<PieceJointe>> (pieces,HttpStatus.OK);
	}
	

	@RequestMapping(value="/pieceJointe",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteAll()
	{
	
		pieceJointeRepository.deleteAll();
		return new ResponseEntity<String>("All deleted succfully.",HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	@RequestMapping(value="/pieceJointe/{idPieceJointe}",method=RequestMethod.DELETE)
	public ResponseEntity<PieceJointe> deletePieceJointe(@PathVariable ("idPieceJointe")  Long idPieceJointe)
	{
		
		pieceJointeRepository.delete(idPieceJointe);
		return new ResponseEntity<PieceJointe>(HttpStatus.ACCEPTED);
		
	}
	
	
	@RequestMapping(value="/pieceJointe/{idPieceJointe}",method=RequestMethod.GET)
	public ResponseEntity <PieceJointe> findOne(@PathVariable ("idPieceJointe") Long idPieceJointe)
	{
		
		PieceJointe result=pieceJointeRepository.findOne(idPieceJointe);
		return new ResponseEntity<PieceJointe>(result,HttpStatus.ACCEPTED);
	}
}
