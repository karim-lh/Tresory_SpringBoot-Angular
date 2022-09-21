package com.siga.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="lettrages")
public class Lettrage implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long idLettrage;
	@Column(name="code_lettrage")
	private String codeLettrage;
	 private String libelleLettrage;
	 private Date dateCreation ;
	private float MontantAffecte;
	
   @OneToOne
   @JoinColumn(name="num_mouvement")
   private MouvementTresorerie mouvementTresorerie;
	@OneToOne
	@JoinColumn(name="num_piece_comptable")
	private PieceComptable pieceComptable;
	public Long getIdLettrage() {
		return idLettrage;
	}
	public void setIdLettrage(Long idLettrage) {
		this.idLettrage = idLettrage;
	}
	public String getCodeLettrage() {
		return codeLettrage;
	}
	public void setCodeLettrage(String codeLettrage) {
		this.codeLettrage = codeLettrage;
	}
	public String getLibelleLettrage() {
		return libelleLettrage;
	}
	public void setLibelleLettrage(String libelleLettrage) {
		this.libelleLettrage = libelleLettrage;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public float getMontantAffecte() {
		return MontantAffecte;
	}
	public void setMontantAffecte(float montantAffecte) {
		MontantAffecte = montantAffecte;
	}
	public MouvementTresorerie getMouvementTresorerie() {
		return mouvementTresorerie;
	}
	public void setMouvementTresorerie(MouvementTresorerie mouvementTresorerie) {
		this.mouvementTresorerie = mouvementTresorerie;
	}
	public PieceComptable getPieceComptable() {
		return pieceComptable;
	}
	public void setPieceComptable(PieceComptable pieceComptable) {
		this.pieceComptable = pieceComptable;
	}
	public Lettrage(Long idLettrage, String codeLettrage, String libelleLettrage, Date dateCreation,
			float montantAffecte, MouvementTresorerie mouvementTresorerie, PieceComptable pieceComptable) {
		super();
		this.idLettrage = idLettrage;
		this.codeLettrage = codeLettrage;
		this.libelleLettrage = libelleLettrage;
		this.dateCreation = dateCreation;
		MontantAffecte = montantAffecte;
		this.mouvementTresorerie = mouvementTresorerie;
		this.pieceComptable = pieceComptable;
	}
	public Lettrage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
