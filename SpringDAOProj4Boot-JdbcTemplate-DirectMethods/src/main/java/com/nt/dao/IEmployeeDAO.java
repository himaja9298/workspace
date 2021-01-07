package com.nt.dao;

import java.util.List;
import java.util.Map;

public interface IEmployeeDAO {
	
	public int getEmpCount();
    public String getEnameByNo(int eno);
    public Map<String,Object> getEmpDetailsByNo(int eno);
    public List<Map<String,Object>> getEmpDetailsByDesgs(String desg1,String desg2);
    public int insertEmployee(String name,String desg,float sal,int no);
    public int addBonusToEmployeeByDesg(String desg,float bonus);
    public int deleteEmployeeByDesg(String desg);
}
