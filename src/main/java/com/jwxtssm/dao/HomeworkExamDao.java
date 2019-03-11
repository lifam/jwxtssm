package com.jwxtssm.dao;

import com.jwxtssm.entity.HomeworkExam;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeworkExamDao {
	int addHomeworkExam(HomeworkExam homeworkExam);
}
