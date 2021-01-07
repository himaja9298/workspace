package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nt.dao.ProjectDAO;
import com.nt.dto.ProjectDto;
import com.nt.entity.Project;
@Service("pservice")
@Transactional
public class ProjectServiceImpl implements ProjectService {
    //get DAO class properties
	@Autowired
    private ProjectDAO dao;
	
    @Override
	public String registerProject(ProjectDto dto) {
		Project entity=null;
    	Integer val=0;
    	entity=new Project();
    	//convert DTO to BO/Entity
    	BeanUtils.copyProperties(dto, entity);
		//use dao
    	val=dao.insert(entity);
		
		return "Project is registered with the id:"+val;
	}

	@Override
	public Object fetchProjectById(int id) {
		Project proj=null;
		ProjectDto dto=null;
		//use dao
		proj=dao.getProjectById(id);
		//convert to dto
		dto=new ProjectDto();
		if(proj!=null) 
		   BeanUtils.copyProperties(proj,dto);
		   return proj!=null?dto:"record not found";
	}
	@Override
	public String modifyProjectById(int id, int teamSize, double cost) {
		Project proj=null;
		boolean flag=false;
		flag=dao.updateObjectById(id, teamSize, cost);
		return flag==true?"Record updated":"Record not updated";
	}

	@Override
	public String RemoveProjectById(int id) {
		Project proj=null;
		boolean flag=false;
		//use dao
		flag=dao.deleteProjectById(id);
		return flag==true?"Record deleted":"Record not deleted";
	}

	@Override
	public List<ProjectDto> fecthProjectsByCostrange(double start, double end) {
		List<Project> list=null;
		List<ProjectDto> listdto=new ArrayList();
		//use DAO
		list=dao.getProjectByRange(start,end);
	    list.forEach(proj->{
	    ProjectDto dto=new ProjectDto(); 
	      BeanUtils.copyProperties(proj,dto);
	      listdto.add(dto);
	    });
		return listdto;
	}

}
