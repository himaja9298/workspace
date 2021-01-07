package com.nt.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.model.JobSeekerInfo;
import com.nt.service.IFileOperationsService;


@Controller
public class FileOperationsController {
	@Autowired
	private ServletContext sc;
	@Autowired
	private IFileOperationsService service;
	
	@GetMapping("/upload")
	public String showUploadForm(@ModelAttribute("jFrm") JobSeekerInfo info) {
        return "upload_file"; 
   }

	@PostMapping("/upload")
	public String processdForm(@ModelAttribute("jFrm") JobSeekerInfo info,Map<String,Object> map) throws IOException {
		List<String>fileslist=null;
		String storePath=sc.getInitParameter("StoreFolder");	
      File file=new File(storePath);
      if(!file.exists()) 
    	  file.mkdir();
      
      //get uploaded file names
      String resumeFileName=info.getResume().getOriginalFilename();
      String photoFileName=info.getPhoto().getOriginalFilename();
      //get inputStreams of uploaded files
      InputStream resumeis=info.getResume().getInputStream();
      InputStream photois=info.getPhoto().getInputStream();
      //create outputStream 
      OutputStream resumeOs=new FileOutputStream(storePath+"/"+resumeFileName);
      OutputStream photoOs=new FileOutputStream(storePath+"/"+photoFileName);
      //copy properties from is to os
      IOUtils.copy(resumeis, resumeOs);
      IOUtils.copy(photois, photoOs);
	  map.put("resumeFileName",resumeFileName );
	  map.put("photoFileName",photoFileName);
	  fileslist=service.getAllFiles();
	  map.put("filesList",fileslist);
	  return "upload_success"; 
   }

	
	@GetMapping("/download")
	public String downlpadFiles(@RequestParam("filename")  String fileName,HttpServletResponse res) throws Exception {
		//path of the downloadable file
		String filePath=sc.getInitParameter("StoreFolder")+"/"+fileName;
	    File file=new File(filePath);
		String mimetype=sc.getMimeType(filePath);
		//set content of the file
		res.setContentType(mimetype);
		//set content length of file
		res.setContentLengthLong(file.length());
		//Give instructions to browser to make given file as downloadable file
		res.addHeader("Content-Disposition","attachment;fileName="+fileName);
		//create InputStream 
		InputStream is=new FileInputStream(filePath);
		//create OutputStream 
		OutputStream os=res.getOutputStream();
		//copy files from is to os
		IOUtils.copy(is, os);
		return null;
	}
	
}
