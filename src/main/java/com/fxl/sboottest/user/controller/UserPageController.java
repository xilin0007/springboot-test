package com.fxl.sboottest.user.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fxl.common.base.BaseController;
import com.fxl.common.util.ReturnMsg;
import com.fxl.sboottest.user.entity.UserInfo;
import com.fxl.sboottest.user.service.UserInfoService;

@Controller
@RequestMapping("/userPage")
public class UserPageController extends BaseController {
	
	@Autowired
	private UserInfoService userInfoService;
	
	/**
	 * 分页ajax接口-只返回列表
	 */
	@RequestMapping(value = "/findUsersById", method = RequestMethod.GET)
	@ResponseBody
	public ReturnMsg findUsersById(@RequestParam int userId) {
		System.out.println("===================>开始访问findUsersById！");
		try {
			UserInfo user = userInfoService.findById(userId);
			Object data = (user != null) ? user : new ArrayList<>();
			return new ReturnMsg(ReturnMsg.SUCCESS, "获取用户信息成功", data);
		} catch (Exception e) {
			e.printStackTrace();
			return new ReturnMsg(ReturnMsg.FAIL, "获取用户信息异常", new ArrayList<>());
		}
	}
	
}
