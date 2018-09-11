package com.metacube.training.EmployeePortalSpringBoot.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.training.EmployeePortalSpringBoot.model.SkillMaster;

/**
 * class to map resultset values to object
 * created on September 07, 2018
 */
public class SkillMasterMapper implements RowMapper<SkillMaster>{

	@Override
	public SkillMaster mapRow(ResultSet rs, int rowNum) throws SQLException {
		SkillMaster skillMaster = new SkillMaster();
		skillMaster.setSkillId(rs.getInt("skill_id"));
		skillMaster.setSkillName(rs.getString("skill_name"));
		return skillMaster;
	}
	
}
