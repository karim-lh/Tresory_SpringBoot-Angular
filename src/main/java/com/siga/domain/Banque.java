package com.siga.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

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
@Table(name="Banques")
public class Banque implements Serializable {

	/**
	 *  version 2.0.1 26/04/2017
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
    @Column(name="id_Banque",nullable=false,unique=true)
	private Long IdBanque;
	
	@Column(unique=true,name="nom_siege")
	private String nomBanque;
	private String codeBanque ;
	@Column(unique=true)
	private String numTel;
	@Column(unique=true)
	private String adresse;
	private String refIBan ;
	private String codeSwift ;
	@Column(unique=true)
	private String contactEmail ;
	@Temporal(TemporalType.DATE)
	private Date dateAjoute ;

 @OneToMany (mappedBy="siege",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
 @JsonIgnore
 private Set<AgenceBancaire> agences =new HashSet<AgenceBancaire>() ;

public Long getIdBanque() {
	return IdBanque;
}

public void setIdBanque(Long idBanque) {
	IdBanque = idBanque;
}

public String getNomBanque() {
	return nomBanque;
}

public void setNomBanque(String nomBanque) {
	this.nomBanque = nomBanque;
}

public String getNumTel() {
	return numTel;
}



public String getRefIBan() {
	return refIBan;
}

public void setRefIBan(String refIBan) {
	this.refIBan = refIBan;
}

public String getCodeSwift() {
	return codeSwift;
}

public void setCodeSwift(String codeSwift) {
	this.codeSwift = codeSwift;
}

public void setNumTel(String numTel) {
	this.numTel = numTel;
}

public String getAdresse() {
	return adresse;
}

public void setAdresse(String adresse) {
	this.adresse = adresse;
}

public String getContactEmail() {
	return contactEmail;
}

public void setContactEmail(String contactEmail) {
	this.contactEmail = contactEmail;
}

public Date getDateAjoute() {
	return dateAjoute;
}

public void setDateAjoute(Date dateAjoute) {
	this.dateAjoute = dateAjoute;
}

public Set<AgenceBancaire> getAgences() {
	return agences;
}

public void setAgences(Set<AgenceBancaire> agences) {
	this.agences = agences;
}

public Banque(Long idBanque, String nomBanque, String numTel, String adresse, String contactEmail, Date dateAjoute) {
	super();
	IdBanque = idBanque;
	this.nomBanque = nomBanque;
	this.numTel = numTel;
	this.adresse = adresse;
	this.contactEmail = contactEmail;
	this.dateAjoute = dateAjoute;
}



public String getCodeBanque() {
	return codeBanque;
}

public void setCodeBanque(String codeBanque) {
	this.codeBanque = codeBanque;
}

public Banque() {
	super();
	// TODO Auto-generated constructor stub
}

public void add(AgenceBancaire agenceBancaire) {
	// TODO Auto-generated method stub
	agences.add(agenceBancaire);
}

public Banque(Long idBanque, String nomBanque, String codeBanque, String numTel, String adresse, String contactEmail,
		Date dateAjoute) {
	super();
	IdBanque = idBanque;
	this.nomBanque = nomBanque;
	this.codeBanque = codeBanque;
	this.numTel = numTel;
	this.adresse = adresse;
	this.contactEmail = contactEmail;
	this.dateAjoute = dateAjoute;
}
 
 
}
