package com.nt.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;
import com.nt.dto.StudentDTO;

@Component("pdfView")
public class StudentPdfView  extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document document, PdfWriter writer, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
	    //create paragraph
		Paragraph para=new Paragraph("StudentDetails Pdf",new Font(Font.HELVETICA,20,Font.BOLDITALIC));
	    document.newPage();
		document.add(para);
	    List<StudentDTO>listdto=(List<StudentDTO>) map.get("StudentSList");
		//create table
		Table table=new Table(3,listdto.size()); 
			//add columns
			table.addCell("Sno");table.addCell("Sname");table.addCell("Sadd");
			for(StudentDTO dto:listdto) {
				table.addCell(String.valueOf(dto.getSno()));	
				table.addCell(dto.getSname());
				table.addCell(dto.getSadd());
		    }
	       document.add(table);
	   
	}

	

	
	

}
