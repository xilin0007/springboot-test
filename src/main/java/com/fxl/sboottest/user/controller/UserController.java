package com.fxl.sboottest.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fxl.common.base.BaseController;
import com.fxl.common.util.ReturnMsg;
import com.fxl.sboottest.user.entity.UserInfo;
import com.fxl.sboottest.user.service.UserInfoService;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/user")
@Api(value = "/user", description = "用户模块")
public class UserController extends BaseController {
	@Autowired
	private UserInfoService userInfoService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/listByNickName")
	@ApiOperation(value = "获取用户信息", httpMethod = "POST", response = ReturnMsg.class, notes = "获取用户信息", position = 1)
	public ReturnMsg listByNickName(@ApiParam(value = "关键字") @RequestParam String query,
			@ApiParam(value = "大小") @RequestParam int size) {
		try {
			List<UserInfo> data = userInfoService.listByNickName(query, size);
			return new ReturnMsg(ReturnMsg.SUCCESS, "获取用户信息成功", data);
		} catch (Exception e) {
			e.printStackTrace();
			return new ReturnMsg(ReturnMsg.FAIL, "获取用户信息异常", new ArrayList<>());
		}
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/testRallBack")
	@ApiOperation(value = "测试事务回滚", httpMethod = "GET", response = ReturnMsg.class, notes = "测试事务回滚", position = 2)
	public ReturnMsg testRallBack(@ApiParam(value = "用户ID1") @RequestParam int userId1,
			@ApiParam(value = "用户ID2") @RequestParam int userId2) {
		try {
			boolean ret = userInfoService.updateFindRollBack(userId1, userId2);
			if(ret == false){
				return new ReturnMsg(ReturnMsg.FAIL, "事务回滚功能", new ArrayList<>());
			}
			Object data = new ArrayList<>();
			return new ReturnMsg(ReturnMsg.SUCCESS, "测试事务回滚成功", data);
		} catch (Exception e) {
			e.printStackTrace();
			return new ReturnMsg(ReturnMsg.FAIL, "测试事务回滚异常", new ArrayList<>());
		}
	}
}
