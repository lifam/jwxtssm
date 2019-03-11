package com.jwxtssm.dao;

import com.jwxtssm.entity.StudyTalkingHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyTalkingHistoryDao {
	int addStudyTalkingHistory(StudyTalkingHistory studyTalkingHistory);
}
