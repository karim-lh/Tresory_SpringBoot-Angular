package com.siga.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="Employees")
public class Employe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	 @GeneratedValue
	private Long idEmployee;
	private String matricule;
	private String nom;
	private String prenom;
	private String sexe;
	private String statusCivil;
	private Date dateNaissance;
	private Date dateRecrutement;
   
	
	@ManyToOne
	@JoinColumn(name="nom_agence")
	private AgenceSociete agence;
	@OneToOne
	@JoinColumn(name="username")
	private User user;
	public Long getIdEmployee() {
		return idEmployee;
	}
	public void setIdEmployee(Long idEmployee) {
		this.idEmployee = idEmployee;
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
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}
	public String getStatusCivil() {
		return statusCivil;
	}
	public void setStatusCivil(String statusCivil) {
		this.statusCivil = statusCivil;
	}
	public Date getDateNaissance() {
		return dateNaissance;
	}
	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}
	public Date getDateRecrutement() {
		return dateRecrutement;
	}
	public void setDateRecrutement(Date dateRecrutement) {
		this.dateRecrutement = dateRecrutement;
	}
	public AgenceSociete getAgence() {
		return agence;
	}
	public void setAgence(AgenceSociete agence) {
		this.agence = agence;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Employe(Long idEmployee, String matricule, String nom, String prenom, String sexe, String statusCivil,
			Date dateNaissance, Date dateRecrutement, AgenceSociete agence, User user) {
		super();
		this.idEmployee = idEmployee;
		this.matricule = matricule;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.statusCivil = statusCivil;
		this.dateNaissance = dateNaissance;
		this.dateRecrutement = dateRecrutement;
		this.agence = agence;
		this.user = user;
	}
	

	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}



}
