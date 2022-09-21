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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="modes_de_paiement")
public class ModePaiement implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long idModePaiement;
	
	private String codeModePaiement;
	@Column(name="mode_paiement")
	private String libelleModePaiement;
	private Date dateCreation ;
	
	@OneToMany(mappedBy="modePaiement",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	 @JsonIgnore
	private List<PiecePaiementMvt> pieces;

	public Long getIdModePaiement() {
		return idModePaiement;
	}

	public void setIdModePaiement(Long idModePaiement) {
		this.idModePaiement = idModePaiement;
	}

	public String getCodeModePaiement() {
		return codeModePaiement;
	}

	public void setCodeModePaiement(String codeModePaiement) {
		this.codeModePaiement = codeModePaiement;
	}

	public String getLibelleModePaiement() {
		return libelleModePaiement;
	}

	public void setLibelleModePaiement(String libelleModePaiement) {
		this.libelleModePaiement = libelleModePaiement;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public List<PiecePaiementMvt> getPieces() {
		return pieces;
	}

	public void setPieces(List<PiecePaiementMvt> pieces) {
		this.pieces = pieces;
	}

	public ModePaiement(Long idModePaiement, String codeModePaiement, String libelleModePaiement, Date dateCreation) {
		super();
		this.idModePaiement = idModePaiement;
		this.codeModePaiement = codeModePaiement;
		this.libelleModePaiement = libelleModePaiement;
		this.dateCreation = dateCreation;
	}

	public ModePaiement() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
