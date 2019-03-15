package com.jwxtssm.dao;

import com.jwxtssm.entity.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao {
	int addRole(Role role);
	Role queryById(int roleId);
	Role[] queryByBasicId(int basicId);
}
