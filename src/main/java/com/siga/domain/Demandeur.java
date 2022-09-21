package com.siga.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="demandeurs")
public class Demandeur implements Serializable {

	/**
	 *  version 2.0.1 26/04/2017
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long idDemandeur;
	@Column(name="cin_demandeur")
	private String cinDemandeur;
	private String matricule;
	private String nom;
	private String Prenom ;
	@Temporal(TemporalType.DATE)
	private Date dateAjoute ;
	
	
	public Long getIdDemandeur() {
		return idDemandeur;
	}

	public void setIdDemandeur(Long idDemandeur) {
		this.idDemandeur = idDemandeur;
	}

	public String getCinDemandeur() {
		return cinDemandeur;
	}

	public void setCinDemandeur(String cinDemandeur) {
		this.cinDemandeur = cinDemandeur;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return Prenom;
	}

	public void setPrenom(String prenom) {
		Prenom = prenom;
	}

	public Date getDateAjoute() {
		return dateAjoute;
	}

	public void setDateAjoute(Date dateAjoute) {
		this.dateAjoute = dateAjoute;
	}



	public Demandeur(Long idDemandeur, String cinDemandeur, String matricule, String nom, String prenom,
			Date dateAjoute) {
		super();
		this.idDemandeur = idDemandeur;
		this.cinDemandeur = cinDemandeur;
		this.matricule = matricule;
		this.nom = nom;
		Prenom = prenom;
		this.dateAjoute = dateAjoute;
	}

	public Demandeur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
