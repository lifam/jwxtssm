USE jwxt;
-- 个人基本信息
CREATE TABLE basic_info(
	basic_id int auto_increment,
	-- 头像，保存在表doc_center中
	head_img int,
	-- 副id，用于学生学号，教师职工号等
	vice_id int NOT NULL UNIQUE,
	-- 名字
	name varchar(30) NOT NULL,
	-- 密码，使用sha-256
	password varchar(40) NOT NULL,
	-- 性别
	sex int,
	-- 身高/cm
	height float,
	-- 体重/kg
	weight float,
	-- 出生年月
	birth_info date,
	-- 家庭住址
	home_address varchar(180),
	-- 身份证号
	formal_id varchar(30),
	-- 表彰信息
	reward_info varchar(1000),
	-- 惩罚信息
	punishment_info varchar(1000),
	-- 个人信息可见度，1-名字/头像，2-+学号，3-+性别，4+出生年月，5-+身高/体重
	info_transparency int NOT NULL,
	PRIMARY KEY(basic_id)
	-- FOREIGN KEY(head_img) REFERENCES doc_center(doc_id)
) ENGINE = InnoDB;

USE jwxt;
-- 联系信息-邮箱/电话/QQ/微信/微博
CREATE TABLE address_info(
	address_id int auto_increment,
	basic_id int NOT NULL,
	-- 1-邮箱/2-电话/3-QQ/4-微信/5-微博
	type int NOT NULL,
	-- 联系信息具体值
	info varchar(30) NOT NULL,
	PRIMARY KEY(address_id),
	FOREIGN KEY(basic_id) REFERENCES basic_info(basic_id)
) ENGINE = InnoDB;

USE jwxt;
-- 权限信息
CREATE TABLE auth_info(
	auth_id int auto_increment,
	-- 权限码，1-管理员，2-教务员，3-教师，4-助教，5-学生
	auth_code int NOT NULL,
	-- 生效日期
	valid_from date NOT NULL,
	-- 失效日期
	valid_to date NOT NULL,
	PRIMARY KEY(auth_id)
) ENGINE = InnoDB;

USE jwxt;
-- 开课记录
CREATE TABLE course(
	course_id int auto_increment,
	-- 开课老师
	basic_id int NOT NULL,
	-- 课程类型，1-专必MC/2-专选ME/3-公必PC/4-公选PE
	type int NOT NULL,
	-- 课程学分
	score int NOT NULL,
	-- 课程名称
	name varchar(30) NOT NULL,
	-- 上课时间&地点
	time_location varchar(150) NOT NULL,
	-- 课程介绍/说明
	intro varchar(1000),
	-- 课程开始时间
	valid_from date, 
	-- 课程结束时间
	valid_to date,
	-- 状态，1-可以选课/2-停止选课/3-有效期内/4-课程失效，32th-bit：已审核/未审核，31th-bit：锁定/未锁定
	state int NOT NULL,
	PRIMARY KEY(course_id, basic_id),
	FOREIGN KEY(basic_id) REFERENCES basic_info(basic_id)
) ENGINE = InnoDB;

USE jwxt;
-- 评教记录
CREATE TABLE course_jugde_records(
	-- 课程id
	course_id int NOT NULL,
	-- 老师/助教id
	basic_id_te int NOT NULL,
	-- 学生id
	basic_id_st int NOT NULL,
	-- 最终成绩
	final_score int,
	-- 状态，32th-bit：已审核/未审核(审核后锁定,不可再修改)
	state int NOT NULL,
	PRIMARY KEY(course_id, basic_id_te, basic_id_st, state),
	FOREIGN KEY(course_id) REFERENCES course(course_id),
	FOREIGN KEY(basic_id_te) REFERENCES basic_info(basic_id),
	FOREIGN KEY(basic_id_st) REFERENCES basic_info(basic_id)
) ENGINE = InnoDB;

USE jwxt;
-- 选课记录
CREATE TABLE course_records(
	-- 课程id
	course_id int NOT NULL,
	-- 学生id
	basic_id int NOT NULL,
	-- 最终成绩
	final_score int,
	-- 状态，1-正常/2-缓考/3-重考1/4-重考2/5-重考3/6-评教，32th-bit：已审核/未审核(审核后锁定,不可再修改)
	state int NOT NULL,
	PRIMARY KEY(course_id, basic_id, state),
	FOREIGN KEY(course_id) REFERENCES course(course_id),
	FOREIGN KEY(basic_id) REFERENCES basic_info(basic_id)
) ENGINE = InnoDB;

