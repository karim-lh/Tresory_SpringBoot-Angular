package com.siga.domain;


import java.util.Date;

public class Notification {

	private Long id;
	private String taskId;
	private String taskName;
	private String processInstanceId;

	private Date dateCreation;
	private String demandeur;
	private Date dateSignature;
	private String signataire;
	private String decision;
	private String decideur;
	private String status ;
	   public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	private String observation ;
	   
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	private MouvementTresorerie mouvement;
	public String getTaskId() {
		return taskId;
	}
	public void setTaskId(String taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getProcessInstanceId() {
		return processInstanceId;
	}
	public void setProcessInstanceId(String processInstanceId) {
		this.processInstanceId = processInstanceId;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDemandeur() {
		return demandeur;
	}
	public void setDemandeur(String demandeur) {
		this.demandeur = demandeur;
	}
	public Date getDateSignature() {
		return dateSignature;
	}
	public void setDateSignature(Date dateSignature) {
		this.dateSignature = dateSignature;
	}
	public String getSignataire() {
		return signataire;
	}
	public void setSignataire(String signataire) {
		this.signataire = signataire;
	}
	public String getDecision() {
		return decision;
	}
	public void setDecision(String decision) {
		this.decision = decision;
	}
	public String getDecideur() {
		return decideur;
	}
	public void setDecideur(String decideur) {
		this.decideur = decideur;
	}
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MouvementTresorerie getMouvement() {
		return mouvement;
	}
	public void setMouvement(MouvementTresorerie mouvement) {
		this.mouvement = mouvement;
	}
	public Notification(Long id, String taskId, String taskName, String processInstanceId, Date dateCreation,
			String demandeur, Date dateSignature, String signataire, String decision, String decideur,
			String observation, MouvementTresorerie mouvement,String status) {
		super();
		this.id = id;
		this.taskId = taskId;
		this.taskName = taskName;
		this.processInstanceId = processInstanceId;
		this.dateCreation = dateCreation;
		this.demandeur = demandeur;
		this.dateSignature = dateSignature;
		this.signataire = signataire;
		this.decision = decision;
		this.decideur = decideur;
		this.observation = observation;
		this.mouvement = mouvement;
		this.status=status;
	}
	
	
   
    
}
