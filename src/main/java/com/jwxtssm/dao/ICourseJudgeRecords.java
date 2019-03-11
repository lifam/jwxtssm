package com.jwxtssm.dao;

import com.jwxtssm.pojo.CourseJugdeRecords;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseJudgeRecords {
	int addCourseJudgeRecords(CourseJugdeRecords courseJugdeRecords);
}
