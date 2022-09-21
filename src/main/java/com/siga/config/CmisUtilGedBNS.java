package com.siga.config;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.chemistry.opencmis.client.api.CmisObject;
import org.apache.chemistry.opencmis.client.api.Document;
import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.chemistry.opencmis.client.api.Repository;
import org.apache.chemistry.opencmis.client.api.Session;
import org.apache.chemistry.opencmis.client.api.SessionFactory;
import org.apache.chemistry.opencmis.client.runtime.SessionFactoryImpl;
import org.apache.chemistry.opencmis.client.util.FileUtils;
import org.apache.chemistry.opencmis.commons.PropertyIds;
import org.apache.chemistry.opencmis.commons.SessionParameter;
import org.apache.chemistry.opencmis.commons.data.ContentStream;
import org.apache.chemistry.opencmis.commons.enums.BaseTypeId;
import org.apache.chemistry.opencmis.commons.enums.BindingType;
import org.apache.chemistry.opencmis.commons.enums.VersioningState;
import org.apache.chemistry.opencmis.commons.exceptions.CmisObjectNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.siga.domain.DocumentAlf;
import com.siga.repository.DocumentAlfRepository;
import com.siga.security.SecurityUtils;



@Configuration
@Component
public class CmisUtilGedBNS {
	private static final Logger log = LoggerFactory.getLogger(CmisUtilGedBNS.class);
	
	private static final String ALFRSCO_ATOMPUB_URL5 = "http://localhost:8085/alfresco/cmisatom";

	private static Session session ;
	
	@Autowired
	private static	DocumentAlfRepository documentRepository;
	
	public static Folder connect() {
		
		 log.info("--------------connecting to Alfresco Ged--------------");
		SessionFactory sessionFactory = SessionFactoryImpl.newInstance();
		Map<String, String> parameters = new HashMap<String, String>();

		 log.info("--------------setting user Session Params--------------");
		// User credentials.
		parameters.put(SessionParameter.USER, "admin");
		parameters.put(SessionParameter.PASSWORD, "admin");

		// Connection settings.
		 log.info("--------------Setting URL Session Params--------------");
		
		parameters.put(SessionParameter.BINDING_TYPE, BindingType.ATOMPUB.value());
		parameters.put(SessionParameter.ATOMPUB_URL, ALFRSCO_ATOMPUB_URL5);
		parameters.put(SessionParameter.AUTH_HTTP_BASIC, "true");
		parameters.put(SessionParameter.COOKIES, "true");

		parameters.put(SessionParameter.OBJECT_FACTORY_CLASS,
				"org.alfresco.cmis.client.impl.AlfrescoObjectFactoryImpl");

		// Create session.
		// Alfresco only provides one repository.
		Repository repository = sessionFactory.getRepositories(parameters).get(0);
	    session = repository.createSession();
		Folder root = session.getRootFolder();
   log.info("--------------connected to Alfresco Ged--------------");
		//log.info(root.getName());

		return root;
	}
	
	public static  Folder createFolder(String name,Folder folder) {

		Folder test=getFolderByName(folder,name);
		if (test!=null)
		{
			log.info("already exist.... with iD :"+test.getId());
			return test;
			
		}
		else
		{
			Map<String, String> props = new HashMap<String, String>();
			props.put(PropertyIds.OBJECT_TYPE_ID, "cmis:folder");
			props.put(PropertyIds.NAME, name);
			props.put(PropertyIds.OBJECT_ID,"1");
			
			String user=SecurityUtils.getCurrentUserLogin().get();
			props.put(PropertyIds.CREATED_BY, user);
			props.put(PropertyIds.PATH, folder.getPath());
			Folder newFolder = folder.createFolder(props);

			log.info(newFolder.getName());
			return newFolder;
		}
		

	}
	
	
	
	
	public static  Folder getFolderByName(Folder target, String folderName) {
	Folder foundFolder;
	try {
		CmisObject object = session.getObjectByPath(target.getPath() + folderName);
		foundFolder = (Folder) object;
		// return foundFolder;
	} catch (Exception e) {
		foundFolder = null;
		System.err.println("No folder with this name.");
	}
	return foundFolder;
}
	
	
	public static Document getDocumentByPath(String path) {
	try {

		log.info("------finding document with path :"+path+"------");
		Document doc = (Document) session.getObjectByPath(path);

		return doc;
	} catch (final CmisObjectNotFoundException e) {

		return null;
	}
}	
	
	
	
	
	
	
	public static Folder getFolderByPath(String path) {
		try {

			log.info("------finding folder with path :"+path+"------");
			Folder folder = (Folder) session.getObjectByPath(path);
			
   log.info("-----------found folder with ID :"+folder.getId()+"---------------");
			return folder;
			
		} catch (final CmisObjectNotFoundException e) {

			return null;
		}
	}	
		
	
	

