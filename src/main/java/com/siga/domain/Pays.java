package com.siga.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Pays_Iso")
public class Pays implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long idPays;
	private String codePays;
	private String alpha2;
	private String alpha3;
	private String langGb ;
	private String langFr;
	

@OneToOne
(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
@JsonIgnore
@JoinColumn(name="nom_devise")
private Devise devise;



public String getLanggb() {
	return langGb;
}

public void setLanggb(String langgb) {
	this.langGb = langgb;
}

public Pays(Long idPays, String codePays, String alpha2, String alpha3, String langgb, String langFr) {
	super();
	this.idPays = idPays;
	this.codePays = codePays;
	this.alpha2 = alpha2;
	this.alpha3 = alpha3;
	this.langGb = langgb;
	this.langFr = langFr;
}

public Long getIdPays() {
	return idPays;
}

public void setIdPays(Long idPays) {
	this.idPays = idPays;
}

public String getCodePays() {
	return codePays;
}

public void setCodePays(String codePays) {
	this.codePays = codePays;
}

public String getAlpha2() {
	return alpha2;
}

public void setAlpha2(String alpha2) {
	this.alpha2 = alpha2;
}

public String getAlpha3() {
	return alpha3;
}

public void setAlpha3(String alpha3) {
	this.alpha3 = alpha3;
}



public String getLangFr() {
	return langFr;
}

public void setLangFr(String langFr) {
	this.langFr = langFr;
}


public Devise getDevise() {
	return devise;
}

public void setDevise(Devise devise) {
	this.devise = devise;
}

public Pays(Long idPays, String codePays, String alpha2, String alpha3, String langCs, String lanfDn, String langEn,
		String langEs, String langFr, String langIt, String langNl, Devise devise) {
	super();
	this.idPays = idPays;
	this.codePays = codePays;
	this.alpha2 = alpha2;
	this.alpha3 = alpha3;
	
	this.langFr = langFr;
	
}

public Pays(String codePays, String alpha2, String alpha3, String langCs, String lanfDn, String langEn, String langEs,
		String langFr, String langIt, String langNl) {
	super();
	this.codePays = codePays;
	this.alpha2 = alpha2;
	this.alpha3 = alpha3;
	
	this.langFr = langFr;

}

public Pays() {
	super();
	// TODO Auto-generated constructor stub
}

	
}
