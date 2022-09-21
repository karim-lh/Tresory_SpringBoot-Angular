package com.siga.web.rest;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.siga.domain.Demande;
import com.siga.domain.History;
import com.siga.domain.MouvementTresorerie;
import com.siga.domain.Notification;
import com.siga.repository.DemandeRepository;
import com.siga.repository.HistoryRepository;
import com.siga.repository.MouvementTresorerieRepository;
import com.siga.repository.UserRepository;
import com.siga.security.SecurityUtils;
import com.siga.web.rest.util.DecisionUtilMouvement;
import com.siga.web.rest.util.UserTasksDemande;

@RestController
@RequestMapping("/api")
public class RestNotificationControlle {
    private final Logger log = LoggerFactory.getLogger(RestNotificationControlle.class);

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private DemandeRepository demandeRepository;

	@Autowired
	private TaskService taskService;
	
	@Autowired 
	private UserRepository userRepository;
	
	@Autowired
	private HistoryRepository historyRepository;
	
	@Autowired
	private MouvementTresorerieRepository mvtRepository;

	@RequestMapping(value = "/notifications", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean createNotification(@Valid @RequestBody Notification notification) throws URISyntaxException {

		try {
			Task task = taskService.createTaskQuery().taskId(notification.getTaskId()).singleResult();

			Demande demande = (Demande) runtimeService  .getVariables(task.getProcessInstanceId()).get("demande");

			demande = demandeRepository.findOne(notification.getId());

			Map<String, Object> taskVariables = new HashMap<String, Object>();
			String gateway = (String) DecisionUtilMouvement.getSteps(task.getName()).get("gateway");
			
		
			History history=new History();
			history.setDecideur(SecurityUtils.getCurrentUserLogin().get());
		   history.setDecision( notification.getDecision());
			history.setObservation(notification.getObservation());
			demande.setObservation(notification.getObservation());
			demande.setDecideur(notification.getDecideur());
			//demande.setStatut(notification.getStatus());
		  Date date=new Date();
		  history.setDateDesicion(date);
			history.setDemande(demande);
			historyRepository.save(history);
			//history.setDecideur(notification.getDecideur());
			//history.setStatut("1");
			
			if (gateway != null) {
				taskVariables.put(gateway, notification.getDecision().toLowerCase());
				 if ( notification.getDecision().toLowerCase().equals("signature") )
				 {
					MouvementTresorerie mvt= demande.getMouvement();
					mvt.setStatus(1);
					mvtRepository.save(mvt);
					
				 }
				taskService.complete(task.getId(), taskVariables);
				
				
				
				
				
			} else {
				taskService.complete(task.getId());
			}
			demande.setStatut(DecisionUtilMouvement.getStatus(demande.getDecision()).getId());
		
			demandeRepository.save(demande);
			return true;
		}
		catch (Exception e) {
			return false;
		}
	}

	@RequestMapping(value = "/notifications", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Notification> getAllNotifications() {
		List<Task> tasks = null;
		List<Notification> notifications = new ArrayList<Notification>();
		UserTasksDemande ut = new UserTasksDemande();

	
	
		tasks = ut.getAllTasks(taskService);
		log.info("tasks size {} ",tasks.size());
		if (!(tasks.isEmpty())) {
			for (Task task : tasks) {
				Demande demande = (Demande) runtimeService.getVariables(task.getProcessInstanceId()).get("demande");
				
				Notification notif = new Notification(demande.getIdDemande(), task.getId(), task.getName(), task.getProcessInstanceId(), demande.getDateCreation(),
						demande.getInitiateur(), demande.getDateSignature(), demande.getSingnataire(),demande.getDecision(),demande.getDecideur(),demande.getObservation(),demande.getMouvement(),demande.getStatut());
				notifications.add(notif);
			}
		}
		return notifications;
	}
	
	
	
	

	@RequestMapping(value = "/notifications/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Notification getNotification(@PathVariable String id) {
		Task task = taskService.createTaskQuery().taskId(id).singleResult();
		Demande demande = (Demande) runtimeService.getVariables(task.getProcessInstanceId()).get("demande");
	  
		 Notification notif = new Notification(
				 demande.getIdDemande(),
				 task.getId(), task.getName(),
				 task.getProcessInstanceId(),
				 demande.getDateCreation(),
				demande.getInitiateur(),
				demande.getDateSignature(),
				demande.getSingnataire(),
				demande.getDecision(),
				demande.getDecideur(),
				demande.getObservation(),
				demande.getMouvement(),
				demande.getStatut());
		return notif;
	}

}
