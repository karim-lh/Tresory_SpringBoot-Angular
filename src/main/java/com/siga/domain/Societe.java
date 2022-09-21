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
@Entity
@Table(name="Societes")
public class Societe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long idSociete;
	private String codeSociete;
	@Column(name="nom_siege")
	private String libelleSociete;
	private Date dateCreation ;
	
	
	// les relations avec les autrees tables
	
	@ManyToOne
	@JoinColumn(name="code_groupe")
	private GroupeSociete groupeSociete;
	
	@OneToMany(mappedBy="siege")
	private  List<AgenceSociete> agences ;

	public Long getIdSociete() {
		return idSociete;
	}

	public void setIdSociete(Long idSociete) {
		this.idSociete = idSociete;
	}

	public String getCodeSociete() {
		return codeSociete;
	}

	public void setCodeSociete(String codeSociete) {
		this.codeSociete = codeSociete;
	}

	public String getLibelleSociete() {
		return libelleSociete;
	}

	public void setLibelleSociete(String libelleSociete) {
		this.libelleSociete = libelleSociete;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public GroupeSociete getGroupeSociete() {
		return groupeSociete;
	}

	public void setGroupeSociete(GroupeSociete groupeSociete) {
		this.groupeSociete = groupeSociete;
	}

	public List<AgenceSociete> getAgences() {
		return agences;
	}

	public void setAgences(List<AgenceSociete> agences) {
		this.agences = agences;
	}

	public Societe(Long idSociete, String codeSociete, String libelleSociete, Date dateCreation,
			GroupeSociete groupeSociete) {
		super();
		this.idSociete = idSociete;
		this.codeSociete = codeSociete;
		this.libelleSociete = libelleSociete;
		this.dateCreation = dateCreation;
		this.groupeSociete = groupeSociete;
	}

	public Societe() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
