package com.siga.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "mouvements")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE) 
@DiscriminatorColumn(name="sens_Mouvement")
@DiscriminatorValue("mouvement")
public class MouvementTresorerie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long idMouvement;
	@Column(name="num_mouvement")
	private String numMouvement;
	@Temporal(TemporalType.DATE)
	private Date dateMouvement;
	private float sold;
	private float montantDevise;
	private float tauxChangeMouvement;
	private String objetMouvement;
	private String libelleMouvement ;
	private String typeMouvement;
	private float montantHT;
	private float montantTaxe;
	private float montantDeviseLocal;
	private String demandeur;
	
	
	
	public String getDemandeur() {
		return demandeur;
	}
	public void setDemandeur(String Demandeur) {
		this.demandeur = Demandeur;
	}
	public float getMontantDeviseLocal() {
		return montantDeviseLocal;
	}

	public void setMontantDeviseLocal(float montantDeviseLocal) {
		this.montantDeviseLocal = montantDeviseLocal;
	}

	public float getMontantDevise() {
		return montantDevise;
	}

	public void setMontantDevise(float montantDevise) {
		this.montantDevise = montantDevise;
	}

	public float getSold() {
		return sold;
	}

	public void setSold(float sold) {
		this.sold = sold;
	}

	public float getMontantHT() {
		return montantHT;
	}

	public void setMontantHT(float montantHT) {
		this.montantHT = montantHT;
	}

	public float getMontantTaxe() {
		return montantTaxe;
	}

	public void setMontantTaxe(float montantTaxe) {
		this.montantTaxe = montantTaxe;
	}

//private String sensMouvement;
  private int status;
  


	public String getTypeMouvement() {
		return typeMouvement;
	}

	public void setTypeMouvement(String typeMouvement) {
		this.typeMouvement = typeMouvement;
	}

/*
	 *
	 * les relations avec les autres tables
	 */
   @ManyToOne
   @JoinColumn(name="idCompteTresorerie")
   private CompteTresorerie compteTresorerie;
   

   @ManyToOne
   @JoinColumn(name="nom_devise")
   private Devise devise;
   
   @ManyToOne
   @JoinColumn(name="code_flux_tresorerie")
   private FluxTresorerie fluxTresorerie;
   
   @OneToOne(mappedBy="mouvementTresorerie",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	 @JsonIgnore
   @JoinColumn(name="code_lettrage")
   private Lettrage lettrage;
   
   @ManyToOne
   @JoinColumn(name="cin_tiers")
   private Tiers tiers;
   
   @ManyToOne
   @JoinColumn(name="username")
   private User user;
   
	@OneToMany(mappedBy="mouvementTresorerie",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	 @JsonIgnore
	private List<PieceJointe> piecesJointes;
	
	@OneToMany(mappedBy="mouvementTresorerie",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	 @JsonIgnore
	private List<PiecePaiementMvt> piecesPaiementMvt;

	
	@OneToMany(mappedBy="mouvement" ,cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Demande> demandes;
	
	
	
	
	public List<Demande> getDemandes() {
		return demandes;
	}

	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}

	public Long getIdMouvement() {
		return idMouvement;
	}

	public void setIdMouvement(Long idMouvement) {
		this.idMouvement = idMouvement;
	}

	public String getNumMouvement() {
		return numMouvement;
	}

	public void setNumMouvement(String num) {
		this.numMouvement = num;
	}

	public Date getDateMouvement() {
		return dateMouvement;
	}

	public void setDateMouvement(Date dateMouvement) {
		this.dateMouvement = dateMouvement;
	}


	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public float getTauxChangeMouvement() {
		return tauxChangeMouvement;
	}

	public void setTauxChangeMouvement(float tauxChangeMouvement) {
		this.tauxChangeMouvement = tauxChangeMouvement;
	}

	public String getObjetMouvement() {
		return objetMouvement;
	}

	public void setObjetMouvement(String objetMouvement) {
		this.objetMouvement = objetMouvement;
	}

//	public String getSensMouvement() {
//		return sensMouvement;
//	}
//
//	public void setSensMouvement(String sensMouvement) {
//		this.sensMouvement = sensMouvement;
//	}

	public CompteTresorerie getCompteTresorerie() {
		return compteTresorerie;
	}

	public void setCompteTresorerie(CompteTresorerie compteTresorerie) {
		this.compteTresorerie = compteTresorerie;
	}


public String getSens_Mouvement ()
{
	 return this.getClass().getName()=="com.bns.domain.Depense" ?"Depense" :"Recette"  ;
}
	public Devise getDevise() {
		return devise;
	}

	public void setDevise(Devise devise) {
		this.devise = devise;
	}

	public FluxTresorerie getFluxTresorerie() {
		return fluxTresorerie;
	}

	public void setFluxTresorerie(FluxTresorerie fluxTresorerie) {
		this.fluxTresorerie = fluxTresorerie;
	}

	public Lettrage getLettrage() {
		return lettrage;
	}

	public void setLettrage(Lettrage lettrage) {
		this.lettrage = lettrage;
	}

	public Tiers getTiers() {
		return tiers;
	}

	public void setTiers(Tiers tiers) {
		this.tiers = tiers;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<PieceJointe> getPiecesJointes() {
		return piecesJointes;
	}

	public void setPiecesJointes(List<PieceJointe> piecesJointes) {
		this.piecesJointes = piecesJointes;
	}

	public List<PiecePaiementMvt> getPiecesPaiementMvt() {
		return piecesPaiementMvt;
	}

	public void setPiecesPaiementMvt(List<PiecePaiementMvt> piecesPaiementMvt) {
		this.piecesPaiementMvt = piecesPaiementMvt;
	}

	

	public MouvementTresorerie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getLibelleMouvement() {
		return libelleMouvement;
	}

	public void setLibelleMouvement(String libelleMouvement) {
		this.libelleMouvement = libelleMouvement;
	}

	
	
	
}
