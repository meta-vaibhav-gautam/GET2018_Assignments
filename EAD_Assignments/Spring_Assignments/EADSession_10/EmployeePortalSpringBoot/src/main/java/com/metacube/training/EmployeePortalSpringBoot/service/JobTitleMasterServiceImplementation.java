package com.metacube.training.EmployeePortalSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeePortalSpringBoot.dao.JobTitleMasterDAO;
import com.metacube.training.EmployeePortalSpringBoot.model.JobTitleMaster;

/**
 * class containing method implementation of interface
 * cretaed on September 07, 2018
 */
@Service
public class JobTitleMasterServiceImplementation implements JobTitleMasterService {

	@Autowired
	JobTitleMasterDAO jobTitleMaterDAO;
	
	@Override
	public JobTitleMaster getJobTitleMaterById(int id) {
		return jobTitleMaterDAO.getJobTitleMasterById(id);
	}

	@Override
	public List<JobTitleMaster> getAllJobTitleMaster() {
		return jobTitleMaterDAO.getAllJobTitleMaster();
	}

	@Override
	public boolean createJobTitleMaster(JobTitleMaster jobTitleMaster) {
		return jobTitleMaterDAO.createJobTitleMaster(jobTitleMaster);
	}
	
	
	
}
