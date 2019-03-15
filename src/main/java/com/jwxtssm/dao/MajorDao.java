package com.jwxtssm.dao;

import com.jwxtssm.entity.Major;
import org.springframework.stereotype.Repository;

@Repository
public interface MajorDao {
	int addMajor(Major major);
	Major queryById(int majorId);
	Major[] queryByName(String name);
	Major[] queryAll();
}
