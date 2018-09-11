package com.metacube.training.EmployeePortalSpringBoot.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.metacube.training.EmployeePortalSpringBoot.mapper.SkillMasterMapper;
import com.metacube.training.EmployeePortalSpringBoot.model.SkillMaster;

/**
 * class containing implementations of SkillMasterDAO interface
 * created on September 07, 2018
 */
@Repository
public class SkillMasterDAOImplementation implements SkillMasterDAO {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public SkillMasterDAOImplementation(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	private final String SQL_FIND_SKILL = "SELECT skill_id, skill_name FROM skill_master where skill_id=?";
	private final String SQL_DELETE_SKILL = "DELETE FROM skill_master where skill_id = ?";
	private final String SQL_UPDATE_SKILL = "UPDATE skill_master set skill_name = ? where skill_id = ?";
	private final String SQL_GET_ALL = "SELECT skill_id, skill_name FROM skill_master ";
	private final String SQL_INSERT_SKILL = "insert into skill_master (skill_name) values(?)";

	@Override
	public SkillMaster getSkillById(int id) {
		return jdbcTemplate.queryForObject(SQL_FIND_SKILL, new Object[] {id}, new SkillMasterMapper());
	}
	@Override
	public List<SkillMaster> getAllSkills() {
		return jdbcTemplate.query(SQL_GET_ALL,new SkillMasterMapper());
	}
	@Override
	public boolean deleteSkill(SkillMaster skillMaster) {
		return jdbcTemplate.update(SQL_DELETE_SKILL,skillMaster.getSkillId())>0;
	}
	@Override
	public boolean updateSkill(SkillMaster skillMaster) {
		return jdbcTemplate.update(SQL_UPDATE_SKILL,skillMaster.getSkillName(),skillMaster.getSkillId())>0;
	}
	@Override
	public boolean createSkill(SkillMaster skillMaster) {
		return jdbcTemplate.update(SQL_INSERT_SKILL,skillMaster.getSkillName())>0;
	}
	
	
}
