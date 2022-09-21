package com.siga.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;;
@Entity
@Table(name="pieces_Jointes")
public class PieceJointe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private String idPiceJointe;
	private String libellePieceJointe;
	private Date dateAjoutePieceJointe ;
	
	@ManyToOne
	@JoinColumn(name="num_mouvement")
	private MouvementTresorerie mouvementTresorerie;
	@ManyToOne
	@JoinColumn(name="type_piece_jointe")
	private TypePieceJointe typePieceJointe;
	public String getIdPiceJointe() {
		return idPiceJointe;
	}
	public void setIdPiceJointe(String idPiceJointe) {
		this.idPiceJointe = idPiceJointe;
	}
	public String getLibellePieceJointe() {
		return libellePieceJointe;
	}
	public void setLibellePieceJointe(String libellePieceJointe) {
		this.libellePieceJointe = libellePieceJointe;
	}
	public Date getDateAjoutePieceJointe() {
		return dateAjoutePieceJointe;
	}
	public void setDateAjoutePieceJointe(Date dateAjoutePieceJointe) {
		this.dateAjoutePieceJointe = dateAjoutePieceJointe;
	}
	public MouvementTresorerie getMouvementTresorerie() {
		return mouvementTresorerie;
	}
	public void setMouvementTresorerie(MouvementTresorerie mouvementTresorerie) {
		this.mouvementTresorerie = mouvementTresorerie;
	}
	public TypePieceJointe getTypePieceJointe() {
		return typePieceJointe;
	}
	public void setTypePieceJointe(TypePieceJointe typePieceJointe) {
		this.typePieceJointe = typePieceJointe;
	}
	public PieceJointe(String idPiceJointe, String libellePieceJointe, Date dateAjoutePieceJointe,
			MouvementTresorerie mouvementTresorerie, TypePieceJointe typePieceJointe) {
		super();
		this.idPiceJointe = idPiceJointe;
		this.libellePieceJointe = libellePieceJointe;
		this.dateAjoutePieceJointe = dateAjoutePieceJointe;
		this.mouvementTresorerie = mouvementTresorerie;
		this.typePieceJointe = typePieceJointe;
	}
	public PieceJointe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