USE jwxt;
-- 课程作业/考试
CREATE TABLE homework_exam(
	homework_exam_id int auto_increment,
	-- 课程id
	course_id int NOT NULL,
	-- 作业/考试说明
	info varchar(150) NOT NULL,
	-- 占总评成绩的比例
	percent int NOT NULL,
	-- 状态，32th-bit：已审核/未审核(审核后锁定,不可再修改)
	state int,
	PRIMARY KEY(homework_exam_id),
	FOREIGN KEY(course_id) REFERENCES course(course_id)
) ENGINE = InnoDB;

USE jwxt;
-- 课程作业/考试记录
CREATE TABLE homework_exam_score(
	homework_exam_id int NOT NULL,
	-- 学生id
	basic_id int NOT NULL,
	-- 作业/考试成绩
	score int,
	-- 评分说明
	info varchar(20),
	-- 状态，32th-bit：已审核/未审核(审核后锁定,不可再修改)
	state int,
	PRIMARY KEY(homework_exam_id, basic_id),
	FOREIGN KEY(homework_exam_id) REFERENCES homework_exam(homework_exam_id),
	FOREIGN KEY(basic_id) REFERENCES basic_info(basic_id)
) ENGINE = InnoDB;

USE jwxt;
-- 学院
CREATE TABLE college(
	college_id int auto_increment,
	-- 学院名称
	name varchar(30) NOT NULL UNIQUE,
	-- 学院介绍
	intro varchar(2000) NOT NULL,
	-- 学院地点
	docAddress varchar(150) NOT NULL,
	PRIMARY KEY(college_id)
) ENGINE = InnoDB;

USE jwxt;
-- 专业
CREATE TABLE major(
	major_id int auto_increment,
	-- 所属学院
	college_id int NOT NULL,
	-- 学制，1-全日制4年/2-全日制5年
	type int NOT NULL,
	-- 专业名称
	name varchar(30) NOT NULL,
	-- 专业介绍
	intro varchar(1500) NOT NULL,
	-- 专必学分
	major_compulsory_grades int NOT NULL,
	-- 专选学分
	major_elective_grades int NOT NULL,
	-- 公必学分
	public_compulsory_grades int NOT NULL,
	-- 公选学分
	public_elective_grades int NOT NULL,
	PRIMARY KEY(major_id),
	FOREIGN KEY(college_id) REFERENCES college(college_id)
) ENGINE = InnoDB;

USE jwxt;
-- 机构/研究所
CREATE TABLE org(
	org_id int auto_increment,
	-- 所属学院
	college_id int NOT NULL,
	-- 名字
	name varchar(30) NOT NULL,
	-- 介绍
	info varchar(1500),
	PRIMARY KEY(org_id),
	FOREIGN KEY(college_id) REFERENCES college(college_id)
) ENGINE = InnoDB;

USE jwxt;
-- 角色
CREATE TABLE role(
	role_id int auto_increment,
	basic_id int NOT NULL,
	auth_id int NOT NULL,
	major_id int NOT NULL,
	org_id int NOT NULL,
	college_id int NOT NULL,
	-- 角色类型，1-管理员/2-教务员/4-助教/5-学生/6-教授/7-副教授/8-高级讲师/9-讲师/10-特聘研究员
	type int NOT NULL,
	-- 生效日期
	valid_from date NOT NULL,
	-- 失效日期
	valid_to date NOT NULL,
	-- 状态，1-正常/2-冻结
	state int NOT NULL,
	PRIMARY KEY(role_id),
	FOREIGN KEY(basic_id) REFERENCES basic_info(basic_id),
	FOREIGN KEY(auth_id) REFERENCES auth_info(auth_id),
	FOREIGN KEY(major_id) REFERENCES major(major_id),
	FOREIGN KEY(org_id) REFERENCES org(org_id),
	FOREIGN KEY(college_id) REFERENCES college(college_id)
) ENGINE = InnoDB;

USE jwxt;
-- 学分概况
CREATE TABLE score_sum(
	-- 学生id
	basic_id int NOT NULL,
	-- 专必绩点
	mc_score float NOT NULL,
	-- 专必学分
	mc_grade int NOT NULL,
	-- 专选绩点
	me_score float NOT NULL,
	-- 专选学分
	me_grade int NOT NULL,
	-- 公必绩点
	pc_score float NOT NULL,
	-- 公必学分
	pc_grade int NOT NULL,
	-- 公选绩点
	pe_score float NOT NULL,
	-- 公选学分
	pe_grade int NOT NULL,
	PRIMARY KEY(basic_id),
	FOREIGN KEY(basic_id) REFERENCES basic_info(basic_id)
) ENGINE = InnoDB;

