package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import com.nt.bo.CoronaBO;

public class CoronaDAOImpl implements CoronaDAO {
	public static final String GET_CORONA_PAT_DETAILS_QUERY= "SELECT PATNO,PATNAME,PATADD,PATSTAGE,PATBILL FROM CORONA WHERE PATADD IN (?,?,?) ORDER BY PATADD";
	private DataSource ds;
    
   public CoronaDAOImpl(DataSource ds) {
		System.out.println("CoronaDAOImpl:1-param constructor");
		this.ds = ds;
	}
		@Override
		public List<CoronaBO> getCoronaPatDetails(String add1, String add2, String add3)throws Exception {
			Connection con=null;
		    PreparedStatement ps=null;
		    ResultSet rs=null;
		    List<CoronaBO> listbo=null;
		    CoronaBO bo=null;
			try {
			con=ds.getConnection();
			ps=con.prepareStatement(GET_CORONA_PAT_DETAILS_QUERY);
			ps.setString(1, add1);
			ps.setString(2, add2);
			ps.setString(3, add3);
			rs=ps.executeQuery();
			listbo=new ArrayList();
			
			  while(rs.next()) {
			//copy each record of ResultSet  obj to BO object
				  bo=new CoronaBO();
				  bo.setPatno(rs.getInt(1));
				  bo.setPatname(rs.getString(2));
				  bo.setPatadd( rs.getString(3));
				  bo.setPatstage(rs.getInt(4));
				  bo.setPatbill(rs.getFloat(5));
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
