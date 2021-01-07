package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nt.bo.EmployeeBO;
@Repository("empDao")
public class EmployeeDAOImpl implements EmployeeDAO {
	public static final String GET_EMP_QUERY= "SELECT ENO,ENAME,SALARY,DESG,DOB,DOJ FROM EMPLOYEE WHERE DESG IN (?,?,?) ORDER BY DESG";
	@Autowired
	private DataSource ds;
    
   	@Override
		public List<EmployeeBO> getEmployeeDetails(String desg1, String desg2, String desg3)throws Exception {
			Connection con=null;
		    PreparedStatement ps=null;
		    ResultSet rs=null;
		    List<EmployeeBO> listbo=null;
		    EmployeeBO bo=null;
			try {
			con=ds.getConnection();
			ps=con.prepareStatement(GET_EMP_QUERY);
			ps.setString(1, desg1);
			ps.setString(2, desg2);
			ps.setString(3, desg3);
			rs=ps.executeQuery();
			listbo=new ArrayList();
			
			  while(rs.next()) {
			//copy each record of ResultSet  obj to BO object
				  bo=new EmployeeBO();
				  bo.setEno(rs.getInt(1));
				  bo.setEname(rs.getString(2));
				  bo.setSal( rs.getFloat(3));
				  bo.setDesg(rs.getString(4));
				  bo.setDob(rs.getDate(5));
				  bo.setDoj(rs.getDate(6));
				  if(bo!=null) 
				 //add each object of bo to listbo
				  listbo.add(bo);
				  }//while
			}//try
			catch(SQLException se) {
				se.printStackTrace();
				throw se; //exception rethrowing
			}
			catch(Exception e) {
				e.printStackTrace();
				throw e;
			}
			//close jdbc objects
			finally {
				try {
					if(rs!=null)
						rs.close();
				}
				catch(SQLException se) {
					se.printStackTrace();
					throw se;
				}
				try {
					if(ps!=null)
						ps.close();
				}
				catch(SQLException se) {
					se.printStackTrace();
					throw se;
				}
				try {
					if(con!=null)
						con.close();
				}
				catch(SQLException se) {
					se.printStackTrace();
					throw se;
				}
			}//finally
			return listbo;	
	
			
			
		}

}
