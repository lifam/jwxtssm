package com.jwxtssm.dao;

import com.jwxtssm.pojo.Major;
import org.springframework.stereotype.Repository;

@Repository
public interface IMajor {
	int addMajor(Major major);
}
