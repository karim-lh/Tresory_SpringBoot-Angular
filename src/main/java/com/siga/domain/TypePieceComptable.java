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
@Table(name="Types_Pieces_comptable")
public class TypePieceComptable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long idTypePieceComptable;
	private String codeTypePiececomptable;
	@Column(name="type_piece_comptable")
	private String libelleTypePieceComptable;
	private Date dateCreation ;
	
	@OneToMany(mappedBy="typePieceComptable")
	private List<PieceComptable> piecesComptables;
	
	
	
	
	public List<PieceComptable> getPiecesComptables() {
		return piecesComptables;
	}
	public void setPiecesComptables(List<PieceComptable> piecesComptables) {
		this.piecesComptables = piecesComptables;
	}
	public Long getIdTypePieceComptable() {
		return idTypePieceComptable;
	}
	public void setIdTypePieceComptable(Long idTypePieceComptable) {
		this.idTypePieceComptable = idTypePieceComptable;
	}
	public String getCodeTypePiececomptable() {
		return codeTypePiececomptable;
	}
	public void setCodeTypePiececomptable(String codeTypePiececomptable) {
		this.codeTypePiececomptable = codeTypePiececomptable;
	}
	public String getLibelleTypePieceComptable() {
		return libelleTypePieceComptable;
	}
	public void setLibelleTypePieceComptable(String libelleTypePieceComptable) {
		this.libelleTypePieceComptable = libelleTypePieceComptable;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public TypePieceComptable(Long idTypePieceComptable, String codeTypePiececomptable,
			String libelleTypePieceComptable, Date dateCreation) {
		super();
		this.idTypePieceComptable = idTypePieceComptable;
		this.codeTypePiececomptable = codeTypePiececomptable;
		this.libelleTypePieceComptable = libelleTypePieceComptable;
		this.dateCreation = dateCreation;
	}
	public TypePieceComptable() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
