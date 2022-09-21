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

import com.siga.domain.Journal;
import com.siga.repository.JournalRepository;

@RestController
@RequestMapping("/api")
public class RestJournalController {

	@Autowired
	private JournalRepository journalRepository;
	
	@RequestMapping(value="/journal",method=RequestMethod.POST)
	public ResponseEntity <Journal> saveJournal(@RequestBody Journal journal)
	{
		
		Date dateCreation=new Date();
		journal.setDateCreation(dateCreation);
		Journal result= journalRepository.save(journal);
		return new ResponseEntity<Journal>(result,HttpStatus.CREATED);
		
		
	}
	
	@RequestMapping(value="/journal",method=RequestMethod.GET)
	public ResponseEntity<List<Journal>> findAllJournaux()
	{
		
		List <Journal> journaux=journalRepository.findAll();
		return new ResponseEntity<List<Journal>> (journaux,HttpStatus.OK);
	}
	

	@RequestMapping(value="/journal",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteAll()
	{
	
		journalRepository.deleteAll();
		return new ResponseEntity<String>("All deleted succfully.",HttpStatus.ACCEPTED);
		
	}
	
	
	
	
	@RequestMapping(value="/journal/{idJournal}",method=RequestMethod.DELETE)
	public ResponseEntity<Journal> deleteJournal(@PathVariable ("idJournal")  Long idJournal)
	{
		
		journalRepository.delete(idJournal);
		return new ResponseEntity<Journal>(HttpStatus.ACCEPTED);
		
	}
	
	
	@RequestMapping(value="/journal/{idJournal}",method=RequestMethod.GET)
	public ResponseEntity <Journal> findOne(@PathVariable ("idJournal") Long idJournal)
	{
		
		Journal result=journalRepository.findOne(idJournal);
		return new ResponseEntity<Journal>(result,HttpStatus.ACCEPTED);
	}
	 
	
}
