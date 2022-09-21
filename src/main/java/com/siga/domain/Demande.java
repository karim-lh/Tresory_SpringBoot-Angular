package com.siga.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "demandes_tresoreries")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
@DiscriminatorValue("abstract")
public class Demande implements Serializable {

	@Id
	@GeneratedValue
	private Long idDemande;

	@Temporal(TemporalType.DATE)
	private Date dateCreation;

	@Temporal(TemporalType.DATE)
	private Date dateSignature;

	@ManyToOne
	private TypeDemande typeDemande;
	
	private String initiateur;

	private String singnataire;

	private String statut;

	private String decision;
	private String decideur;
	private String observation;

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getDecideur() {
		return decideur;
	}

	public void setDecideur(String decideur) {
		this.decideur = decideur;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

	@OneToMany(mappedBy = "demande", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JsonIgnore
	private List<History> histories;

	@ManyToOne
	private MouvementTresorerie mouvement;

	public Long getIdDemande() {
		return idDemande;
	}

	public void setIdDemande(Long idDemande) {
		this.idDemande = idDemande;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public MouvementTresorerie getMouvement() {
		return mouvement;
	}

	public void setMouvement(MouvementTresorerie mouvement) {
		this.mouvement = mouvement;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateSignature() {
		return dateSignature;
	}

	public void setDateSignature(Date dateSignature) {
		this.dateSignature = dateSignature;
	}

	public TypeDemande getTypeDemande() {
		return typeDemande;
	}

	public void setTypeDemande(TypeDemande typeDemande) {
		this.typeDemande = typeDemande;
	}

	public String getInitiateur() {
		return initiateur;
	}

	public void setInitiateur(String initiateur) {
		this.initiateur = initiateur;
	}

	public String getSingnataire() {
		return singnataire;
	}

	public void setSingnataire(String singnataire) {
		this.singnataire = singnataire;
	}

	public List<History> getHistories() {
		return histories;
	}

	public void setHistories(List<History> histories) {
		this.histories = histories;
	}

	public Demande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
	
	public void addHistory(History history)
	{
		this.histories.add(history);
	}

	public Demande(Long idDemande, Date dateCreation, Date dateSignature, TypeDemande typeDemande, String initiateur,
			String singnataire, String statut, String decision, String decideur, String observation,
			MouvementTresorerie mouvement) {
		super();
		this.idDemande = idDemande;
		this.dateCreation = dateCreation;
		this.dateSignature = dateSignature;
		this.typeDemande = typeDemande;
		this.initiateur = initiateur;
		this.singnataire = singnataire;
		this.statut = statut;
		this.decision = decision;
		this.decideur = decideur;
		this.observation = observation;
		this.mouvement = mouvement;
	}

}
