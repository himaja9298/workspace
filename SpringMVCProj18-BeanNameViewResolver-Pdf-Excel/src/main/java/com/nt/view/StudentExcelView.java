package com.nt.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.nt.dto.StudentDTO;

@Component("excelView")
public class StudentExcelView  extends AbstractXlsView{

	@Override
	protected void buildExcelDocument(Map<String, Object> map, Workbook workbook, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		List<StudentDTO> studentdto=(List<StudentDTO>) map.get("StudentSList");
		Sheet sheet=workbook.createSheet("Student Report");
		int i=0;
	
		for(StudentDTO dto:studentdto) {
			Row row=sheet.createRow(i);
			
			row.createCell(0).setCellValue(dto.getSno());
			row.createCell(1).setCellValue(dto.getSname());
			row.createCell(2).setCellValue(dto.getSadd());
			i++;
		}//for
		
	}//method

}//class
