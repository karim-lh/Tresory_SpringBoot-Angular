package com.siga.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="agences_Societe")
public class AgenceSociete implements Serializable {

	/**
	 * version 2.0.1 26/04/2017
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long idAgenceSociete;
	
	private String codeAgenceSociete;
	@Column(name="nom_agence")
	private String libelleAgenceSociete;
	@Temporal(TemporalType.DATE)
	private Date dateCreation ;
	
	
	@ManyToOne
	@JoinColumn(name="nom_siege")
	private Societe siege;
	@OneToMany(mappedBy="agence")
	private List<Employe> employes;
	public Long getIdAgenceSociete() {
		return idAgenceSociete;
	}
	public void setIdAgenceSociete(Long idAgenceSociete) {
		this.idAgenceSociete = idAgenceSociete;
	}
	public String getCodeAgenceSociete() {
		return codeAgenceSociete;
	}
	public void setCodeAgenceSociete(String codeAgenceSociete) {
		this.codeAgenceSociete = codeAgenceSociete;
	}
	public String getLibelleAgenceSociete() {
		return libelleAgenceSociete;
	}
	public void setLibelleAgenceSociete(String libelleAgenceSociete) {
		this.libelleAgenceSociete = libelleAgenceSociete;
	}
	public Date getDateCreation() {
		return dateCreation;
	}
	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	public Societe getSiege() {
		return siege;
	}
	public void setSiege(Societe siege) {
		this.siege = siege;
	}
	public List<Employe> getEmployes() {
		return employes;
	}
	public void setEmployes(List<Employe> employes) {
		this.employes = employes;
	}
	public AgenceSociete(Long idAgenceSociete, String codeAgenceSociete, String libelleAgenceSociete, Date dateCreation,
			Societe siege) {
		super();
		this.idAgenceSociete = idAgenceSociete;
		this.codeAgenceSociete = codeAgenceSociete;
		this.libelleAgenceSociete = libelleAgenceSociete;
		this.dateCreation = dateCreation;
		this.siege = siege;
	}
	public AgenceSociete() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
