package com.nt.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nt.entity.Project;
@Repository("pdao")
public class ProjectDAOImpl implements ProjectDAO {
	private static final String HQL_GET_PROJECT_By_COST_Range="FROM com.nt.entity.Project WHERE cost>=:min And cost<=:max"; 
	@Autowired
	private HibernateTemplate ht;
	
	@Override
	public Integer insert(Project entity) {
	 Integer val=0;
	 //use hibernateTemplate
	 val=(Integer) ht.save(entity);
     return val;
	}

	@Override
	public Project getProjectById(int id) {
		Project proj=null;
		//get project
		proj=ht.get(Project.class, id);
		return proj;
	}

	@Override
	public boolean updateObjectById(int id, int teamSize, double cost) {
    boolean flag=false;
    Project proj=null;
    proj=ht.get(Project.class, id);
    if(proj!=null) {
    	proj.setTeamSize(teamSize);
    	proj.setCost(cost);
    	ht.update(proj);
    	flag=true;
    	}
    return flag;
	}

	@Override
	public boolean deleteProjectById(int id) {
		Project proj=null;
		boolean flag=false;
		//get project object
		proj=ht.get(Project.class, id);
		if(proj!=null) {
		  ht.delete(proj);
		  flag=true;
		}
		return flag;
	}

	@Override
	public List<Project> getProjectByRange(double start, double end) {
		List<Project> list=null;
		list=(List<Project>)ht.findByNamedParam(HQL_GET_PROJECT_By_COST_Range, new String[] {"min","max"}, new Object[]{start,end});
		return list;
	
	}

	
}
