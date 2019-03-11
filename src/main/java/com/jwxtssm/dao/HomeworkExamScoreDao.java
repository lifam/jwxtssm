package com.jwxtssm.dao;

import com.jwxtssm.entity.HomeworkExamScore;
import org.springframework.stereotype.Repository;

@Repository
public interface HomeworkExamScoreDao {
	int addHomeworkExamScore(HomeworkExamScore homeworkExamScore);
}
