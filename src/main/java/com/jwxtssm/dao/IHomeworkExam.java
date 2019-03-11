package com.jwxtssm.dao;

import com.jwxtssm.pojo.HomeworkExam;
import org.springframework.stereotype.Repository;

@Repository
public interface IHomeworkExam {
	int addHomeworkExam(HomeworkExam homeworkExam);
}
