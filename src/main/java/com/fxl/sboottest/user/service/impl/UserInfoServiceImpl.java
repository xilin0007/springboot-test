package com.fxl.sboottest.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fxl.common.base.BaseMapper;
import com.fxl.common.base.BaseServiceImpl;
import com.fxl.sboottest.user.entity.UserInfo;
import com.fxl.sboottest.user.mapper.UserInfoMapper;
import com.fxl.sboottest.user.service.UserInfoService;

@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo> implements UserInfoService {
	
	@Autowired
	private UserInfoMapper userInfoMapper;
	
	@Override
	protected BaseMapper<UserInfo> getDao() {
		return userInfoMapper;
	}

	@Override
	public List<UserInfo> listByNickName(String nickName, Integer size) {
		return userInfoMapper.listByNickName(nickName, size);
	}
	
	@Override
	@Transactional//启用事务
	public boolean updateFindRollBack(int uId1, int uId2) {
		UserInfo u1 = new UserInfo();
		u1.setNickName("rollBackName");
		u1.setId(uId1);
		try {
			Integer ret = userInfoMapper.update(u1);
			int a = 3 / 0;//模拟异常
			return (ret > 0);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
