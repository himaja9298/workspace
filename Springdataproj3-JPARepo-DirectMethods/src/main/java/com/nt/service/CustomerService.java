package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.nt.dto.CustomerDTO;
import com.nt.entity.Customer;
public interface CustomerService {

	public List<CustomerDTO> fecthAllCustomersDetails(CustomerDTO dto);
	public String deleteGivenCustomes(Iterable<Customer> custentities);
	public String deleteAllCustomes();
}
