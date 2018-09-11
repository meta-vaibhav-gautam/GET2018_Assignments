package com.metacube.training.EmployeePortal.dao;

import java.util.List;

import com.metacube.training.EmployeePortal.model.SkillMaster;

/**
 * DAO interface for operations on skill_master
 * created on September 07, 2019
 */
public interface SkillMasterDAO {
	
	SkillMaster getSkillById(int id);

	List<SkillMaster> getAllSkills();

	boolean deleteSkill(SkillMaster skillMaster);

	boolean updateSkill(SkillMaster skillMaster);

	boolean createSkill(SkillMaster skillMaster);
	
}
