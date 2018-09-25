package com.metacube.training.service;

import com.metacube.training.model.UserRoles;

public interface UserRolesService {

	UserRoles getUserRoleByUserName(String userName);

	boolean deleteUserRole(String userName);

	boolean updateUserRole(UserRoles userRoles);

	boolean createUserRoles(UserRoles userRoles);
	
}
