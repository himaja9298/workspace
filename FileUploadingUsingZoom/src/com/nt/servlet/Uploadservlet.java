package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javazoom.upload.MultipartFormDataRequest;
import javazoom.upload.UploadBean;
import javazoom.upload.UploadFile;

public class Uploadservlet extends HttpServlet {
  public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
	  PrintWriter pw=null;
	  MultipartFormDataRequest nreq=null;
	  UploadBean bean=null;
	  Hashtable ht=null;
	  Enumeration e=null;
	  //general settings
      pw=res.getWriter();
      res.setContentType("text/html");
      try {
    	  //prepare special request object
    	  nreq=new MultipartFormDataRequest(req);
    	  //specify file uploading settings
    	  bean=new UploadBean();
    	  bean.setFolderstore("D:\\store");
    	  bean.setOverwrite(false);
    	  bean.setMaxfiles(10);
    	  bean.setFilesizelimit(20*1024);
    	  //complete file uploading
    	  bean.store(nreq);
    	  //display the names of uploaded files
    	  pw.println("<h1>The Uploaded files are</h1>");
    	  ht=nreq.getFiles();
    	  e=ht.elements();
    	  while(e.hasMoreElements()) {
    		  UploadFile file=(UploadFile)e.nextElement();
    		  pw.println("<br>"+file.getFileName()+" "+file.getFileSize());
    	  }//while
    		  
     }//try
     catch(Exception se) {
    	 pw.println("<h2 style='color:red;text-align:center'>Problem In Uploading---><h2>");
    	 se.printStackTrace();
     }
  }//doPost
  public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException {
     doPost(req,res);
  }//doPost
}//class
