package com.jwxtssm.dao;

import com.jwxtssm.pojo.mapper.StudyTalkingHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudyTalkingHistory {
	int addStudyTalkingHistory(StudyTalkingHistory studyTalkingHistory);
}
