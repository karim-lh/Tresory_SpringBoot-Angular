package com.siga.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("PP")
public class PersonnePhysique extends Tiers implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nomPersonne;
	private String prenomPersonne;
	private String sexe ;
	private String emailPersonne;
	private double cinTiers;
	public String getNomPersonne() {
		return nomPersonne;
	}
	public void setNomPersonne(String nomPersonne) {
		this.nomPersonne = nomPersonne;
	}
	public String getPrenomPersonne() {
		return prenomPersonne;
	}
	public void setPrenomPersonne(String prenomPersonne) {
		this.prenomPersonne = prenomPersonne;
	}
	public String getEmailPersonne() {
		return emailPersonne;
	}
	public void setEmailPersonne(String emailPersonne) {
		this.emailPersonne = emailPersonne;
	}
	public double getCinTiers() {
		return cinTiers;
	}
	public void setCinTiers(double cinTiers) {
		this.cinTiers = cinTiers;
	}
	public PersonnePhysique(Long idTiers, Date dateAjoute, String nomPersonne, String prenomPersonne,
			String emailPersonne, double cinTiers) {
		super(idTiers, dateAjoute);
		this.nomPersonne = nomPersonne;
		this.prenomPersonne = prenomPersonne;
		this.emailPersonne = emailPersonne;
		this.cinTiers = cinTiers;
	}
	public PersonnePhysique() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PersonnePhysique(Long idTiers, Date dateAjoute, String numTel) {
		super(idTiers, dateAjoute, numTel);
		// TODO Auto-generated constructor stub
	}
	public PersonnePhysique(Long idTiers, Date dateAjoute) {
		super(idTiers, dateAjoute);
		// TODO Auto-generated constructor stub
	}
	public PersonnePhysique(Long idTiers, Date dateAjoute, String numTel, String typeTiers, String nomPersonne,
			String prenomPersonne, String sexe, String emailPersonne, double cinTiers) {
		super(idTiers, dateAjoute, numTel);
		this.nomPersonne = nomPersonne;
		this.prenomPersonne = prenomPersonne;
		this.sexe = sexe;
		this.emailPersonne = emailPersonne;
		this.cinTiers = cinTiers;
	}
	public String getSexe() {
		return sexe;
	}
	public void setSexe(String sexe) {
		this.sexe = sexe;
	}


	

}
