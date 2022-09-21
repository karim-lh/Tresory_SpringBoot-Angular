package com.siga.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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
@Table(name="types_Demandes")
public class TypeDemande implements Serializable{

	@Id
	@GeneratedValue
	private Long idTypeDemande;
	private String codeTypeDemande;
	private String libelleTypeDemande;
	@Temporal(TemporalType.DATE)
	private Date dateAjoute;
	@OneToMany(mappedBy="typeDemande",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JsonIgnore
	private List<Demande> demandes;
	public Long getIdTypeDemande() {
		return idTypeDemande;
	}
	public void setIdTypeDemande(Long idTypeDemande) {
		this.idTypeDemande = idTypeDemande;
	}
	public String getCodeTypeDemande() {
		return codeTypeDemande;
	}
	public void setCodeTypeDemande(String codeTypeDemande) {
		this.codeTypeDemande = codeTypeDemande;
	}
	public String getLibelleTypeDemande() {
		return libelleTypeDemande;
	}
	public void setLibelleTypeDemande(String libelleTypeDemande) {
		this.libelleTypeDemande = libelleTypeDemande;
	}
	public Date getDateAjoute() {
		return dateAjoute;
	}
	public void setDateAjoute(Date dateAjoute) {
		this.dateAjoute = dateAjoute;
	}
	public List<Demande> getDemandes() {
		return demandes;
	}
	public void setDemandes(List<Demande> demandes) {
		this.demandes = demandes;
	}
	public TypeDemande(Long idTypeDemande, String codeTypeDemande, String libelleTypeDemande, Date dateAjoute,
			List<Demande> demandes) {
		super();
		this.idTypeDemande = idTypeDemande;
		this.codeTypeDemande = codeTypeDemande;
		this.libelleTypeDemande = libelleTypeDemande;
		this.dateAjoute = dateAjoute;
		this.demandes = demandes;
	}
	public TypeDemande() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
