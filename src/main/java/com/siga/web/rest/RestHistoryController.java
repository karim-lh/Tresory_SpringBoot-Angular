package com.siga.web.rest;

import java.util.List;

import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.siga.domain.History;
import com.siga.repository.DemandeRepository;
import com.siga.repository.HistoryRepository;

@RestController
@RequestMapping("/api")
public class RestHistoryController {

	@Autowired
	private HistoryRepository historyRepository;
	@Autowired
	private DemandeRepository demandeRepository;
	
	    @Autowired
	    private RuntimeService runtimeService;
	private List<History> result;
	
	
	
	@RequestMapping(value="/history/{id}",method=RequestMethod.GET)
	public ResponseEntity<List<History>> getAllHsitory(@PathVariable Long id)
	{
		History E= new History();
	  List<History> histories= historyRepository.findAll();
	
	  Long x=histories.get(0).getDemande().getIdDemande();
	
	  System.out.println("id est"+x);
	

		return new ResponseEntity<List<History>> (histories,HttpStatus.OK);
	  
	  
	}
	
	@RequestMapping(value="/history",method=RequestMethod.GET)
	public ResponseEntity<List<History>> getAllHsitories()
	{
		
	  List<History> histories= historyRepository.findAll();	  
		return new ResponseEntity<List<History>> (histories,HttpStatus.OK);
	}
	
	
}
