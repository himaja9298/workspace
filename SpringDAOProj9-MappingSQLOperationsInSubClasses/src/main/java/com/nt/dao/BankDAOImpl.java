package com.nt.dao;

import java.sql.ResultSet;

import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.object.MappingSqlQuery;
import org.springframework.jdbc.object.SqlUpdate;
import org.springframework.stereotype.Repository;

import com.nt.bo.BankAccountBO;

@Repository("BankDao")
public class BankDAOImpl implements IBankDAO {
	private static final String GET_DETAILS_WITHIN_BALANCE="SELECT actno,cname,balamnt FROM bankdetails WHERE balamnt>=? AND balamnt<=?";
	private static final String GET_DETAILS_BY_ACTNO="SELECT actno,cname,balamnt FROM bankdetails WHERE actno=?"; 
	private static final String UPDTE_BAL_BY_BONUS="UPDATE bankdetails SET balamnt=balamnt+? Where balamnt<?";
	
	private DataSource ds;
   	BankSelectorBySalRange multiSelector;
   	BankDetailsByAccountnoSelector singleSelector;
   	BankAmntUpdator updator;
	
   	
   	//1-param constructor
   	public BankDAOImpl(DataSource ds) {
   		System.out.println("BankDAOImpl.BankDAOImpl()");
		this.ds = ds;
		multiSelector=new BankSelectorBySalRange(ds,GET_DETAILS_WITHIN_BALANCE);
		singleSelector=new BankDetailsByAccountnoSelector(ds,GET_DETAILS_BY_ACTNO);
	    updator=new BankAmntUpdator(ds,UPDTE_BAL_BY_BONUS);
   	}
    
    
  //multiple record select operation
   	@Override
	public List<BankAccountBO> getBankAccountsByBalanceRange(float start, float end) {
		List<BankAccountBO> listbo=multiSelector.execute(start,end);
		return listbo;
	}
    private static class BankSelectorBySalRange extends MappingSqlQuery<BankAccountBO>{
        //2-param constructor
    	public BankSelectorBySalRange(DataSource ds,String query) {
    		super(ds,query);//gives ds,query to super class
     		System.out.println("BankDAOImpl.BankSelectorBySalRange.BankSelectorBySalRange()");
    		//declaring parameters with JDBC type
    		super.declareParameter(new SqlParameter(Types.FLOAT));
    		super.declareParameter(new SqlParameter(Types.FLOAT));
    		//makes super class query compile
    		super.compile();
    	}
    	
		@Override
		public  BankAccountBO mapRow(ResultSet rs, int rowNum) throws SQLException {
		System.out.println("BankDAOImpl.BankSelectorBySalRange.mapRow()");
			//convert rs to bo
			BankAccountBO bo=new BankAccountBO();
			bo.setActno(rs.getDouble(1));
			bo.setCname(rs.getString(2));
			bo.setBalamnt(rs.getFloat(3));
			return bo;
		}
    }
    
    //single record select operation
    @Override
	public BankAccountBO getDetailsByAccountno(double actno) {
		//use singleSelctor
    	BankAccountBO bo= singleSelector.findObject(actno);
		return bo;
	}
    
    private static class BankDetailsByAccountnoSelector extends MappingSqlQuery<BankAccountBO>{

    	public BankDetailsByAccountnoSelector(DataSource ds,String query) {
    		super(ds,query);
    		super.declareParameter(new SqlParameter(Types.DOUBLE));
    		super.compile();
    	}
    	
		@Override
		protected BankAccountBO mapRow(ResultSet rs, int rowNum) throws SQLException {
			BankAccountBO bo=new BankAccountBO();
			bo.setActno(rs.getDouble(1));
			bo.setCname(rs.getString(2));
			bo.setBalamnt(rs.getFloat(3));
			return bo;
		}
    	
    }
    
	
    
    //update operation 
    @Override
	public int UpdateBalmntWithBonus(float bonus,float maxBalance) {
		int count=0;
		//use updator
		count=updator.update(bonus,maxBalance);
		return count;
	}
	
	private static class BankAmntUpdator extends SqlUpdate{
		public BankAmntUpdator(DataSource ds,String query) {
			super(ds,query);
			super.declareParameter(new SqlParameter(Types.FLOAT));
			super.declareParameter(new SqlParameter(Types.FLOAT));
		    super.compile();
		}//constructor
	 }//inner class
	
    
}//class

	