package com.siga.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.siga.domain.MouvementTresorerie;
import com.siga.repository.MouvementTresorerieRepository;

@RestController
@RequestMapping("/api")
public class RestDepenseController {

	@Autowired
	private  MouvementTresorerieRepository mvtRepository;
	@RequestMapping(value="/depense",method=RequestMethod.GET)
	public ResponseEntity <List<MouvementTresorerie> > getAllDepenses()
	{
		List<MouvementTresorerie> mvts= mvtRepository.findAll();
		
		List<MouvementTresorerie> depenses =mvts ;
		
		for (int i=0;i<depenses.size() ;i++)
		{
			if (depenses.get(i).getTypeMouvement().equals("recette") )
				depenses.remove(i) ;
		}
	
	return new ResponseEntity<List<MouvementTresorerie>>(depenses,HttpStatus.OK);
	}
	
}
