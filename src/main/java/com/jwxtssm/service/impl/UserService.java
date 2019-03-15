package com.jwxtssm.service.impl;

import com.jwxtssm.common.Utils;
import com.jwxtssm.dao.AuthInfoDao;
import com.jwxtssm.dao.BasicInfoDao;
import com.jwxtssm.dao.RoleDao;
import com.jwxtssm.dto.Result;
import com.jwxtssm.dto.UserLoginExecution;
import com.jwxtssm.entity.BasicInfo;
import com.jwxtssm.entity.Role;
import com.jwxtssm.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
public class UserService implements IUserService {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	BasicInfoDao basicInfoDao;
	@Autowired
	RoleDao roleDao;
	@Autowired
	AuthInfoDao authInfoDao;

	@Override
	public Result<UserLoginExecution> login(String userId, String password) {
		int viceId = Integer.valueOf(userId);
		logger.info("用户(viceId = " + viceId + ") 尝试登陆");
		BasicInfo basicInfo = basicInfoDao.queryByViceId(viceId);
		if (basicInfo == null) {
			logger.info("用户(viceId = " + viceId + ") 不存在，登陆失败");
			return new Result<>(false, "用户id(学号/职工号)不存在!");
		} else {
			try {
				if (!basicInfo.getPassword().equals(Utils.generateSHA256Digest(password))) {
					logger.info("用户(viceId = " + viceId + ") 密码不正确，登陆失败");
					return new Result<>(false, "用户密码不正确!");
				}
			} catch (UnsupportedEncodingException e) {
				logger.info("用户(viceId = " + viceId + ") 密码校验中抛出 UnsupportedEncodingException 异常");
			}
			Role[] roles = roleDao.queryByBasicId(basicInfo.getBasicId());
//			for (Role role: roles) System.out.println(role);
			Set<Integer> authCodeSet = new TreeSet<>();
			List<Role> validRoles = new ArrayList<>();
			for (int i = 0; i < roles.length; i++) {
				if (roles[i].getState() == 1 && Utils.checkDateValid(roles[i].getValidTo())) {
					validRoles.add(roles[i]);
					authCodeSet.add(authInfoDao.queryById(roles[i].getAuthId()).getAuthCode());
				}
			}
			int[] authCodes = new int[authCodeSet.size()];
			int count = 0;
			for (Integer i: authCodeSet) authCodes[count++] = i;
			for (int i = 0; i < authCodes.length; i++) System.out.println(authCodes[i]);

			logger.info("用户(viceId = " + viceId + ") 登陆成功");
			return new Result<>(true, new UserLoginExecution(basicInfo.getBasicId(), authCodes, validRoles.toArray(new Role[0])));
		}
	}
}
