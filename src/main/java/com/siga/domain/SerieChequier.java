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
@Entity
@Table(name="serie_Chequier")
public class SerieChequier implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long idSerieChequier;
	@Column(name="serie_chequier")
	private String codeSerieChequier;
	private long numCarnet;
	private String rib;
	private float montant;
	private String benificiare;
	private String dateSignature;
	private Date dateLivraison;
	private String status;
	
	@ManyToOne
	@JoinColumn(name="nom_agence")
	private AgenceBancaire agenceBancaire;
	@OneToOne
	@JoinColumn(name="Piece_paiement")
	private PiecePaiementMvt piecePaiementMvt;
	public Long getIdSerieChequier() {
		return idSerieChequier;
	}
	public void setIdSerieChequier(Long idSerieChequier) {
		this.idSerieChequier = idSerieChequier;
	}
	public String getCodeSerieChequier() {
		return codeSerieChequier;
	}
	public void setCodeSerieChequier(String codeSerieChequier) {
		this.codeSerieChequier = codeSerieChequier;
	}
	public long getNumCarnet() {
		return numCarnet;
	}
	public void setNumCarnet(long numCarnet) {
		this.numCarnet = numCarnet;
	}
	public String getRib() {
		return rib;
	}
	public void setRib(String rib) {
		this.rib = rib;
	}
	public float getMontant() {
		return montant;
	}
	public void setMontant(float montant) {
		this.montant = montant;
	}
	public String getBenificiare() {
		return benificiare;
	}
	public void setBenificiare(String benificiare) {
		this.benificiare = benificiare;
	}
	public String getDateSignature() {
		return dateSignature;
	}
	public void setDateSignature(String dateSignature) {
		this.dateSignature = dateSignature;
	}
	public Date getDateLivraison() {
		return dateLivraison;
	}
	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public AgenceBancaire getAgenceBancaire() {
		return agenceBancaire;
	}
	public void setAgenceBancaire(AgenceBancaire agenceBancaire) {
		this.agenceBancaire = agenceBancaire;
	}
	public PiecePaiementMvt getPiecePaiementMvt() {
		return piecePaiementMvt;
	}
	public void setPiecePaiementMvt(PiecePaiementMvt piecePaiementMvt) {
		this.piecePaiementMvt = piecePaiementMvt;
	}
	public SerieChequier(Long idSerieChequier, String codeSerieChequier, long numCarnet, String rib, float montant,
			String benificiare, String dateSignature, Date dateLivraison, String status, AgenceBancaire agenceBancaire,
			PiecePaiementMvt piecePaiementMvt) {
		super();
		this.idSerieChequier = idSerieChequier;
		this.codeSerieChequier = codeSerieChequier;
		this.numCarnet = numCarnet;
		this.rib = rib;
		this.montant = montant;
		this.benificiare = benificiare;
		this.dateSignature = dateSignature;
		this.dateLivraison = dateLivraison;
		this.status = status;
		this.agenceBancaire = agenceBancaire;
		this.piecePaiementMvt = piecePaiementMvt;
	}
	public SerieChequier() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	 
}
