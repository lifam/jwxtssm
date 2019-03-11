package com.jwxtssm.dao;

import com.jwxtssm.pojo.CourseRecords;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRecords {
	int addCourseRecords(CourseRecords courseRecords);
}
