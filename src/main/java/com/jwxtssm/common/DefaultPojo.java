package com.jwxtssm.common;

import com.jwxtssm.entity.*;

public class DefaultPojo {
	public static final AddressInfo DEFAULT_ADDRESS_INFO = getDefaultAddressInfo();
	public static final AttachDoc DEFAULT_ATTACH_DOC = getDefaultAttachDoc();
	public static final AuthInfo DEFAULT_AUTH_INFO = getDefaultAuthInfo();
	public static final BasicInfo DEFAULT_BASIC_INFO = getDefaultBasicInfo();
	public static final College DEFAULT_COLLEGE = getDefaultCollege();
	public static final Course DEFAULT_COURSE = getDefaultCourse();
	public static final CourseJudgeRecords DEFAULT_COURSE_JUGDE_RECORDS = getDefaultCourseJugdeRecords();
	public static final CourseRecords DEFAULT_COURSE_RECORDS = getDefaultCourseRecords();
	public static final DocCenter DEFAULT_DOC_CENTER = getDefaultDocCenter();
	public static final EduMessage DEFAULT_EDU_MESSAGE = getDefaultEduMessage();
	public static final HomeworkExam DEFAULT_HOMEWORK_EXAM = getDefaultHomeworkExam();
	public static final HomeworkExamScore DEFAULT_HOMEWORK_EXAM_SCORE = getDefaultHomeworkExamScore();
	public static final Major DEFAULT_MAJOR = getDefaultMajor();
	public static final Org DEFAULT_ORG = getDefaultOrg();
	public static final Role DEFAULT_ROLE = getDefaultRole();
	public static final ScoreSum DEFAULT_SCORE_SUM = getDefaultScoreSum();
	public static final StudyTalking DEFAULT_STUDY_TALKING = getDefaultStudyTalking();
	public static final StudyTalkingHistory DEFAULT_STUDY_TALKING_HISTORY = getDefaultStudyTalkingHistory();
	public static final SystemMessage DEFAULT_SYSTEM_MESSAGE = getDefaultSystemMessage();

	public static AddressInfo getDefaultAddressInfo() {
		return new AddressInfo(DefaultValues.ADDRESS_ID, DefaultValues.BASIC_ID, DefaultValues.TYPE, DefaultValues
				.INFO);
	}

	public static AttachDoc getDefaultAttachDoc() {
		return new AttachDoc(DefaultValues.ATTACH_DOC_ID, DefaultValues.DOC_ID);
	}

	public static AuthInfo getDefaultAuthInfo() {
		return new AuthInfo(DefaultValues.AUTH_ID, DefaultValues.AUTH_CODE, DefaultValues.VALID_FROM, DefaultValues
				.VALID_TO);
	}

	public static BasicInfo getDefaultBasicInfo() {
		return new BasicInfo(DefaultValues.BASIC_ID, DefaultValues.HEAD_IMG, DefaultValues.VICE_ID, DefaultValues
				.NAME, DefaultValues.PASSWORD, DefaultValues.SEX, DefaultValues.HEIGHT, DefaultValues.WEIGHT,
				DefaultValues.BIRTH_INFO, DefaultValues.HOME_ADDRESS, DefaultValues.FORMAL_ID, DefaultValues
				.REWARD_INFO, DefaultValues.PUNISHMENT_INFO, DefaultValues.INFO_TRANSPARENCY);
	}

	public static College getDefaultCollege() {
		return new College(DefaultValues.COLLEGE_ID, DefaultValues.NAME, DefaultValues.INTRO, DefaultValues.ADDRESS);
	}

	public static Course getDefaultCourse() {
		return new Course(DefaultValues.COURSE_ID, DefaultValues.BASIC_ID, DefaultValues.TYPE, DefaultValues.SCORE,
				DefaultValues.NAME, DefaultValues.INTRO, DefaultValues.VALID_FROM,
				DefaultValues.VALID_TO, DefaultValues.STATE);
	}

	public static CourseJudgeRecords getDefaultCourseJugdeRecords() {
		return new CourseJudgeRecords(DefaultValues.COURSE_ID, DefaultValues.BASIC_ID_TE, DefaultValues.BASIC_ID_ST,
				DefaultValues.FINAL_SCORE, DefaultValues.STATE);
	}

