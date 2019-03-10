package com.jwxtssm.dao;

import com.jwxtssm.pojo.mapper.Course;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourse {
	int addCourse(Course course);
}
