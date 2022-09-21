package com.siga.web.rest.util;

import java.util.ArrayList;
import java.util.List;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.siga.security.SecurityUtils;
import com.siga.web.rest.RestNotificationControlle;


public class UserTasksDemande {
	
	
    private final Logger log = LoggerFactory.getLogger(UserTasksDemande.class);

	public List<Task> getAllTasks(TaskService taskService) {
		List<Task> AllTasks = new ArrayList<Task>();
		List<Task> task1 = tasksStage(taskService);
		try {
			if (task1 != null) {
				AllTasks.addAll(task1);
			}
		} catch (Exception e) {
			e.getMessage();
		}
		return AllTasks;
	}
	public List<Task> tasksStage(TaskService taskService) {
		String processId="demandeTresorerieV13";
		List<Task> tasks =  new ArrayList<Task>();
		String P1="AGENT";
		String P2="CHEF_SERV_TRES";
		String P3="DIRECTEUR_FINAN";
		List<Task> AllTasks1 = new ArrayList<Task>();
		List<Task> AllTasks2 = new ArrayList<Task>();
		List<Task> AllTasks3 = new ArrayList<Task>();
		if (SecurityUtils.isCurrentUserInRole(P1)) {
			log.info("user is agent");
			if (taskService.createTaskQuery().taskCandidateGroup(P1)!=null && taskService.createTaskQuery().taskCandidateGroup(P1).processDefinitionKey(processId).list()!=null)
			AllTasks1= taskService.createTaskQuery().taskCandidateGroup(P1).processDefinitionKey(processId).list();
			if (AllTasks1!=null)
			{
				tasks.addAll(AllTasks1);
			log.info("tasks size {} ",AllTasks1.size());
			}
			else
			{
				log.info("tasks1 is null");
			}
			
		}
		 if (SecurityUtils.isCurrentUserInRole(P2)) {
			log.info("user is CHEF_SERV_TRES");
			if (taskService.createTaskQuery().taskCandidateGroup(P2)!=null && taskService.createTaskQuery().taskCandidateGroup(P2).processDefinitionKey(processId).list()!=null)
				AllTasks2= taskService.createTaskQuery().taskCandidateGroup(P2).processDefinitionKey(processId).list();
			if (AllTasks2!=null)
			{
				tasks.addAll(AllTasks2);
			log.info("tasks size {} ",AllTasks2.size());
			}
			else
			{
				log.info("tasks1 is null");
			}
		}
		
			if (SecurityUtils.isCurrentUserInRole(P3)) {
				log.info("user is CHEF_SERV_TRES");
				if (taskService.createTaskQuery().taskCandidateGroup(P3)!=null && taskService.createTaskQuery().taskCandidateGroup(P3).processDefinitionKey(processId).list()!=null)
					AllTasks3= taskService.createTaskQuery().taskCandidateGroup(P3).processDefinitionKey(processId).list();
				if (AllTasks3!=null)
				{
					tasks.addAll(AllTasks3);
				log.info("tasks size {} ",AllTasks3.size());
				}
				else
				{
					log.info("AllTasks3 is null");
				}
			}
		return tasks;
	}
}
