package com.fxl.sboottest.user.service;

import java.util.List;

import com.fxl.common.base.BaseService;
import com.fxl.sboottest.user.entity.UserInfo;

public interface UserInfoService extends BaseService<UserInfo> {
	public List<UserInfo> listByNickName(String nickName, Integer size);
	
	/**
	 * 更新回滚测试
	 * @createAuthor fangxilin
	 * @param uId1
	 * @param uId2
	 * @return
	 */
	public boolean updateFindRollBack (int uId1, int uId2);
}
