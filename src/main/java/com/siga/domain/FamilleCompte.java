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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="famille_Cpt_Tre")
public class FamilleCompte implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long idFamille;
	@Column(unique=true,name="code_famille")
	private String codeFamille;
	
	@Column(unique=true,name="nom_famille")
	private String libelleFamille;
	@Temporal(TemporalType.DATE)
	private Date dateCreation ;
	
	@OneToMany(mappedBy="familleCompte",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JsonIgnore
	private List<CompteTresorerie> comptesTresorerie;

	public Long getIdFamille() {
		return idFamille;
	}

	public void setIdFamille(Long idFamille) {
		this.idFamille = idFamille;
	}

	public String getCodeFamille() {
		return codeFamille;
	}

	public void setCodeFamille(String codeFamille) {
		this.codeFamille = codeFamille;
	}

	public String getLibelleFamille() {
		return libelleFamille;
	}

	public void setLibelleFamille(String libelleFamille) {
		this.libelleFamille = libelleFamille;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public List<CompteTresorerie> getComptesTresorerie() {
		return comptesTresorerie;
	}

	public void setComptesTresorerie(List<CompteTresorerie> comptesTresorerie) {
		this.comptesTresorerie = comptesTresorerie;
	}

	public FamilleCompte(Long idFamille, String codeFamille, String libelleFamille, Date dateCreation) {
		super();
		this.idFamille = idFamille;
		this.codeFamille = codeFamille;
		this.libelleFamille = libelleFamille;
		this.dateCreation = dateCreation;
	}

	public FamilleCompte() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
