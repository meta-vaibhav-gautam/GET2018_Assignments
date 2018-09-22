package com.metacube.training.EmployeePortalHibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metacube.training.EmployeePortalHibernate.model.Project;

public interface ProjectRepository<P> extends JpaRepository<Project, Long> {

}
