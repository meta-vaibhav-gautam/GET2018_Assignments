package com.metacube.training.EmployeePortalHibernate.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.metacube.training.EmployeePortalHibernate.model.SkillMaster;

/**
 * class containing implementations of SkillMasterDAO interface
 * created on September 07, 2018
 */
@Repository
@Transactional
public class SkillMasterDAOImplementation implements SkillMasterDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	private final String FIND_SKILL = "FROM SkillMaster where skill_id= :skillId";
	private final String DELETE_SKILL = "DELETE FROM SkillMaster where skill_id = :skillId";
	private final String UPDATE_SKILL = "UPDATE SkillMaster set skill_name = :skillName where skill_id = :skillId";
	private final String GET_ALL = "FROM SkillMaster ";

	@Override
	public SkillMaster getSkillById(int id) {
		TypedQuery<SkillMaster> query = sessionFactory.getCurrentSession().createQuery(FIND_SKILL);
		query.setParameter("skillId", id);
		return query.getSingleResult();
	}
	@Override
	public List<SkillMaster> getAllSkills() {
		TypedQuery<SkillMaster> query = sessionFactory.getCurrentSession().createQuery(GET_ALL);
		return query.getResultList();
	}
	@Override
	public boolean deleteSkill(SkillMaster skillMaster) {
		TypedQuery<SkillMaster> query = sessionFactory.getCurrentSession().createQuery(DELETE_SKILL);
		query.setParameter("skillId", skillMaster.getSkillId());
		return (query.executeUpdate()>0);
	}
	@Override
	public boolean updateSkill(SkillMaster skillMaster) {
		TypedQuery<SkillMaster> query = sessionFactory.getCurrentSession().createQuery(UPDATE_SKILL);
		query.setParameter("skillName", skillMaster.getSkillName());
		query.setParameter("skillId", skillMaster.getSkillId());
		return (query.executeUpdate()>0);
	}
	@Override
	public boolean createSkill(SkillMaster skillMaster) {
		return ((int)sessionFactory.getCurrentSession().save(skillMaster)>0);
	}
	
	
}
