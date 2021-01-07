package com.nt.advice;

import java.io.FileWriter;
import java.time.LocalDate;

public class TestDriveAuditAspect {

	public void testdrive(String model,float price,String executive) throws Throwable {
		System.out.println("TestDriveAuditAspect.testdrive()");
		FileWriter writer=new FileWriter("E:/audit.txt");
		writer.write(model+"car has given for testdrive under the monitoring of "+executive+" on "+LocalDate.now());
		writer.flush();
		
	}
}
