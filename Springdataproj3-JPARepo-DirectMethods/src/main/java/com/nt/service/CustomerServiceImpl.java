package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.nt.dto.CustomerDTO;
import com.nt.entity.Customer;
import com.nt.repo.CustomerRepo;

@Service("custService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo custRepo;

	@Override
	public List<CustomerDTO> fecthAllCustomersDetails(CustomerDTO dto) {
		Customer entity=null;
		List<Customer> listentities=null;
		Example<Customer> example=null;
		entity=new Customer();
	    BeanUtils.copyProperties(dto, entity);
	    example=Example.of(entity);
		listentities=custRepo.findAll(example);
		List<CustomerDTO> listdto=new ArrayList();
		listentities.forEach(entity1->{
			CustomerDTO dto1=new CustomerDTO();
			BeanUtils.copyProperties(entity1, dto1);
			listdto.add(dto1);
			});
		return listdto;
	}

	@Override
	public String deleteGivenCustomes(Iterable<Customer> custentities) {
		boolean flag=false;
		
		//use custRepo
			if(custentities!=null) {
			    flag=true;
				custRepo.deleteAll(custentities);
	 }
	 return flag?"Records deleted":"Records not deleted";
    }

	@Override
	public String deleteAllCustomes() {
		boolean flag=false;
		//use custRepo
		if(custRepo.count()>=1) {
			custRepo.deleteAll();
			flag=true;
		}
		
		return flag?"All customers are deleted":"No customers found";
	}

}