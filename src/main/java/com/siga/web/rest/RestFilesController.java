package com.siga.web.rest;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.chemistry.opencmis.client.api.Folder;
import org.apache.chemistry.opencmis.commons.PropertyIds;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.siga.config.CmisUtilGedBNS;
import com.siga.domain.DocumentAlf;
import com.siga.security.SecurityUtils;


@RestController
@RequestMapping("/api")
public class RestFilesController {

	

@RequestMapping(value="/file",method=RequestMethod.POST)
public void Injection(@RequestParam("file") MultipartFile file,@RequestParam ("name") String name,@RequestParam("folderParent") String folderParent,@RequestParam("folderName") String folderName)
{
    CmisUtilGedBNS cmisUtils = new CmisUtilGedBNS();
    
   
    
    String val="trying";
    String path="/PFE/"+folderParent;
   Folder parent= cmisUtils.getFolderByPath(path);
   Folder target=cmisUtils.createFolder(folderName, parent);
   Date date=new Date();
   String user =SecurityUtils.getCurrentUserLogin().get();
   
    if (target != null) {
           try  {

                  byte[] bFile = file.getBytes();

                  Map<String, String> props = new HashMap<String, String>();
                  props.put(PropertyIds.OBJECT_TYPE_ID, "cmis:document");
               
                  props.put(PropertyIds.NAME, file.getName());

                  props.put(PropertyIds.CREATION_DATE,date.toString());
                  
                  props.put(PropertyIds.CREATED_BY  ,user);
                  
                  
                  cmisUtils.createDocument(target, name, bFile, file.getContentType());

                  val= "created ...";
                
           } catch (Exception e) {
   
        	  val=e.getMessage();
        	   
        	  
           }
    }
   val="folder wirh name "+folderName +" dons not exist";
 
}


@RequestMapping(value="/file",method=RequestMethod.GET)
public List<DocumentAlf> getFiles (@RequestParam("path") String path)
{
	
	
	Folder target=CmisUtilGedBNS.getFolderByPath(path);
	
	List<DocumentAlf> listFiles=CmisUtilGedBNS.getIdDocs(target);
	
	return listFiles;
}




}

