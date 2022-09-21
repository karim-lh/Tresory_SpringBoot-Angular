package com.siga.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Alfresco_Documents_Ref")
public class DocumentAlfr implements Serializable {

	
	@Id
	@GeneratedValue
	private Long idDocument;
	
	private String fileName;
	
	private String dateCreation;
	
	private String createdBy;
	
	private String contentType;
	
	
}
