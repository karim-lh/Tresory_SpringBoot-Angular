package com.siga.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="demandes_hisotory")
public class History implements Serializable {

	@Id
	@GeneratedValue
	private Long id;
	
	private String decision;
	private String observation;
	@Temporal(TemporalType.DATE)
	private Date dateDesicion;
	private String decideur;
	private String statut;
	
	@ManyToOne
	@JoinColumn(name="idDemande")
	private Demande demande;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public Date getDateDesicion() {
		return dateDesicion;
	}

	public void setDateDesicion(Date dateDesicion) {
		this.dateDesicion = dateDesicion;
	}

	public String getDecideur() {
		return decideur;
	}

	public void setDecideur(String decideur) {
		this.decideur = decideur;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Demande getDemande() {
		return demande;
	}

	public void setDemande(Demande demande) {
		this.demande = demande;
	}

	public History() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
