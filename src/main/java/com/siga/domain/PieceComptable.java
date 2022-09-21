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
@Table(name="pieces_de_comptable")
public class PieceComptable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long idPieceComptable;
	@Column(name="num_piece_comptable")
	private double numPieceComptable;
	private Date datePieceComptable;
	private float montanHT;
	private float montantTaxes;
	private float tauxChange;
	private String status;
   
	@ManyToOne
	@JoinColumn(name="type_piece_comptable")
	private TypePieceComptable typePieceComptable;
	 @ManyToOne
	 @JoinColumn(name="nom_devise")
	 private Devise devise;
	
	 @OneToOne
	 @JoinColumn(name="code_lettrage")
	 private Lettrage lettrage;

	public Long getIdPieceComptable() {
		return idPieceComptable;
	}
  
	public TypePieceComptable getTypePieceComptable() {
		return typePieceComptable;
	}

	public void setTypePieceComptable(TypePieceComptable typePieceComptable) {
		this.typePieceComptable = typePieceComptable;
	}

	public void setIdPieceComptable(Long idPieceComptable) {
		this.idPieceComptable = idPieceComptable;
	}

	public double getNumPieceComptable() {
		return numPieceComptable;
	}

	public void setNumPieceComptable(double numPieceComptable) {
		this.numPieceComptable = numPieceComptable;
	}

	public Date getDatePieceComptable() {
		return datePieceComptable;
	}

	public void setDatePieceComptable(Date datePieceComptable) {
		this.datePieceComptable = datePieceComptable;
	}

	public float getMontanHT() {
		return montanHT;
	}

	public void setMontanHT(float montanHT) {
		this.montanHT = montanHT;
	}

	public float getMontantTaxes() {
		return montantTaxes;
	}

	public void setMontantTaxes(float montantTaxes) {
		this.montantTaxes = montantTaxes;
	}

	public float getTauxChange() {
		return tauxChange;
	}

	public void setTauxChange(float tauxChange) {
		this.tauxChange = tauxChange;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Devise getDevise() {
		return devise;
	}

	public void setDevise(Devise devise) {
		this.devise = devise;
	}

	public Lettrage getLettrage() {
		return lettrage;
	}

	public void setLettrage(Lettrage lettrage) {
		this.lettrage = lettrage;
	}

	public PieceComptable(Long idPieceComptable, double numPieceComptable, Date datePieceComptable, float montanHT,
			float montantTaxes, float tauxChange, String status, Devise devise, Lettrage lettrage) {
		super();
		this.idPieceComptable = idPieceComptable;
		this.numPieceComptable = numPieceComptable;
		this.datePieceComptable = datePieceComptable;
		this.montanHT = montanHT;
		this.montantTaxes = montantTaxes;
		this.tauxChange = tauxChange;
		this.status = status;
		this.devise = devise;
		this.lettrage = lettrage;
	}
	

	public PieceComptable(Long idPieceComptable, double numPieceComptable, Date datePieceComptable, float montanHT,
			float montantTaxes, float tauxChange, String status, TypePieceComptable typePieceComptable, Devise devise,
			Lettrage lettrage) {
		super();
		this.idPieceComptable = idPieceComptable;
		this.numPieceComptable = numPieceComptable;
		this.datePieceComptable = datePieceComptable;
		this.montanHT = montanHT;
		this.montantTaxes = montantTaxes;
		this.tauxChange = tauxChange;
		this.status = status;
		this.typePieceComptable = typePieceComptable;
		this.devise = devise;
		this.lettrage = lettrage;
	}

	public PieceComptable() {
		super();
		// TODO Auto-generated constructor stub
	}

	 
}
