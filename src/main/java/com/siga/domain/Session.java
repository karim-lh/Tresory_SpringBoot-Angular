package com.siga.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="sessions")
public class Session implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private Long idSession;
	@Temporal(TemporalType.DATE)
	private Date dateLogin;
	private Date dateLogout;
	private String ipConnexion;
	private int Status;
	private HashMap attribues;
	@ManyToOne
	private User user;
	public Long getIdSession() {
		return idSession;
	}
	public void setIdSession(Long idSession) {
		this.idSession = idSession;
	}
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public HashMap getAttribues() {
		return attribues;
	}
	public void setAttribues(HashMap attribues) {
		this.attribues = attribues;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Date getDateLogin() {
		return dateLogin;
	}
	public void setDateLogin(Date dateLogin) {
		this.dateLogin = dateLogin;
	}
	public Date getDateLogout() {
		return dateLogout;
	}
	public void setDateLogout(Date dateLogout) {
		this.dateLogout = dateLogout;
	}
	public Session(Long idSession, Date dateLogin, Date dateLogout, int status, HashMap attribues, User user) {
		super();
		this.idSession = idSession;
		this.dateLogin = dateLogin;
		this.dateLogout = dateLogout;
		Status = status;
		this.attribues = attribues;
		this.user = user;
	}
	public Session() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getIpConnexion() {
		return ipConnexion;
	}
	public void setIpConnexion(String ipConnexion) {
		this.ipConnexion = ipConnexion;
	}
	public Session(Long idSession, Date dateLogin, Date dateLogout, String ipConnexion, int status, HashMap attribues,
			User user) {
		super();
		this.idSession = idSession;
		this.dateLogin = dateLogin;
		this.dateLogout = dateLogout;
		this.ipConnexion = ipConnexion;
		Status = status;
		this.attribues = attribues;
		this.user = user;
	}
	
	
	
}
