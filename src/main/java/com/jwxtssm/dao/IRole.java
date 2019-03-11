package com.jwxtssm.dao;

import com.jwxtssm.pojo.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface IRole {
	int addRole(Role role);
}
