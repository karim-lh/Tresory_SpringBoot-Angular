package com.siga.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="alfresco_Docs")
public class DocumentAlf {

	@Id
	
    @GeneratedValue 
	private Long idDoc;
	
	private String idFile;
	private String fileName;
	private String fileType;
	private String fileSize;
	private String createdBy;
	public Long getIdDoc() {
		return idDoc;
	}
	public void setIdDoc(Long idDoc) {
		this.idDoc = idDoc;
	}
	public String getIdFile() {
		return idFile;
	}
	public void setIdFile(String idFile) {
		this.idFile = idFile;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	public String getFileSize() {
		return fileSize;
	}
	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public DocumentAlf() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
