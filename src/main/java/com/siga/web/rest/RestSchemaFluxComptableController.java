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

import com.siga.domain.SchemaFluxComptable;
import com.siga.repository.SchemaFluxComptableRepository;

@RestController
@RequestMapping("/api")
public class RestSchemaFluxComptableController {


	@Autowired
	private SchemaFluxComptableRepository schemaFluxComptableRepository;
	
	@RequestMapping(value="/schemaFluxComptable",method=RequestMethod.POST)
	public ResponseEntity <SchemaFluxComptable> saveSchemaFluxComptable(@RequestBody SchemaFluxComptable schemaFluxComptable)
	{
		
		Date dateCreation=new Date();
		schemaFluxComptable.setDateCreation(dateCreation);
		SchemaFluxComptable result= schemaFluxComptableRepository.save(schemaFluxComptable);
		return new ResponseEntity<SchemaFluxComptable>(result,HttpStatus.CREATED);
		
		
	}
	
	@RequestMapping(value="/schemaFluxComptable",method=RequestMethod.GET)
	public ResponseEntity<List<SchemaFluxComptable>> findAllJournaux()
	{
		
		List <SchemaFluxComptable> schemasFluxComptable=schemaFluxComptableRepository.findAll();
		return new ResponseEntity<List<SchemaFluxComptable>> (schemasFluxComptable,HttpStatus.OK);
	}
	

	@RequestMapping(value="/schemaFluxComptable",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteAll()
	{
	
		schemaFluxComptableRepository.deleteAll();
		return new ResponseEntity<String>("All deleted succfully.",HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	@RequestMapping(value="/schemaFluxComptable/{idSchemaFluxComptable}",method=RequestMethod.DELETE)
	public ResponseEntity<SchemaFluxComptable> deleteSchemaFluxComptable(@PathVariable ("idSchemaFluxComptable")  Long idSchemaFluxComptable)
	{
		
		schemaFluxComptableRepository.delete(idSchemaFluxComptable);
		return new ResponseEntity<SchemaFluxComptable>(HttpStatus.ACCEPTED);
		
	}
	
	
	@RequestMapping(value="/schemaFluxComptable/{idSchemaFluxComptable}",method=RequestMethod.GET)
	public ResponseEntity <SchemaFluxComptable> findOne(@PathVariable ("idSchemaFluxComptable") Long idSchemaFluxComptable)
	{
		
		SchemaFluxComptable result=schemaFluxComptableRepository.findOne(idSchemaFluxComptable);
		return new ResponseEntity<SchemaFluxComptable>(result,HttpStatus.ACCEPTED);
	}
	 
	
}
