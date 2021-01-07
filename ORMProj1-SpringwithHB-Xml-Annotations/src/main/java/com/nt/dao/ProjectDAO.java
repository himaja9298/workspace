package com.nt.dao;

import java.util.List;

import com.nt.entity.Project;

public interface ProjectDAO {
	public Integer insert(Project entity);
    public Project getProjectById(int id);
    public boolean updateObjectById(int id,int teamSize,double cost);
    public boolean deleteProjectById(int id);
    public List<Project> getProjectByRange(double start,double end);
}