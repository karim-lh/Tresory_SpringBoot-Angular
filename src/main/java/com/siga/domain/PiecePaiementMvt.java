package com.siga.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="Pieces_de_paiement")
public class PiecePaiementMvt implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long idPieceMvt; 
	@Column(name="code_piece")
	private String codePiece;
	@Temporal(TemporalType.DATE)
	private Date dateCreationPieceMVt ;
	@Temporal(TemporalType.DATE)
	private Date dateSignaturePieceMVt ;
	@Temporal(TemporalType.DATE)
	private Date dateLivraisonPieceMVt ;	

	private String emeteurMouvementPieceMVt ;
	private String EcheancePiecePieceMVt;
	
	private String status;
	
	private float montantDevise;
	private float tauxChange;
	private float montantdeviseLocal;
	
	@ManyToOne
	
	private Tiers benificaire;
	@ManyToOne
	@JoinColumn(name="mode_paiement")
	private ModePaiement modePaiement;
	
	@ManyToOne
	@JoinColumn(name="num_mouvement")
	private MouvementTresorerie mouvementTresorerie;
	
	@OneToOne
	@JoinColumn(name="serie_chequier")
	private SerieChequier serieChequier;

	@ManyToOne
	private Devise devise;
	
	
	
	
	
	public float getMontantDevise() {
		return montantDevise;
	}

	public void setMontantDevise(float montantDevise) {
		this.montantDevise = montantDevise;
	}

	public float getTauxChange() {
		return tauxChange;
	}

	public void setTauxChange(float tauxChange) {
		this.tauxChange = tauxChange;
	}

	

	public float getMontantdeviseLocal() {
		return montantdeviseLocal;
	}

	public void setMontantdeviseLocal(float montantdeviseLocal) {
		this.montantdeviseLocal = montantdeviseLocal;
	}

	public Long getIdPieceMvt() {
		return idPieceMvt;
	}

	public void setIdPieceMvt(Long idPieceMvt) {
		this.idPieceMvt = idPieceMvt;
	}

	public String getCodePiece() {
		return codePiece;
	}

	public void setCodePiece(String codePiece) {
		this.codePiece = codePiece;
	}

	public Date getDateCreationPieceMVt() {
		return dateCreationPieceMVt;
	}

	public void setDateCreationPieceMVt(Date dateCreationPieceMVt) {
		this.dateCreationPieceMVt = dateCreationPieceMVt;
	}
	
	

	public Date getDateSignaturePieceMVt() {
		return dateSignaturePieceMVt;
	}

	public void setDateSignaturePieceMVt(Date dateSignaturePieceMVt) {
		this.dateSignaturePieceMVt = dateSignaturePieceMVt;
	}

	public Date getDateLivraisonPieceMVt() {
		return dateLivraisonPieceMVt;
	}

	public void setDateLivraisonPieceMVt(Date dateLivraisonPieceMVt) {
		this.dateLivraisonPieceMVt = dateLivraisonPieceMVt;
	}

	

	public String getEmeteurMouvementPieceMVt() {
		return emeteurMouvementPieceMVt;
	}

	public void setEmeteurMouvementPieceMVt(String emeteurMouvementPieceMVt) {
		this.emeteurMouvementPieceMVt = emeteurMouvementPieceMVt;
	}

	public String getEcheancePiecePieceMVt() {
		return EcheancePiecePieceMVt;
	}

	public void setEcheancePiecePieceMVt(String echeancePiecePieceMVt) {
		EcheancePiecePieceMVt = echeancePiecePieceMVt;
	}

	public Tiers getBenificaire() {
		return benificaire;
	}

	public void setBenificaire(Tiers benificaire) {
		this.benificaire = benificaire;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ModePaiement getModePaiement() {
		return modePaiement;
	}

	public void setModePaiement(ModePaiement modePaiement) {
		this.modePaiement = modePaiement;
	}

	public MouvementTresorerie getMouvementTresorerie() {
		return mouvementTresorerie;
	}

	public void setMouvementTresorerie(MouvementTresorerie mouvementTresorerie) {
		this.mouvementTresorerie = mouvementTresorerie;
	}

	public SerieChequier getSerieChequier() {
		return serieChequier;
	}

	public void setSerieChequier(SerieChequier serieChequier) {
		this.serieChequier = serieChequier;
	}


	



	
	
	public Devise getDevise() {
		return devise;
	}

	public void setDevise(Devise devise) {
		this.devise = devise;
	}

	public PiecePaiementMvt() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
