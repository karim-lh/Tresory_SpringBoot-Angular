package com.siga.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="tiers")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_tiers")
@DiscriminatorValue("T")
public class Tiers implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long idTiers;
	
		private Date dateAjoute ;
        private String numTel;
	
		private String idanttifiant;
		
		
		public String getIdanttifiant() {
			return idanttifiant;
		}

		public void setIdanttifiant(String idanttifiant) {
			this.idanttifiant = idanttifiant;
		}

		public List<PiecePaiementMvt> getPieces() {
			return pieces;
		}

		public void setPieces(List<PiecePaiementMvt> pieces) {
			this.pieces = pieces;
		}

		


		@OneToMany(mappedBy="tiers",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
		 @JsonIgnore
       private List<CompteBancaireTiers> comptesBancaires;	
      
		@OneToMany(mappedBy="tiers",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
		 @JsonIgnore
		private List<MouvementTresorerie> mouvements;
      
		@OneToMany(mappedBy="benificaire",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
		 @JsonIgnore
		private List<PiecePaiementMvt> pieces ;

		public String getNumTel() {
			return numTel;
		}

		public void setNumTel(String numTel) {
			this.numTel = numTel;
		}

		public Long getIdTiers() {
			return idTiers;
		}

		public void setIdTiers(Long idTiers) {
			this.idTiers = idTiers;
		}

	
		public Date getDateAjoute() {
			return dateAjoute;
		}

		public void setDateAjoute(Date dateAjoute) {
			this.dateAjoute = dateAjoute;
		}

		
		
		
		public List<CompteBancaireTiers> getComptesBancaires() {
			return comptesBancaires;
		}

		public void setComptesBancaires(List<CompteBancaireTiers> comptesBancaires) {
			this.comptesBancaires = comptesBancaires;
		}

		public List<MouvementTresorerie> getMouvements() {
			return mouvements;
		}

		public void setMouvements(List<MouvementTresorerie> mouvements) {
			this.mouvements = mouvements;
		}

		public Tiers(Long idTiers,  Date dateAjoute) {
			super();
			this.idTiers = idTiers;
		
			this.dateAjoute = dateAjoute;
		}

		
		public Tiers(Long idTiers, Date dateAjoute, String numTel) {
			super();
			this.idTiers = idTiers;
			
			this.dateAjoute = dateAjoute;
			this.numTel = numTel;
		}

		public Tiers() {
			super();
			// TODO Auto-generated constructor stub
		}

	
		public String getFormeJuridique ()
		{
			 return this.getClass().getName()=="com.bns.domain.PersonneMorale" ?"PersonneMorale" :"PersonnePhysique"  ;
		}	
		
		
		
}
