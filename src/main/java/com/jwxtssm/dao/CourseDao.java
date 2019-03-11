package com.jwxtssm.dao;

import com.jwxtssm.entity.Course;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseDao {
	int addCourse(Course course);
}
