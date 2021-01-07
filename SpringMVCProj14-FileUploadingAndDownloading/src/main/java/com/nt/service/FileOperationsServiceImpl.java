package com.nt.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("fileService")
public class FileOperationsServiceImpl implements IFileOperationsService{
    @Autowired
    private ServletContext sc;
	
    @Override
	public List<String> getAllFiles() {
		String folderPath=sc.getInitParameter("StoreFolder");
		File file=new File(folderPath);
		 String files[]=file.list();
		 List<String> fileslist=new ArrayList();
		 for(String file1:files) {
			 fileslist.add(file1);
		 }
		return fileslist;
	}

}
