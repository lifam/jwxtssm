package com.jwxtssm.dao;

import com.jwxtssm.BaseTest;
import com.jwxtssm.common.DefaultValues;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;

public class DataGenerate extends BaseTest {
	@Autowired
	AddressInfoDao iAddressInfo;
	@Autowired
	AttachDocDao iAttachDoc;
	@Autowired
	AuthInfoDao iAuthInfo;
	@Autowired
	BasicInfoDao iBasicInfo;
	@Autowired
	CollegeDao iCollege;
	@Autowired
	CourseDao iCourse;
	@Autowired
	CourseJudgeRecordsDao iCourseJudgeRecords;
	@Autowired
	CourseRecordsDao iCourseRecords;
	@Autowired
	DocCenterDao iDocCenter;
	@Autowired
	EduMessageDao iEduMessage;
	@Autowired
	HomeworkExamDao iHomeworkExam;
	@Autowired
	HomeworkExamScoreDao iHomeworkExamScore;
	@Autowired
	MajorDao iMajor;
	@Autowired
	OrgDao iOrg;
	@Autowired
	RoleDao iRole;
	@Autowired
	ScoreSumDao iScoreSum;
	@Autowired
	StudyTalkingDao iStudyTalking;
	@Autowired
	StudyTalkingHistoryDao iStudyTalkingHistory;
	@Autowired
	SystemMessageDao iSystemMessage;

	int STUDENT_NUM = 30000;
	int FELLOW_NUM = 3500;

	@Test
	public void generateBasicInfo() throws Exception {
		int basicId = DefaultValues.BASIC_ID;
		int headImg = DefaultValues.HEAD_IMG;
		int viceId;
		String name;
		String password;
		int sex;
		float height;
		float weight;
		Date birthInfo;
		String homeAddress;
		String formalId;
		String rewardInfo;
		String punishmentInfo;
		int infoTransparency;

		for (int i = 0; i < STUDENT_NUM + FELLOW_NUM; i++) {
			//生成学生基本信息
			if (i < STUDENT_NUM) {
				int studentIdBase = 15000000;
				viceId = studentIdBase + i;
				viceId += (i / ((STUDENT_NUM / 4))) * 1000000;
			} else {
				int fellowBase = 90000000;
				viceId = fellowBase + i;
			}

		}
	}
}
