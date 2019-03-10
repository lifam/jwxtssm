package com.jwxtssm.dao;

import com.jwxtssm.pojo.mapper.College;
import org.springframework.stereotype.Repository;

@Repository
public interface ICollege {
	int addCollege(College college);
}
