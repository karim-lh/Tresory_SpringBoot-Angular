package com.siga.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="flux_de_treosrerie")
public class FluxTresorerie {

	@Id
	@GeneratedValue
	private Long idFluxTresorerie;
	@Column(name="code_flux_treosrerie")
	private String codeFluxTresorerie;
	private String libelleFluxTresorerie;
	private String natureFlux;
	@Temporal(TemporalType.DATE)
	private Date dateCreation ;
	
	@OneToMany(mappedBy="fluxTresorerie",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	@JsonIgnore
	private List<MouvementTresorerie> mouvements;
	
	@OneToOne
	@JoinColumn(name="code_sch_flux_CPT")
	private SchemaFluxComptable schemaFluxComptable;

	public Long getIdFluxTresorerie() {
		return idFluxTresorerie;
	}

	public void setIdFluxTresorerie(Long idFluxTresorerie) {
		this.idFluxTresorerie = idFluxTresorerie;
	}

	public String getCodeFluxTresorerie() {
		return codeFluxTresorerie;
	}

	public void setCodeFluxTresorerie(String codeFluxTresorerie) {
		this.codeFluxTresorerie = codeFluxTresorerie;
	}

	public String getLibelleFluxTresorerie() {
		return libelleFluxTresorerie;
	}

	public void setLibelleFluxTresorerie(String libelleFluxTresorerie) {
		this.libelleFluxTresorerie = libelleFluxTresorerie;
	}

	public String getNatureFlux() {
		return natureFlux;
	}

	public void setNatureFlux(String natureFlux) {
		this.natureFlux = natureFlux;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public List<MouvementTresorerie> getMouvements() {
		return mouvements;
	}

	public void setMouvements(List<MouvementTresorerie> mouvements) {
		this.mouvements = mouvements;
	}

	public SchemaFluxComptable getSchemaFluxComptable() {
		return schemaFluxComptable;
	}

	public void setSchemaFluxComptable(SchemaFluxComptable schemaFluxComptable) {
		this.schemaFluxComptable = schemaFluxComptable;
	}

	public FluxTresorerie(Long idFluxTresorerie, String codeFluxTresorerie, String libelleFluxTresorerie,
			String natureFlux, Date dateCreation, SchemaFluxComptable schemaFluxComptable) {
		super();
		this.idFluxTresorerie = idFluxTresorerie;
		this.codeFluxTresorerie = codeFluxTresorerie;
		this.libelleFluxTresorerie = libelleFluxTresorerie;
		this.natureFlux = natureFlux;
		this.dateCreation = dateCreation;
		this.schemaFluxComptable = schemaFluxComptable;
	}

	public FluxTresorerie() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
