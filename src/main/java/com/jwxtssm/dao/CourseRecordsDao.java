package com.jwxtssm.dao;

import com.jwxtssm.entity.CourseRecords;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRecordsDao {
	int addCourseRecords(CourseRecords courseRecords);
}
