package com.jwxtssm.dao;

import com.jwxtssm.entity.CourseJudgeRecords;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseJudgeRecordsDao {
	int addCourseJudgeRecords(CourseJudgeRecords courseJugdeRecords);
}
