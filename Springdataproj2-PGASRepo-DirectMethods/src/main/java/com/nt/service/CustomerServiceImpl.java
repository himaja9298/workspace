package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.dto.CustomerDTO;
import com.nt.entity.Customer;
import com.nt.repo.CustomerRepo;

@Service("custService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo custRepo;

	@Override
	public Iterable<CustomerDTO> fetchAllSortbyProperty(boolean asc, String property) {
		List<CustomerDTO> listdto=new ArrayList();
		Iterable<Customer> listentities=null;
		//use custRepo
		listentities=custRepo.findAll(Sort.by(asc?Direction.ASC:Direction.DESC,property));
		listentities.forEach(entity->{
			CustomerDTO dto=new CustomerDTO();
			BeanUtils.copyProperties(entity,dto);
			 listdto.add(dto);
		});
		
		return listdto;
	}

	@Override
	public Iterable<CustomerDTO> fetchAllSortbyProperty(boolean asc, String... properties) {
		List<CustomerDTO> listdto=new ArrayList();
		Iterable<Customer> listentities=null;
		//use custRepo
		listentities=custRepo.findAll(Sort.by(asc?Direction.ASC:Direction.DESC,properties));
		listentities.forEach(entity->{
			CustomerDTO dto=new CustomerDTO();

			BeanUtils.copyProperties(entity,dto);
			listdto.add(dto);
		});
		
		return listdto;
	}

	@Override
	public List<CustomerDTO> fecthDatByPageNoAndSize(int pageno, int pagesize) {
		List<CustomerDTO> listdto=new ArrayList();
		Page<Customer> listentities=null;
		PageRequest pagable=PageRequest.of(pageno, pagesize);
		//use custRepo
		listentities=custRepo.findAll(pagable);
		listentities.forEach(entity->{
			CustomerDTO dto=new CustomerDTO();
			BeanUtils.copyProperties(entity,dto);
			 listdto.add(dto);
		});
		return listdto;	
		}

	@Override
	public List<CustomerDTO> fecthDatByPageNoAndSizeWithSort(int pageno, int pagesize, boolean asc, String... properties) {
		List<CustomerDTO> listdto=new ArrayList();
		Page<Customer> listentities=null;
		PageRequest pagable=PageRequest.of(pageno, pagesize,Sort.by(asc?Direction.ASC:Direction.DESC , properties));
		//use custRepo
				listentities=custRepo.findAll(pagable);
				listentities.forEach(entity->{
					CustomerDTO dto=new CustomerDTO();
					BeanUtils.copyProperties(entity,dto);
					 listdto.add(dto);
				});
				return listdto;	
				}

	@Override
	public void fetchRecordsByPagination(int pagesize) {
       long recordsCount=0;
       long pageCount=0;
       Pageable pageable=null;
       Page<Customer>page=null;
       recordsCount=custRepo.count();
	   pageCount=pageCount%2==0?(recordsCount/pagesize):(recordsCount/pagesize)+1;
	   for(int i=0;i<pageCount;i++) {
		   pageable=PageRequest.of(i,pagesize);
		   //pageable=PageRequest.of(i,pagesize,Direction.ASC,"cname");
		   page=custRepo.findAll(pageable);
		   page.getContent().forEach(System.out::println);
		   System.out.println("page "+i+" of  "+page.getTotalPages());
	   }//for
	}//method

	
 }//class
	
