package com.jwxtssm.dao;

import com.jwxtssm.entity.College;
import org.springframework.stereotype.Repository;

@Repository
public interface CollegeDao {
	int addCollege(College college);
	College queryById(int collegeId);
	College queryByName(String name);
	College[] queryAll();
}
