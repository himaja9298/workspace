package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.dto.CustomerDTO;
import com.nt.entity.Customer;

public interface CustomerService {
	public String registerCustomer(CustomerDTO dto);
	public String registerGroupCustomers(List<CustomerDTO> listdto);
	public String removeCustomerById(int id);
	public String removeGivenCustomers(Iterable <CustomerDTO>listdto);
	public Iterable<CustomerDTO> fetchAllCustomers();
	public long CountOfCustomers();
	//public Iterable<Customer> fetchAllCustomersById(Iterable<Integer> ids);
	//public CustomerDTO fetchCustomerById(int id);
	public Optional<CustomerDTO> fetchCustomerById(int id);
}
