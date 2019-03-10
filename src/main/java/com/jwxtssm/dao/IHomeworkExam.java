package com.jwxtssm.dao;

import com.jwxtssm.pojo.mapper.HomeworkExam;
import org.springframework.stereotype.Repository;

@Repository
public interface IHomeworkExam {
	int addHomeworkExam(HomeworkExam homeworkExam);
}
