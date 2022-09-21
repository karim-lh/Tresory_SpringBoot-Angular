package com.siga.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="devises_Iso")
public class Devise implements Serializable {

	/**
	 *  version 2.0.1 26/04/2017
	 */
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long idDevise;
	private String codeIsoDevise;
	private int codeIsoNum;
	private String symbole;
	@Column(name="nom_devise")
	private String libelleDevise;
	
	@OneToOne
	private Pays pays;
	

	public List<PiecePaiementMvt> getPieces() {
		return pieces;
	}
	public void setPieces(List<PiecePaiementMvt> pieces) {
		this.pieces = pieces;
	}
	@OneToMany(mappedBy="devise",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JsonIgnore
	private List<PiecePaiementMvt> pieces;

	@OneToMany(mappedBy="devise",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JsonIgnore
	private List<PieceComptable> piecesComptable;
	@OneToMany(mappedBy="devise",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JsonIgnore
	private List<MouvementTresorerie> mouvements;
	public Long getIdDevise() {
		return idDevise;
	}
	public void setIdDevise(Long idDevise) {
		this.idDevise = idDevise;
	}
	public String getCodeIsoDevise() {
		return codeIsoDevise;
	}
	public void setCodeIsoDevise(String codeIsoDevise) {
		this.codeIsoDevise = codeIsoDevise;
	}
	public int getCodeIsoNum() {
		return codeIsoNum;
	}
	public void setCodeIsoNum(int codeIsoNum) {
		this.codeIsoNum = codeIsoNum;
	}
	public String getSymbole() {
		return symbole;
	}
	public void setSymbole(String symbole) {
		this.symbole = symbole;
	}
	public String getLibelleDevise() {
		return libelleDevise;
	}
	public void setLibelleDevise(String libelleDevise) {
		this.libelleDevise = libelleDevise;
	}
	public Pays getPays() {
		return pays;
	}
	public void setPays(Pays pays) {
		this.pays = pays;
	}
	public List<PieceComptable> getPiecesComptable() {
		return piecesComptable;
	}
	public void setPiecesComptable(List<PieceComptable> piecesComptable) {
		this.piecesComptable = piecesComptable;
	}
	public List<MouvementTresorerie> getMouvements() {
		return mouvements;
	}
	public void setMouvements(List<MouvementTresorerie> mouvements) {
		this.mouvements = mouvements;
	}
	public Devise(Long idDevise, String codeIsoDevise, int codeIsoNum, String symbole, String libelleDevise,
			Pays pays) {
		super();
		this.idDevise = idDevise;
		this.codeIsoDevise = codeIsoDevise;
		this.codeIsoNum = codeIsoNum;
		this.symbole = symbole;
		this.libelleDevise = libelleDevise;
		this.pays = pays;
	}
	public Devise() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
