package com.jwxtssm.service;

import com.jwxtssm.common.*;
import com.jwxtssm.dao.*;
import com.jwxtssm.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.Random;

@Service
public class DataGenerate {
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
	Random random = new Random();

	@Transactional
	public int generateBasicInfo() throws Exception {
		int basicId = DefaultValues.BASIC_ID;
		int headImg = DefaultValues.HEAD_IMG;
		int viceId;
		String name;
		String password = Utils.generateSHA256Digest("1234567890");
		int sex;
		float height;
		float weight;
		Date birthInfo;
		String homeAddress = "";
		String formalId = "";
		String rewardInfo = "";
		String punishmentInfo = "";
		int infoTransparency = DefaultValues.INFO_TRANSPARENCY;

		int count = 0;
		for (int i = 0; i < STUDENT_NUM + FELLOW_NUM; i++) {
			if (i < STUDENT_NUM) {
				//生成学生viceId
				int studentIdBase = 15000000;
				viceId = studentIdBase + i;
				viceId += (i / ((STUDENT_NUM / 4))) * 1000000;

				birthInfo = RandomBirthdayGenerator.generateBirthday(23 - (i / ((STUDENT_NUM / 4))));
			} else {
				//生成教职工viceId
				int fellowBase = 90000000;
				viceId = fellowBase + i;

				birthInfo = RandomBirthdayGenerator.generateBirthday(random.nextInt(26) + 30);
			}

			sex = random.nextInt(2) == 0 ? SpecialValues.MALE : SpecialValues.FEMALE;
			name = RandomNameGenerator.generateName(sex);

			height = 160f + random.nextInt(60) / 2f;

			weight = 60f + random.nextInt(200) / 10f;

			if (sex == SpecialValues.FEMALE) {
				height -= 10f;
				weight -= 10f;
			}

			BasicInfo basicInfo = new BasicInfo(basicId, headImg, viceId, name, password, sex, height, weight, birthInfo, homeAddress, formalId, rewardInfo, punishmentInfo, infoTransparency);
			iBasicInfo.addBasicInfo(basicInfo);
			count++;
		}

		return count;
	}

	@Transactional
	public int generateAuthInfo() {
		int count = 0;

		for (int i = 1; i <= 5; i++) {
			iAuthInfo.addAuthInfo(new AuthInfo(DefaultValues.AUTH_ID, i, Utils.convertYMDToDate(2000, 0, 0), Utils.convertYMDToDate(3000, 0, 0)));
			count++;
		}

		return count;
	}

	@Transactional
	public int generateCollege() {
		int count = 0;

		for (int i = 0; i < 20; i++) {
			iCollege.addCollege(new College(DefaultValues.COLLEGE_ID, "学院" + (char) ('A' + i), DefaultValues.INTRO, DefaultValues.ADDRESS));
			count++;
		}

		return count;
	}

	@Transactional
	public int generateMajor() {
		int count = 0;

		for (int i = 0; i < 300; i++) {
			iMajor.addMajor(new Major(DefaultValues.MAJOR_ID, i / 15 + 1, SpecialValues.MAJOR_TYPE_4_YEARS, "专业" + (char) ('A' + i / 15) + (char) ('A' + i % 15), DefaultValues.INTRO, DefaultValues.MAJOR_COMPULSORY_GRADES, DefaultValues.MAJOR_ELECTIVE_GRADES, DefaultValues.PUBLIC_COMPULSORY_GRADES, DefaultValues.PUBLIC_ELECTIVE_GRADES));
			count++;
		}

		return count;
	}

	@Transactional
	public int generateOrg() {
		int count = 0;

		for (int i = 0; i < 300; i++) {
			iOrg.addOrg(new Org(DefaultValues.ORG_ID, i / 15 + 1, "机构" + (char) ('A' + i / 15) + (char) ('A' + i % 15), DefaultValues.INFO));
			count++;
		}

		return count;
	}

	@Transactional
	public int generateRole() {
		int count = 0;

		//		添加管理员身份
		iRole.addRole(new Role(DefaultValues.ROLE_ID, 1, 3, DefaultValues.MAJOR_ID, DefaultValues.ORG_ID, DefaultValues.COLLEGE_ID, SpecialValues.ROLE_TYPE_ADMIN, Utils.convertYMDToDate(2000, 0, 0), Utils.convertYMDToDate(3000, 0, 0), SpecialValues.ROLE_STATE_VALID));
		count++;

		//		添加学生身份
		for (int i = 100502; i < 130502; i++) {
			int grade = (i - 100502) / 7500;
			iRole.addRole(new Role(DefaultValues.ROLE_ID, i, 7, i % 300 + 2, DefaultValues.ORG_ID, i % 20 + 2, SpecialValues.ROLE_TYPE_STUDENT, Utils.convertYMDToDate(2015 + grade, 9, 1), Utils.convertYMDToDate(2019 + grade, 6, 1), SpecialValues.ROLE_STATE_VALID));
			count++;
		}

		//		添加教师身份
		for (int i = 130502; i < 133502; i++) {
			iRole.addRole(new Role(DefaultValues.ROLE_ID, i, 5, DefaultValues.MAJOR_ID, i % 300 + 2, i % 20 + 2, i % 5 + 5, Utils.convertYMDToDate(2000, 0, 0), Utils.convertYMDToDate(3000, 0, 0), SpecialValues.ROLE_STATE_VALID));
			count++;
		}

		//		添加教务员身份
		for (int i = 133502; i < 134002; i++) {
			iRole.addRole(new Role(DefaultValues.ROLE_ID, i, 4, i % 300 + 2, DefaultValues.ORG_ID, i % 20 + 2, SpecialValues.ROLE_TYPE_OFFICER, Utils.convertYMDToDate(2000, 0, 0), Utils.convertYMDToDate(3000, 0, 0), SpecialValues.ROLE_STATE_VALID));
			count++;
		}

		return count;
	}
}
