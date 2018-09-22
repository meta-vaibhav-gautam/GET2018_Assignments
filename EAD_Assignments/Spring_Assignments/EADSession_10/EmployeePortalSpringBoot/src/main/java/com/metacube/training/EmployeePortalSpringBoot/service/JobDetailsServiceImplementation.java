package com.metacube.training.EmployeePortalSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeePortalSpringBoot.dao.JobDetailsDAO;
import com.metacube.training.EmployeePortalSpringBoot.model.JobDetails;

@Service
public class JobDetailsServiceImplementation implements JobDetailsService{

	@Autowired
	JobDetailsDAO jobDetailsDAO;
	
	@Override
	public JobDetails getJobDetailsById(int id) {
		return jobDetailsDAO.getJobDetailsById(id);
	}

	@Override
	public List<JobDetails> getAllJobDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteJobDetails(JobDetails jobDetails) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateJobDetails(JobDetails jobDetails) {
		return jobDetailsDAO.updateJobDetails(jobDetails);
	}

	@Override
	public boolean createJobDetails(JobDetails jobDetails) {
		return jobDetailsDAO.createJobDetails(jobDetails);
	}
	
	@Override
	public JobDetails getJobDetailsOfEmployee(String employeeCode) {
		return jobDetailsDAO.getJobDetailsOfEmployee(employeeCode);
	}

}
