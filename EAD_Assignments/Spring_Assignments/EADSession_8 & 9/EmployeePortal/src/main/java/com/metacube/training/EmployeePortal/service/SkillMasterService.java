package com.metacube.training.EmployeePortal.service;

import java.util.List;

import com.metacube.training.EmployeePortal.model.SkillMaster;

/**
 * service interface for SkillMaster
 * created oN September 07, 2018
 */
public interface SkillMasterService {
	
	SkillMaster getSkillById(int id);

	List<SkillMaster> getAllSkills();

	boolean deleteSkill(int id);

	boolean updateSkill(SkillMaster skillMaster);

	boolean createSkill(SkillMaster skillMaster);

}
