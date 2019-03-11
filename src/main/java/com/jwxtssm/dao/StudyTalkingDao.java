package com.jwxtssm.dao;

import com.jwxtssm.entity.StudyTalking;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyTalkingDao {
	int addStudyTalking(StudyTalking studyTalking);
}
