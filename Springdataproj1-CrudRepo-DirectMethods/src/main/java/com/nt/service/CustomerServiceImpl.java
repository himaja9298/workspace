package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dto.CustomerDTO;
import com.nt.entity.Customer;
import com.nt.repo.CustomerRepo;

@Service("custService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo custRepo;

	@Override
	public String registerCustomer(CustomerDTO dto) {
		Customer entity = null;
		// convert dto to entity
		entity = new Customer();
		BeanUtils.copyProperties(dto, entity);
		// use custRepo
		entity = custRepo.save(entity);
		return entity != null ? "Object saved with id" + entity.getCno() : "Object not saved";
	}

	@Override
	public String registerGroupCustomers(List<CustomerDTO> listdto) {
		String id = new String();
		List<Customer> listentities = new ArrayList();
		List<Customer> listentities1 = new ArrayList();
		listdto.forEach(dto -> {
			Customer entity = new Customer();
			BeanUtils.copyProperties(dto, entity);
			listentities.add(entity);
		});
		// use custRepo
		listentities1 = (List<Customer>) custRepo.saveAll(listentities);
		
		  for(Customer c:listentities1) { id=id+","+c.getCno(); }
		 
		// id=listentities.stream().map(e->e.getCno()).collect(Collectors.toList()).toString();
		return listentities1!=null ? "Customers registered with ids:" + id : "Customers not registered";

	}

	@Override
	public String removeCustomerById(int id) {
		boolean flag = false;
		flag = custRepo.existsById(id);
		// use custRepo
		if (flag)
			custRepo.deleteById(id);
		return flag ? "Customer deleted" : "Customer not exist";
	}

	@Override
	public String removeGivenCustomers(Iterable<CustomerDTO> listdto) {
		Iterable<Customer> listentities = new ArrayList();
		listentities.forEach(dto -> {
			Customer entity = new Customer();
			BeanUtils.copyProperties(dto, entity);
			((List<Customer>) listentities).add(entity);
		});
		// use custRepo
		custRepo.deleteAll(listentities);
		return "Bulk records deleted";
	}

	@Override
	public Iterable<CustomerDTO> fetchAllCustomers() {
		Iterable<CustomerDTO> listdto = new ArrayList();
		Iterable<Customer> listentites = null;
		// use custRepo
		listentites = custRepo.findAll();
		listentites.forEach(entity -> {
			CustomerDTO dto = new CustomerDTO();
			BeanUtils.copyProperties(entity, dto);
			((List<CustomerDTO>) listdto).add(dto);
		});
		return listdto;
	}

	@Override
	public long CountOfCustomers() {
		long count;
		// use custRepo
		count = custRepo.count();
		return count;
	}

	@Override
	public Optional fetchCustomerById(int id) {
		Optional<Customer>opt;
		Customer cust=null;
		Optional<CustomerDTO> dto=null;
		//use repo
		opt=custRepo.findById(id);
		if(opt.isPresent()) {
		 cust=opt.get();
		dto=Optional.of(new CustomerDTO());
		BeanUtils.copyProperties(cust,dto.get() );
		}
		
		return dto;
	}

	/*@Override
	public Iterable<Customer> fetchAllCustomersById(Iterable<Integer> ids) {
      Iterable<CustomerDTO>listdto=new ArrayList();
      Iterable<Customer> listentities=null;
	  listentities.forEach(entity->{
		CustomerDTO dto=new CustomerDTO();
		BeanUtils.copyProperties(dto,entity);
		((List<Customer>) listentities).add(entity);
	});
	//use custRepo
	custRepo.findAllById(ids);
	return listentities;
	}*/
		
}
