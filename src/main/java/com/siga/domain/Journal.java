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
@Table(name="journaux")
public class Journal implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name="idJournal")
	private Long idJournal;
	@Column(nullable=false,unique=true,name="code_journal")
	private String codeJournal;
	private String libelleJournal;
@Temporal(TemporalType.DATE)
	private Date dateCreation ;
	/*
	 * les relations
	 */
	@OneToMany(mappedBy="journal",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	 @JsonIgnore
	private List<CompteTresorerie> comptesTresorerie;
	public Long getIdJournal() {
		return idJournal;
	}
	public void setIdJournal(Long idJournal) {
		this.idJournal = idJournal;
	}
	public String getCodeJournal() {
		return codeJournal;
	}
	public void setCodeJournal(String codeJournal) {
		this.codeJournal = codeJournal;
	}
	public String getLibelleJournal() {
		return libelleJournal;
	}
	public void setLibelleJournal(String libelleJournal) {
		this.libelleJournal = libelleJournal;
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
	public Journal(Long idJournal, String codeJournal, String libelleJournal, Date dateCreation
			) {
		super();
		this.idJournal = idJournal;
		this.codeJournal = codeJournal;
		this.libelleJournal = libelleJournal;
		this.dateCreation = dateCreation;
		
	}
	public Journal() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
