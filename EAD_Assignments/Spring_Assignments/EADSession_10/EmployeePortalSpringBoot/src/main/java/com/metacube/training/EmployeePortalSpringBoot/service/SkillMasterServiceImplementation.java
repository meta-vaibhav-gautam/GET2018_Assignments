package com.metacube.training.EmployeePortalSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.training.EmployeePortalSpringBoot.dao.SkillMasterDAO;
import com.metacube.training.EmployeePortalSpringBoot.model.SkillMaster;

/**
 * class containing implementation of SkillMasterService interface
 * created on September 07, 2018
 */
@Service
public class SkillMasterServiceImplementation implements SkillMasterService{

	@Autowired
	private SkillMasterDAO skillMasterDAO;
	
	@Override
	public SkillMaster getSkillById(int id) {
		return skillMasterDAO.getSkillById(id) ;
	}

	@Override
	public List<SkillMaster> getAllSkills() {
		return skillMasterDAO.getAllSkills();
	}

	@Override
	public boolean deleteSkill(int id) {
		SkillMaster skillMaster = skillMasterDAO.getSkillById(id);
		return skillMasterDAO.deleteSkill(skillMaster);
	}

	@Override
	public boolean updateSkill(SkillMaster skillMaster) {
		return skillMasterDAO.updateSkill(skillMaster);
	}

	@Override
	public boolean createSkill(SkillMaster skillMaster) {
		return skillMasterDAO.createSkill(skillMaster);
	}

}
