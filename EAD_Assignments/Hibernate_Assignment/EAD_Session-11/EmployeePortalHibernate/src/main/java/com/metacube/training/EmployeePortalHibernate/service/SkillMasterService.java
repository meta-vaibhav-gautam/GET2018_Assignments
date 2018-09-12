package com.metacube.training.EmployeePortalHibernate.service;

import java.util.List;

import com.metacube.training.EmployeePortalHibernate.model.SkillMaster;

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
