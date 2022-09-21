package com.siga.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("PM")
public class PersonneMorale extends Tiers implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String libelle;
	private String matriculeFiscale;
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getMatriculeFiscale() {
		return matriculeFiscale;
	}

	public void setMatriculeFiscale(String matriculeFiscale) {
		this.matriculeFiscale = matriculeFiscale;
	}
	public PersonneMorale() {
	}
	public PersonneMorale(String libelle, String matriculeFiscale) {
		this.libelle = libelle;
		this.matriculeFiscale = matriculeFiscale;
	}
	
   
}