	public static CourseRecords getDefaultCourseRecords() {
		return new CourseRecords(DefaultValues.COURSE_ID, DefaultValues.BASIC_ID, DefaultValues.FINAL_SCORE,
				DefaultValues.STATE);
	}

	public static DocCenter getDefaultDocCenter() {
		return new DocCenter(DefaultValues.DOC_ID, DefaultValues.BASIC_ID, DefaultValues.STATE, DefaultValues
				.DOC_ADDRESS, DefaultValues.TYPE, DefaultValues.PUBLISH_DATE);
	}

	public static EduMessage getDefaultEduMessage() {
		return new EduMessage(DefaultValues.EDU_MESSAGE_ID, DefaultValues.BASIC_ID, DefaultValues.ATTACH_DOC_ID,
				DefaultValues.TITLE, DefaultValues.CONTENT, DefaultValues.TYPE, DefaultValues.PUBLISH_DATE,
				DefaultValues.STATE, DefaultValues.PRIORITY);
	}

	public static HomeworkExam getDefaultHomeworkExam() {
		return new HomeworkExam(DefaultValues.HOMEWORK_EXAM_ID, DefaultValues.COURSE_ID, DefaultValues.INFO,
				DefaultValues.PERCENT, DefaultValues.STATE);
	}

	public static HomeworkExamScore getDefaultHomeworkExamScore() {
		return new HomeworkExamScore(DefaultValues.HOMEWORK_EXAM_ID, DefaultValues.BASIC_ID, DefaultValues.SCORE,
				DefaultValues.INFO, DefaultValues.STATE);
	}

	public static Major getDefaultMajor() {
		return new Major(DefaultValues.MAJOR_ID, DefaultValues.COLLEGE_ID, DefaultValues.TYPE, DefaultValues.NAME,
				DefaultValues.INTRO, DefaultValues.MAJOR_COMPULSORY_GRADES, DefaultValues.MAJOR_ELECTIVE_GRADES,
				DefaultValues.PUBLIC_COMPULSORY_GRADES, DefaultValues.PUBLIC_ELECTIVE_GRADES);
	}

	public static Org getDefaultOrg() {
		return new Org(DefaultValues.ORG_ID, DefaultValues.COLLEGE_ID, DefaultValues.NAME, DefaultValues.INFO);
	}

	public static Role getDefaultRole() {
		return new Role(DefaultValues.ROLE_ID, DefaultValues.BASIC_ID, DefaultValues.AUTH_ID, DefaultValues.MAJOR_ID,
				DefaultValues.ORG_ID, DefaultValues.COLLEGE_ID, DefaultValues.TYPE, DefaultValues.VALID_FROM,
				DefaultValues.VALID_TO, DefaultValues.STATE);
	}

	public static ScoreSum getDefaultScoreSum() {
		return new ScoreSum(DefaultValues.BASIC_ID, DefaultValues.MC_SCORE, DefaultValues.MC_GRADE, DefaultValues.ME_SCORE,
				DefaultValues.ME_GRADE, DefaultValues.PC_SCORE, DefaultValues.PC_GRADE, DefaultValues.PE_SCORE,
				DefaultValues.PE_GRADE);
	}

	public static StudyTalking getDefaultStudyTalking() {
		return new StudyTalking(DefaultValues.TALK_ID, DefaultValues.BASIC_ID, DefaultValues.COURSE_ID, DefaultValues
				.ATTACH_DOC_ID, DefaultValues.TITLE, DefaultValues.CONTENT, DefaultValues.HOT, DefaultValues.STATE,
				DefaultValues.PUBLISH_DATE, DefaultValues.HISTORY_COUNT);
	}

	public static StudyTalkingHistory getDefaultStudyTalkingHistory() {
		return new StudyTalkingHistory(DefaultValues.EDU_MESSAGE_ID, DefaultValues.TALK_ID, DefaultValues.BASIC_ID,
				DefaultValues.COURSE_ID, DefaultValues.CONTENT, DefaultValues.PUBLISH_DATE, DefaultValues.INDEX_COUNT,
				DefaultValues.TYPE, DefaultValues.STATE);
	}

	public static SystemMessage getDefaultSystemMessage() {
		return new SystemMessage(DefaultValues.SYSTEM_MESSAGE_ID, DefaultValues.BASIC_ID, DefaultValues.TYPE,
				DefaultValues.CONTENT, DefaultValues.PUBLISH_DATE, DefaultValues.PRIORITY, DefaultValues.STATE);
	}
}
