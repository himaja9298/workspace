package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nt.dto.CustomerDTO;
import com.nt.entity.Customer;
public interface CustomerService {

	public Iterable<CustomerDTO> fetchAllSortbyProperty(boolean asc,String property);
	public Iterable<CustomerDTO> fetchAllSortbyProperty( boolean asc,String... properties);
    public List<CustomerDTO> fecthDatByPageNoAndSize(int pageno,int pagesize);
    public List<CustomerDTO> fecthDatByPageNoAndSizeWithSort(int pageno,int pagesize,boolean desc,String... properties);
	public void fetchRecordsByPagination(int pagesize);
}
