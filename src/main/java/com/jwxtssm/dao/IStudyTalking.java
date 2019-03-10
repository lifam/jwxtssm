package com.jwxtssm.dao;

import com.jwxtssm.pojo.mapper.StudyTalking;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudyTalking {
	int addStudyTalking(StudyTalking studyTalking);
}
