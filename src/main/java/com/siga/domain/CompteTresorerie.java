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
@Table(name="comptes_des_Tresorerie")
public class CompteTresorerie implements Serializable {

	/**
	 * version 2.0.1 26/04/2017
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="idCompteTresorerie")
	private Long idCompteTresorerie ;
	private String libelle ;
	public CompteTresorerie(Long idCompteTresorerie, String libelle, String rib, String status, String responsable,
			String adresse, Date dateOouverture, Date dateFermeture, float sold, AgenceBancaire agenceBancaire,
			CompteComptable compteComptable, FamilleCompte familleCompte, Journal journal) {
		super();
		this.idCompteTresorerie = idCompteTresorerie;
		this.libelle = libelle;
		this.rib = rib;
		this.status = status;
		this.responsable = responsable;
		this.adresse = adresse;
		this.dateOouverture = dateOouverture;
		this.dateFermeture = dateFermeture;
		this.sold = sold;
		this.agenceBancaire = agenceBancaire;
		this.compteComptable = compteComptable;
		this.familleCompte = familleCompte;
		this.journal = journal;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	
	
	private String rib;
	private String status;
	private String responsable;
	private String adresse ;
	@Temporal(TemporalType.DATE)
	private Date dateOouverture ;
	@Temporal(TemporalType.DATE)
	private Date dateFermeture ;
	private float sold ;
	
	/*
	 * les relation avec les tables
    *
    *
    */
	
	
	public float getSold() {
		return sold;
	}

	public void setSold(float sold) {
		this.sold = sold;
	}

	public String getResponsable() {
		return responsable;
	}

	public void setResponsable(String responsable) {
		this.responsable = responsable;
	}
	@ManyToOne
	@JoinColumn(name="nom_agence")
	private AgenceBancaire agenceBancaire;
	
	@ManyToOne
	@JoinColumn(name="code_compte_comptable")
	private CompteComptable compteComptable;

	
	@ManyToOne
	@JoinColumn(name="nom_famille")
	private FamilleCompte familleCompte ;
	
	@ManyToOne
	private Journal journal ;
	
	
	@OneToMany (mappedBy="compteTresorerie",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	 @JsonIgnore
	private List<MouvementTresorerie> mouvements ;
	
	
	public Long getIdCompteTresorerie() {
		return idCompteTresorerie;
	}

	public void setIdCompteTresorerie(Long idCompteTresorerie) {
		this.idCompteTresorerie = idCompteTresorerie;
	}


	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDateOouverture() {
		return dateOouverture;
	}

	public void setDateOouverture(Date dateOouverture) {
		this.dateOouverture = dateOouverture;
	}

	public Date getDateFermeture() {
		return dateFermeture;
	}

	public void setDateFermeture(Date dateFermeture) {
		this.dateFermeture = dateFermeture;
	}

	public AgenceBancaire getAgenceBancaire() {
		return agenceBancaire;
	}

	public void setAgenceBancaire(AgenceBancaire agenceBancaire) {
		this.agenceBancaire = agenceBancaire;
	}

	public CompteComptable getCompteComptable() {
		return compteComptable;
	}

	public void setCompteComptable(CompteComptable compteComptable) {
		this.compteComptable = compteComptable;
	}

	public FamilleCompte getFamilleCompte() {
		return familleCompte;
	}

	public void setFamilleCompte(FamilleCompte familleCompte) {
		this.familleCompte = familleCompte;
	}

	public List<MouvementTresorerie> getMouvements() {
		return mouvements;
	}

	public void setMouvements(List<MouvementTresorerie> mouvements) {
		this.mouvements = mouvements;
	}

	

	public Journal getJournal() {
		return journal;
	}

	public void setJournal(Journal journal) {
		this.journal = journal;
	}

	public CompteTresorerie(Long idCompteTresorerie, String rib, String codeIban, String codeSwift, String status,
			Date dateOouverture, Date dateFermeture, AgenceBancaire agenceBancaire, CompteComptable compteComptable,
			FamilleCompte familleCompte) {
		super();
		this.idCompteTresorerie = idCompteTresorerie;
		this.rib = rib;
	
		this.status = status;
		this.dateOouverture = dateOouverture;
		this.dateFermeture = dateFermeture;
		this.agenceBancaire = agenceBancaire;
		this.compteComptable = compteComptable;
		this.familleCompte = familleCompte;
	}

	public CompteTresorerie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public CompteTresorerie(Long idCompteTresorerie, String rib, String codeIban, String codeSwift, String status,
			String responsable, String adresse, Date dateOouverture, Date dateFermeture, AgenceBancaire agenceBancaire,
			FamilleCompte familleCompte) {
		super();
		this.idCompteTresorerie = idCompteTresorerie;
		this.rib = rib;
		
		this.status = status;
		this.responsable = responsable;
		this.adresse = adresse;
		this.dateOouverture = dateOouverture;
		this.dateFermeture = dateFermeture;
		this.agenceBancaire = agenceBancaire;
		this.familleCompte = familleCompte;
	}

	public String getRib() {
		return rib;
	}

	public void setRib(String rib) {
		this.rib = rib;
	}

	
	
	public CompteTresorerie(Long idCompteTresorerie, String rib, String codeIban, String codeSwift, String status,
			String responsable, String adresse, Date dateOouverture, Date dateFermeture, float sold,
			AgenceBancaire agenceBancaire, CompteComptable compteComptable, FamilleCompte familleCompte,
			Journal journal) {
		super();
		this.idCompteTresorerie = idCompteTresorerie;
		this.rib = rib;
	
		this.status = status;
		this.responsable = responsable;
		this.adresse = adresse;
		this.dateOouverture = dateOouverture;
		this.dateFermeture = dateFermeture;
		this.sold = sold;
		this.agenceBancaire = agenceBancaire;
		this.compteComptable = compteComptable;
		this.familleCompte = familleCompte;
		this.journal = journal;
	}

	public CompteTresorerie(Long idCompteTresorerie, String rib, String codeIban, String codeSwift, String status,
			String responsable, String adresse, Date dateOouverture, Date dateFermeture, AgenceBancaire agenceBancaire,
			CompteComptable compteComptable, FamilleCompte familleCompte, Journal journal) {
		super();
		this.idCompteTresorerie = idCompteTresorerie;
		this.rib = rib;
	
		this.status = status;
		this.responsable = responsable;
		this.adresse = adresse;
		this.dateOouverture = dateOouverture;
		this.dateFermeture = dateFermeture;
		this.agenceBancaire = agenceBancaire;
		this.compteComptable = compteComptable;
		this.familleCompte = familleCompte;
		this.journal = journal;
	}

	
	
	
}