USE jwxt;
-- 系统通知
CREATE TABLE system_message(
	system_message_id int auto_increment,
	-- 通知对象
	basic_id int NOT NULL,
	-- 通知类型，1-教务通知/2-课程通知(作业发布/成绩发布等)/3-课内讨论(被@时通知)
	type int NOT NULL,
	-- 通知内容
	content varchar(200) NOT NULL,
	-- 通知发布日期
	publish_date date NOT NULL,
	-- 通知优先级
	priority int NOT NULL,
	-- 通知状态，1-未读/2-已读/3-无效
	state int NOT NULL,
	PRIMARY KEY(system_message_id),
	FOREIGN KEY(basic_id) REFERENCES basic_info(basic_id)
) ENGINE = InnoDB;

USE jwxt;
-- 文件中心
CREATE TABLE doc_center(
	doc_id int auto_increment,
	-- 文件所属人id
	basic_id int NOT NULL,
	-- 状态，1-可用/2-不可用
	state int NOT NULL,
	-- 文件本地地址
	docAddress varchar(300) NOT NULL,
	-- 文件类型，1-其它文件/2-头像
	type int NOT NULL,
	-- 上传日期
	publish_date date NOT NULL,
	PRIMARY KEY(doc_id),
	FOREIGN KEY(basic_id) REFERENCES basic_info(basic_id)
) ENGINE = InnoDB;

USE jwxt;
-- 附件
CREATE TABLE attach_doc(
	-- 附件id
	attach_doc_id int auto_increment,
	-- 文件id
	doc_id int NOT NULL,
	PRIMARY KEY(attach_doc_id, doc_id),
	FOREIGN KEY(doc_id) REFERENCES doc_center(doc_id)
) ENGINE = InnoDB;

USE jwxt;
-- 教务通知
CREATE TABLE edu_message(
	edu_message_id int auto_increment,
	-- 教务员id
	basic_id int NOT NULL,
	-- 附件
	attach_doc_id int,
	-- 标题
	title varchar(30) NOT NULL,
	-- 内容
	content varchar(3000) NOT NULL,
	-- 类型，1-普通通知/2-通知全体教职人员/3-通知全体学生/4-通知全体人员
	type int NOT NULL,
	-- 发布日期
	publish_date date NOT NULL,
	-- 状态，1-有效/2-已失效
	state int NOT NULL,
	-- 优先级，1<2<3<...
	priority int NOT NULL,
	PRIMARY KEY(edu_message_id),
	FOREIGN KEY(basic_id) REFERENCES basic_info(basic_id),
	FOREIGN KEY(attach_doc_id) REFERENCES attach_doc(attach_doc_id)
) ENGINE = InnoDB;

USE jwxt;
-- 课内讨论
CREATE TABLE study_talking(
	-- 话题id
	talk_id int auto_increment,
	-- 话题发起人
	basic_id int NOT NULL,
	-- 课程id
	course_id int NOT NULL,
	-- 附件
	attach_doc_id int,
	-- 标题
	title varchar(30) NOT NULL,
	-- 讨论说明
	content varchar(300) NOT NULL,
	-- 热度
	hot float NOT NULL,
	-- 状态，1-有效/2-无效
	state int NOT NULL,
	-- 发布日期
	publish_date date NOT NULL,
	-- 讨论记录数
	history_count int NOT NULL,
	PRIMARY KEY(talk_id),
	FOREIGN KEY(basic_id) REFERENCES basic_info(basic_id),
	FOREIGN KEY(course_id) REFERENCES course(course_id),
	FOREIGN KEY(attach_doc_id) REFERENCES attach_doc(attach_doc_id)
) ENGINE = InnoDB;

USE jwxt;
-- 学习讨论记录
CREATE TABLE study_talking_history(
	message_id int auto_increment,
	-- 所属话题id
	talk_id int NOT NULL,
	-- 发表人
	basic_id int NOT NULL,
	-- 课程id
	course_id int NOT NULL,
	-- 讨论内容
	content varchar(300) NOT NULL,
	-- 发表日期
	publish_date date NOT NULL,
	-- 第几条讨论
	index_count int NOT NULL,
	-- 类型，暂未定义
	type int NOT NULL,
	-- 状态，1-有效/2-无效
	state int NOT NULL,
	PRIMARY KEY(message_id),
	FOREIGN KEY(talk_id) REFERENCES study_talking(talk_id),
	FOREIGN KEY(basic_id) REFERENCES basic_info(basic_id),
	FOREIGN KEY(course_id) REFERENCES course(course_id)
) ENGINE = InnoDB;
