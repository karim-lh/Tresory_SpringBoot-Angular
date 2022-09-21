package com.siga.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name="Types_Pieces_Jointes")
public class TypePieceJointe implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long idTypePiceJointe;
	
	private String codeTypePieceJointe ;
	@Column(name="type_piece_jointe")
	private String libelleTypePieceJointe;
	private Date dateCreation ;
	
	@OneToMany(mappedBy="typePieceJointe")
	private List<PieceJointe> piecesJointes;

	public Long getIdTypePiceJointe() {
		return idTypePiceJointe;
	}

	public void setIdTypePiceJointe(Long idTypePiceJointe) {
		this.idTypePiceJointe = idTypePiceJointe;
	}

	public String getCodeTypePieceJointe() {
		return codeTypePieceJointe;
	}

	public void setCodeTypePieceJointe(String codeTypePieceJointe) {
		this.codeTypePieceJointe = codeTypePieceJointe;
	}

	public String getLibelleTypePieceJointe() {
		return libelleTypePieceJointe;
	}

	public void setLibelleTypePieceJointe(String libelleTypePieceJointe) {
		this.libelleTypePieceJointe = libelleTypePieceJointe;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public List<PieceJointe> getPiecesJointes() {
		return piecesJointes;
	}

	public void setPiecesJointes(List<PieceJointe> piecesJointes) {
		this.piecesJointes = piecesJointes;
	}

	public TypePieceJointe(Long idTypePiceJointe, String codeTypePieceJointe, String libelleTypePieceJointe,
			Date dateCreation) {
		super();
		this.idTypePiceJointe = idTypePiceJointe;
		this.codeTypePieceJointe = codeTypePieceJointe;
		this.libelleTypePieceJointe = libelleTypePieceJointe;
		this.dateCreation = dateCreation;
	}

	public TypePieceJointe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
