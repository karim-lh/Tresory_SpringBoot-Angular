package com.siga.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="Comptes_Bancaire_Tiers")
public class CompteBancaireTiers implements Serializable {

	/**
	 *  version 2.0.1 26/04/2017
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long idCompteBancaireTiers; 
    
	private double rib;
	private int coldeSwift;
	private int codeIban;
	@Temporal(TemporalType.DATE)
	private Date dateAjoute ;

	@ManyToOne
	@JoinColumn(name="nom_agence")
	private AgenceBancaire agenceBancaire;
	@ManyToOne
	@JoinColumn(name="cin_tiers")
    private Tiers tiers;
	public Long getIdCompteBancaireTiers() {
		return idCompteBancaireTiers;
	}
	public void setIdCompteBancaireTiers(Long idCompteBancaireTiers) {
		this.idCompteBancaireTiers = idCompteBancaireTiers;
	}
	public double getRib() {
		return rib;
	}
	public void setRib(double rib) {
		this.rib = rib;
	}
	public int getColdeSwift() {
		return coldeSwift;
	}
	public void setColdeSwift(int coldeSwift) {
		this.coldeSwift = coldeSwift;
	}
	public int getCodeIban() {
		return codeIban;
	}
	public void setCodeIban(int codeIban) {
		this.codeIban = codeIban;
	}
	public Date getDateAjoute() {
		return dateAjoute;
	}
	public void setDateAjoute(Date dateAjoute) {
		this.dateAjoute = dateAjoute;
	}
	public AgenceBancaire getAgenceBancaire() {
		return agenceBancaire;
	}
	public void setAgenceBancaire(AgenceBancaire agenceBancaire) {
		this.agenceBancaire = agenceBancaire;
	}
	public Tiers getTiers() {
		return tiers;
	}
	public void setTiers(Tiers tiers) {
		this.tiers = tiers;
	}
	public CompteBancaireTiers(Long idCompteBancaireTiers, double rib, int coldeSwift, int codeIban, Date dateAjoute,
			AgenceBancaire agenceBancaire) {
		super();
		this.idCompteBancaireTiers = idCompteBancaireTiers;
		this.rib = rib;
		this.coldeSwift = coldeSwift;
		this.codeIban = codeIban;
		this.dateAjoute = dateAjoute;
		this.agenceBancaire = agenceBancaire;
	}
	public CompteBancaireTiers() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
