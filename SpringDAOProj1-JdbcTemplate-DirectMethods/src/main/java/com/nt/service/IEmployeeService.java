package com.nt.service;

import java.util.List;
import java.util.Map;

public interface IEmployeeService {
	public int fetchEmpCount();
    public String fetchEnameByNo(int eno);
    public Map<String,Object> fetchEmpDetailsByNo(int eno);
    public List<Map<String,Object>> fetchEmpDetailsByDesgs(String desg1,String desg2);
    public String insertEmployee(String name,String desg,float sal,int no);
    public String addBonusToEmployeeByDesg(String desg,float bonus);
    public String deleteEmployeeByDesg(String desg);
}
