package com.jwxtssm.dao;

import com.jwxtssm.pojo.mapper.HomeworkExamScore;
import org.springframework.stereotype.Repository;

@Repository
public interface IHomeworkExamScore {
	int addHomeworkExamScore(HomeworkExamScore homeworkExamScore);
}
