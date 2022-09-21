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
@Table(name="comptes_comptable")
public class CompteComptable implements Serializable {

	/**
	 * version 2.0.1 26/04/2017
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long idCompteCpt;
	
	private String codeCpt;
	private String libelleCpt;
	
	private String sensCpt;

	private String typeCpt;
	@Temporal(TemporalType.DATE)
	private Date dateCreation ;
	
	
	// les relations
	@OneToMany(mappedBy="compteComptable",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
			 @JsonIgnore
	
	private List<CompteTresorerie> comptesTresorerie;
	@OneToMany(mappedBy="compteComptable",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
			 @JsonIgnore
	private List<SchemaFluxComptable> chemas;
	public Long getIdCompteCpt() {
		return idCompteCpt;
	}
	public void setIdCompteCpt(Long idCompteCpt) {
		this.idCompteCpt = idCompteCpt;
	}
	public String getCodeCpt() {
		return codeCpt;
	}
	public void setCodeCpt(String codeCpt) {
		this.codeCpt = codeCpt;
	}
	public String getLibelleCpt() {
		return libelleCpt;
	}
	public void setLibelleCpt(String libelleCpt) {
		this.libelleCpt = libelleCpt;
	}
	public String getSensCpt() {
		return sensCpt;
	}
	public void setSensCpt(String sensCpt) {
		this.sensCpt = sensCpt;
	}
	public String getTypeCpt() {
		return typeCpt;
	}
	public void setTypeCpt(String typeCpt) {
		this.typeCpt = typeCpt;
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
	public List<SchemaFluxComptable> getChemas() {
		return chemas;
	}
	public void setChemas(List<SchemaFluxComptable> chemas) {
		this.chemas = chemas;
	}
	public CompteComptable(Long idCompteCpt, String codeCpt, String libelleCpt, String sensCpt, String typeCpt,
			Date dateCreation) {
		super();
		this.idCompteCpt = idCompteCpt;
		this.codeCpt = codeCpt;
		this.libelleCpt = libelleCpt;
		this.sensCpt = sensCpt;
		this.typeCpt = typeCpt;
		this.dateCreation = dateCreation;
	}
	public CompteComptable() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
