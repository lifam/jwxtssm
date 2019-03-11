package com.jwxtssm.service;

import com.jwxtssm.common.DefaultPojo;
import com.jwxtssm.dao.*;
import org.springframework.stereotype.Service;

public class DatabaseInit {
	IAddressInfo iAddressInfo;
	IAttachDoc iAttachDoc;
	IAuthInfo iAuthInfo;
	IBasicInfo iBasicInfo;
	ICollege iCollege;
	ICourse iCourse;
	ICourseJudgeRecords iCourseJudgeRecords;
	ICourseRecords iCourseRecords;
	IDocCenter iDocCenter;
	IEduMessage iEduMessage;
	IHomeworkExam iHomeworkExam;
	IHomeworkExamScore iHomeworkExamScore;
	IMajor iMajor;
	IOrg iOrg;
	IRole iRole;
	IScoreSum iScoreSum;
	IStudyTalking iStudyTalking;
	IStudyTalkingHistory iStudyTalkingHistory;
	ISystemMessage iSystemMessage;

	public String init() {
		StringBuilder result = new StringBuilder();
		int count;

		result.append(DefaultPojo.DEFAULT_BASIC_INFO.toString());
		count = iBasicInfo.addBasicInfo(DefaultPojo.DEFAULT_BASIC_INFO);
		result.append("count = " + count + "\n\n");

		result.append(DefaultPojo.DEFAULT_ADDRESS_INFO.toString());
		count = iAddressInfo.addAddressInfo(DefaultPojo.DEFAULT_ADDRESS_INFO);
		result.append("count = " + count + "\n\n");

		result.append(DefaultPojo.DEFAULT_AUTH_INFO.toString());
		count = iAuthInfo.addAuthInfo(DefaultPojo.DEFAULT_AUTH_INFO);
		result.append("count = " + count + "\n\n");

		result.append(DefaultPojo.DEFAULT_COURSE);
		count = iCourse.addCourse(DefaultPojo.DEFAULT_COURSE);
		result.append("count = " + count + "\n\n");

		result.append(DefaultPojo.DEFAULT_COURSE_JUGDE_RECORDS);
		count = iCourseJudgeRecords.addCourseJudgeRecords(DefaultPojo.DEFAULT_COURSE_JUGDE_RECORDS);
		result.append("count = " + count + "\n\n");

		result.append(DefaultPojo.DEFAULT_COURSE_RECORDS);
		count = iCourseRecords.addCourseRecords(DefaultPojo.DEFAULT_COURSE_RECORDS);
		result.append("count = " + count + "\n\n");

		result.append(DefaultPojo.DEFAULT_HOMEWORK_EXAM);
		count = iHomeworkExam.addHomeworkExam(DefaultPojo.DEFAULT_HOMEWORK_EXAM);
		result.append("count = " + count + "\n\n");

		result.append(DefaultPojo.DEFAULT_HOMEWORK_EXAM_SCORE);
		count = iHomeworkExamScore.addHomeworkExamScore(DefaultPojo.DEFAULT_HOMEWORK_EXAM_SCORE);
		result.append("count = " + count + "\n\n");

		result.append(DefaultPojo.DEFAULT_COLLEGE);
		count = iCollege.addCollege(DefaultPojo.DEFAULT_COLLEGE);
		result.append("count = " + count + "\n\n");

		result.append(DefaultPojo.DEFAULT_MAJOR);
		count = iMajor.addMajor(DefaultPojo.DEFAULT_MAJOR);
		result.append("count = " + count + "\n\n");

		result.append(DefaultPojo.DEFAULT_ORG);
		count = iOrg.addOrg(DefaultPojo.DEFAULT_ORG);
		result.append("count = " + count + "\n\n");

		result.append(DefaultPojo.DEFAULT_ROLE);
		count = iRole.addRole(DefaultPojo.DEFAULT_ROLE);
		result.append("count = " + count + "\n\n");

		result.append(DefaultPojo.DEFAULT_SCORE_SUM);
		count = iScoreSum.addScoreSum(DefaultPojo.DEFAULT_SCORE_SUM);
		result.append("count = " + count + "\n\n");

		result.append(DefaultPojo.DEFAULT_SYSTEM_MESSAGE);
		count = iSystemMessage.addSystemMessage(DefaultPojo.DEFAULT_SYSTEM_MESSAGE);
		result.append("count = " + count + "\n\n");

		result.append(DefaultPojo.DEFAULT_DOC_CENTER);
		count = iDocCenter.addDocCenter(DefaultPojo.DEFAULT_DOC_CENTER);
		result.append("count = " + count + "\n\n");

		result.append(DefaultPojo.DEFAULT_ATTACH_DOC);
		count = iAttachDoc.addAttachDoc(DefaultPojo.DEFAULT_ATTACH_DOC);
		result.append("count = " + count + "\n\n");

		result.append(DefaultPojo.DEFAULT_EDU_MESSAGE);
		count = iEduMessage.addEduMessage(DefaultPojo.DEFAULT_EDU_MESSAGE);
		result.append("count = " + count + "\n\n");

		result.append(DefaultPojo.DEFAULT_STUDY_TALKING);
		count = iStudyTalking.addStudyTalking(DefaultPojo.DEFAULT_STUDY_TALKING);
		result.append("count = " + count + "\n\n");

		result.append(DefaultPojo.DEFAULT_STUDY_TALKING_HISTORY);
		count = iStudyTalkingHistory.addStudyTalkingHistory(DefaultPojo.DEFAULT_STUDY_TALKING_HISTORY);
		result.append("count = " + count + "\n\n");

		return result.toString();
	}
}
