package com.nt.service;

import java.util.List;

import com.nt.dto.ProjectDto;
import com.nt.entity.Project;

public interface ProjectService {
	public String registerProject(ProjectDto dto);
    public Object fetchProjectById(int id);
    public String modifyProjectById(int id,int teamSize,double cost);
    public String RemoveProjectById(int id);
    public  List<ProjectDto> fecthProjectsByCostrange(double start,double end);
	}

