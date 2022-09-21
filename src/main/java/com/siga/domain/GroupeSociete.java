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
@Table (name="Groupes_des_Societes")
public class GroupeSociete implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long idGroupeSociete;
	@Column(name="code_groupe")
	private String codeGroupeSociete;
	private String libelleGroupeSociete;
	private Date dateCreation ;
 
	@OneToMany(mappedBy="groupeSociete")
	private List<Societe> societes;

	public Long getIdGroupeSociete() {
		return idGroupeSociete;
	}

	public void setIdGroupeSociete(Long idGroupeSociete) {
		this.idGroupeSociete = idGroupeSociete;
	}

	public String getCodeGroupeSociete() {
		return codeGroupeSociete;
	}

	public void setCodeGroupeSociete(String codeGroupeSociete) {
		this.codeGroupeSociete = codeGroupeSociete;
	}

	public String getLibelleGroupeSociete() {
		return libelleGroupeSociete;
	}

	public void setLibelleGroupeSociete(String libelleGroupeSociete) {
		this.libelleGroupeSociete = libelleGroupeSociete;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public List<Societe> getSocietes() {
		return societes;
	}

	public void setSocietes(List<Societe> societes) {
		this.societes = societes;
	}

	public GroupeSociete(Long idGroupeSociete, String codeGroupeSociete, String libelleGroupeSociete,
			Date dateCreation) {
		super();
		this.idGroupeSociete = idGroupeSociete;
		this.codeGroupeSociete = codeGroupeSociete;
		this.libelleGroupeSociete = libelleGroupeSociete;
		this.dateCreation = dateCreation;
	}

	public GroupeSociete() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
