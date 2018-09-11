package com.metacube.training.EmployeePortalSpringBoot.service;

import java.util.List;

import com.metacube.training.EmployeePortalSpringBoot.model.JobTitleMaster;

/**
 * interface for service job_title_master
 * created on September 07, 2018
 */
public interface JobTitleMasterService {
	JobTitleMaster getJobTitleMaterById(int id);

	List<JobTitleMaster> getAllJobTitleMaster();

	boolean createJobTitleMaster(JobTitleMaster jobTitleMaster);
}
