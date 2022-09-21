package com.siga.web.rest;

import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

import javax.validation.Valid;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.siga.domain.Demande;
import com.siga.domain.MouvementTresorerie;
import com.siga.repository.DemandeRepository;
import com.siga.repository.MouvementTresorerieRepository;
import com.siga.repository.UserRepository;
import com.siga.security.SecurityUtils;

@RestController
@RequestMapping("/api")
public class RestDemandeMouvementContrroller {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private DemandeRepository demandeRepository;
	
	@Autowired
	private MouvementTresorerieRepository mouvementRepository;
	
	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	@RequestMapping(value = "/demandeMouvement", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Demande createDemande(@Valid @RequestBody Demande demande) throws URISyntaxException {
		MouvementTresorerie mvt=demande.getMouvement();
		mvt.setStatus(0);
	   float montantDevise=mvt.getMontantTaxe();
	   
	   mvt.setMontantDevise(montantDevise);
	   
	  float taux= mvt.getTauxChangeMouvement();
	   float montantLocal=montantDevise*taux;
	   mvt.setMontantDeviseLocal(montantLocal);
	   mvt.setSold(montantLocal);
	   mvt.setDemandeur(SecurityUtils.getCurrentUserLogin().get());
		mouvementRepository.save(mvt);
		demande.setStatut("E");
		
		//demande.setInitiateur(initiateur);
	    
		demande.setInitiateur(SecurityUtils.getCurrentUserLogin().get());
		Date date=new Date();
		demande.setDateCreation(date);
		Demande result = demandeRepository.save(demande);
		Map<String, Object> vars = Collections.<String, Object>singletonMap("demande", result);
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("demandeTresorerieV13", vars);
		Task task = taskService.createTaskQuery().processInstanceId(processInstance.getId())
				.taskCandidateGroup("AGENT").singleResult();
		taskService.complete(task.getId());
		return result;
		
	}
	
	
}
