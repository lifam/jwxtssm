package com.jwxtssm.service.impl;

import com.jwxtssm.common.Utils;
import com.jwxtssm.dao.AddressInfoDao;
import com.jwxtssm.dao.AuthInfoDao;
import com.jwxtssm.dao.BasicInfoDao;
import com.jwxtssm.dao.RoleDao;
import com.jwxtssm.dto.Result;
import com.jwxtssm.dto.UserInfoExecution;
import com.jwxtssm.dto.UserLoginExecution;
import com.jwxtssm.entity.AddressInfo;
import com.jwxtssm.entity.BasicInfo;
import com.jwxtssm.entity.Role;
import com.jwxtssm.exception.CustomException;
import com.jwxtssm.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
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
	@Autowired
	AddressInfoDao addressInfoDao;

	@Override
	public Result<UserLoginExecution> login(String userId, String password) {
		int viceId = Integer.valueOf(userId);
		logger.info("用户(viceId = " + viceId + ") 尝试登陆");
		BasicInfo basicInfo = basicInfoDao.queryByViceId(viceId);
		if (basicInfo == null) {
			logger.info("用户(viceId = " + viceId + ") 不存在,登陆失败");
			return new Result<>(false, "用户id(学号/职工号)不存在!");
		} else {
			try {
				if (!basicInfo.getPassword().equals(Utils.generateSHA256Digest(password))) {
					logger.info("用户(viceId = " + viceId + ") 密码不正确,登陆失败");
					return new Result<>(false, "用户密码不正确!");
				}
			} catch (UnsupportedEncodingException e) {
				logger.info("用户(viceId = " + viceId + ") 密码校验中抛出 UnsupportedEncodingException 异常");
			}
			Role[] roles = roleDao.queryByBasicId(basicInfo.getBasicId());
			//          for (Role role: roles) System.out.println(role);
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
			for (Integer i : authCodeSet) authCodes[count++] = i;
			for (int i = 0; i < authCodes.length; i++) System.out.println(authCodes[i]);

			logger.info("用户(viceId = " + viceId + ") 登陆成功");
			return new Result<>(true, new UserLoginExecution(basicInfo.getBasicId(), authCodes, validRoles.toArray(new
					Role[0])));
		}
	}

	@Override
	public UserInfoExecution getUserInfo(int basicId) throws CustomException {
		BasicInfo basicInfo = basicInfoDao.queryById(basicId);
		if (basicInfo == null) {
			throw new CustomException("操作:查询用户信息,用户不存在!");
		}
		AddressInfo[] addressInfos = addressInfoDao.queryByBasicId(basicId);
		String[] types = new String[addressInfos.length];
		String[] infos = new String[addressInfos.length];
		for (int i = 0; i < addressInfos.length; i++) {
			//			switch (addressInfos[i].getType()) {
			//				case 1:
			//
			//					break;
			//				case 2:
			//
			//					break;
			//				case 3:
			//
			//					break;
			//				case 4:
			//
			//					break;
			//				case 5:
			//
			//					break;
			//				default:
			//
			//					break;
			//			}
			infos[i] = addressInfos[i].getInfo();
		}
		String sex = "未知";
		if (basicInfo.getSex() == 1) sex = "男";
		else if (basicInfo.getSex() == 0) sex = "女";

		String infoTransparency = "名字/头像";
		if (basicInfo.getInfoTransparency() == 2) {
			infoTransparency += "/学号";
		}
		if (basicInfo.getInfoTransparency() == 3) {
			infoTransparency += "/性别";
		}
		if (basicInfo.getInfoTransparency() == 4) {
			infoTransparency += "/出生年月";
		}
		if (basicInfo.getInfoTransparency() == 5) {
			infoTransparency += "/身高/体重";
		}

		return new UserInfoExecution(basicInfo.getViceId(), basicInfo.getName(), sex, basicInfo.getHeight(), basicInfo
				.getWeight(), basicInfo.getBirthInfo(), basicInfo.getHomeAddress(), basicInfo.getFormalId(), basicInfo
				.getRewardInfo(), basicInfo.getPunishmentInfo(), infoTransparency, types, infos);
	}
}
