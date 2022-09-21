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
@Table(name="Schema_Flux_Comptable")
public class SchemaFluxComptable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long idSchemaFluxComptable;
	@Column(name="code_sch_flux_CPT")
	private String codeSchemaFluxCoOmptable;
	private String sensSchemaFluxComptable;
	private Date dateCreation ;
	
	
	// les relations
	@ManyToOne
	@JoinColumn(name="code_compte_comptable")
	private CompteComptable compteComptable;
	@OneToOne
	@JoinColumn(name="code_flux_tresorerie")
	private FluxTresorerie fluxTresorerie;
	public Long getIdSchemaFluxComptable() {
		return idSchemaFluxComptable;
	}
	public void setIdSchemaFluxComptable(Long idSchemaFluxComptable) {
		this.idSchemaFluxComptable = idSchemaFluxComptable;
	}
	public String getCodeSchemaFluxCoOmptable() {
		return codeSchemaFluxCoOmptable;
	}
	public void setCodeSchemaFluxCoOmptable(String codeSchemaFluxCoOmptable) {
		this.codeSchemaFluxCoOmptable = codeSchemaFluxCoOmptable;
	}
	public String getSensSchemaFluxComptable() {
		return sensSchemaFluxComptable;
	}
	public void setSensSchemaFluxComptable(String sensSchemaFluxComptable) {
		this.sensSchemaFluxComptable = sensSchemaFluxComptable;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public CompteComptable getCompteComptable() {
		return compteComptable;
	}
	public void setCompteComptable(CompteComptable compteComptable) {
		this.compteComptable = compteComptable;
	}
	public FluxTresorerie getFluxTresorerie() {
		return fluxTresorerie;
	}
	public void setFluxTresorerie(FluxTresorerie fluxTresorerie) {
		this.fluxTresorerie = fluxTresorerie;
	}
	public SchemaFluxComptable(Long idSchemaFluxComptable, String codeSchemaFluxCoOmptable,
			String sensSchemaFluxComptable, Date dateCreation, CompteComptable compteComptable,
			FluxTresorerie fluxTresorerie) {
		super();
		this.idSchemaFluxComptable = idSchemaFluxComptable;
		this.codeSchemaFluxCoOmptable = codeSchemaFluxCoOmptable;
		this.sensSchemaFluxComptable = sensSchemaFluxComptable;
		this.dateCreation = dateCreation;
		this.compteComptable = compteComptable;
		this.fluxTresorerie = fluxTresorerie;
	}
	public SchemaFluxComptable() {
		super();
		// TODO Auto-generated constructor stub
	}


}
