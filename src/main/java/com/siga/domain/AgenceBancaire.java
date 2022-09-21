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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
//@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
@Table(name="agences_bancaire")
public class AgenceBancaire implements Serializable {

	/**
	 * Version 2.01 26/04/2017
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(nullable=false,unique=true,name="id_agence")
	private Long idAgence;
	
	private String codeAgence;
	public String getCodeAgence() {
		return codeAgence;
	}

	public void setCodeAgence(String codeAgence) {
		this.codeAgence = codeAgence;
	}

	@Column(nullable=false,unique=true,name="nom_agence")
	private String libelleAgenceBancaire;
	@Column(nullable=false,unique=true)
	private String numTel;
	@Column(nullable=false,unique=true)
	private String emailContact;
	@Temporal(TemporalType.DATE)
	private Date dateAjoute ;
	
	
	//liste des attribues des relations avec les autres entity 

	public AgenceBancaire(Long idAgence, String libelleAgenceBancaire, String numTel, String emailContact,
			Date dateAjoute, Banque siege) {
		super();
		this.idAgence = idAgence;
		this.libelleAgenceBancaire = libelleAgenceBancaire;
		this.numTel = numTel;
		this.emailContact = emailContact;
		this.dateAjoute = dateAjoute;
		this.siege = siege;
	}

	public Date getDateAjoute() {
		return dateAjoute;
	}

	public void setDateAjoute(Date dateAjoute) {
		this.dateAjoute = dateAjoute;
	}

	@OneToMany(mappedBy="agenceBancaire",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	 @JsonIgnore
	private List<CompteTresorerie> comptesDeTresorerie;
	@OneToMany(mappedBy="agenceBancaire",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	 @JsonIgnore
	private List<SerieChequier> seriesChequier;
	@OneToMany (mappedBy="agenceBancaire",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	 @JsonIgnore
	private List<CompteBancaireTiers> comptesTiers;
	
	@ManyToOne
	@JoinColumn(name="nom_siege",referencedColumnName = "id_Banque")
	private Banque siege;

	public Long getIdAgence() {
		return idAgence;
	}

	public void setIdAgence(Long idAgence) {
		this.idAgence = idAgence;
	}

	public String getLibelleAgenceBancaire() {
		return libelleAgenceBancaire;
	}

	public void setLibelleAgenceBancaire(String libelleAgenceBancaire) {
		this.libelleAgenceBancaire = libelleAgenceBancaire;
	}

	public String getNumTel() {
		return numTel;
	}

	public void setNumTel(String numTel) {
		this.numTel = numTel;
	}

	public String getEmailContact() {
		return emailContact;
	}

	public void setEmailContact(String emailContact) {
		this.emailContact = emailContact;
	}

	public List<CompteTresorerie> getComptesDeTresorerie() {
		return comptesDeTresorerie;
	}

	public void setComptesDeTresorerie(List<CompteTresorerie> comptesDeTresorerie) {
		this.comptesDeTresorerie = comptesDeTresorerie;
	}

	public List<SerieChequier> getSeriesChequier() {
		return seriesChequier;
	}

	public void setSeriesChequier(List<SerieChequier> seriesChequier) {
		this.seriesChequier = seriesChequier;
	}

	public List<CompteBancaireTiers> getComptesTiers() {
		return comptesTiers;
	}

	public void setComptesTiers(List<CompteBancaireTiers> comptesTiers) {
		this.comptesTiers = comptesTiers;
	}

	public Banque getSiege() {
		return siege;
	}

	public void setSiege(Banque siege) {
		this.siege = siege;
	}

	public AgenceBancaire(Long idAgence, String libelleAgenceBancaire, String numTel, String emailContact,
			Banque siege) {
		super();
		this.idAgence = idAgence;
		this.libelleAgenceBancaire = libelleAgenceBancaire;
		this.numTel = numTel;
		this.emailContact = emailContact;
		this.siege = siege;
	}

	
	public AgenceBancaire(Long idAgence, String libelleAgenceBancaire, String numTel, String emailContact) {
		super();
		this.idAgence = idAgence;
		this.libelleAgenceBancaire = libelleAgenceBancaire;
		this.numTel = numTel;
		this.emailContact = emailContact;
	}

	public AgenceBancaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * 
	 * les setter et les getter
	 */
	
	
}