	public byte[] fileToByteArray(String path) {
		FileInputStream fileInputStream = null;

		File file = new File(path);

		byte[] bFile = new byte[(int) file.length()];

		try {
			// convert file into array of bytes
			fileInputStream = new FileInputStream(file);
			fileInputStream.read(bFile);
			fileInputStream.close();

			// for (int i = 0; i < bFile.length; i++) {
			// System.out.print((char)bFile[i]);
			// }
			//
			// System.out.println("Done");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bFile;
	}
	
	public static void createDocumentFromFile(Folder target, String newDocName, File file) {
	Map<String, String> props = new HashMap<String, String>();
	// String newDocName = file.getName();
	// String pathFile = file.getPath();
	String parentID = file.getParentFile().getPath();
	props.put(PropertyIds.OBJECT_TYPE_ID, "cmis:document");
	props.put(PropertyIds.NAME, newDocName);
	log.info("This is a test document: " + newDocName);

	try {
		Document docFromFile = FileUtils.createDocumentFromFile(parentID, file, newDocName, VersioningState.MAJOR,
				session);
		target.addToFolder(docFromFile, true);
		log.info("created");
	} catch (java.io.FileNotFoundException ex) {
		// Logger.getLogger(CmisUtilsGed.class.getName()).log(Level.SEVERE,
		// null, ex);
		log.error(" **!!!!***** FileNotFoundException " + ex.getMessage());
		
	}
	


}	
	
	
	
	public void createDocument(Folder target, String newDocName, byte[] pjFichier, String contentType) {
		Map<String, String> props = new HashMap<String, String>();
		props.put(PropertyIds.OBJECT_TYPE_ID, "cmis:document");
		props.put(PropertyIds.NAME, newDocName);
		System.out.println("This is a document: " + newDocName);

		ByteArrayInputStream input = new ByteArrayInputStream(pjFichier);
		ContentStream contentStream = session.getObjectFactory().createContentStream(newDocName, pjFichier.length,
				contentType, input);
		target.createDocument(props, contentStream, VersioningState.MAJOR);

	}
	public void createDocument1(Folder target, String newDocName, byte[] pjFichier, String contentType,
                    Map<String, String> props) {
             // Map<String, String> props = new HashMap<String, String>();
             // props.put(PropertyIds.OBJECT_TYPE_ID, "cmis:document");
             // props.put(PropertyIds.NAME, newDocName);
             // props.put(PropertyIds.DESCRIPTION, "tester");
             //
             //
             // System.out.println("This is a document: " + newDocName);
 
             ByteArrayInputStream input = new ByteArrayInputStream(pjFichier);
             ContentStream contentStream = session.getObjectFactory().createContentStream(newDocName, pjFichier.length,
                           contentType, input);
             target.createDocument(props, contentStream, VersioningState.MAJOR);
 
       }

	
	
	
	
	public static Session getSession()
	{
		return session ;
	}
	
	public static List<DocumentAlf> getIdDocs(Folder target) {
		
		List<DocumentAlf> listeId = new ArrayList<DocumentAlf>();
		
		DocumentAlf d=new DocumentAlf();
	
		for (Iterator<CmisObject> it = target.getChildren().iterator(); it.hasNext();) {
		CmisObject o = it.next();
		if (BaseTypeId.CMIS_DOCUMENT.equals(o.getBaseTypeId())) {
			Document doc = (Document) o;
			String id = doc.getId();
		id = id.substring(0, id.indexOf(";"));
			String name=doc.getName();
			String createdBy=doc.getCreatedBy();
			String type=doc.getContentStreamMimeType();
			
			
			d.setIdFile(id);
			d.setFileName(name);
			d.setCreatedBy(createdBy);
			d.setFileType(type);
			log.info("------file found kk :" +id);
			log.info("file name kkk: "+name);
		//documentRepository.save(d);
			
			listeId.add(d);
		}
	}
	return listeId;
}
	}
	

