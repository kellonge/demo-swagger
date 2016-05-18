package com.kellonge.demo.swagger.controller;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kellonge.demo.swagger.model.UserInfo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/test")
@Api(value = "/test")
public class TestController {

	@ApiOperation("获取当前时间")
	@RequestMapping(value = "/getCurrentTime", method = RequestMethod.GET)
	public String getCurrentTime() {
		return new Date().toString();
	}

	@ApiOperation("获取用户")
	@RequestMapping(value = "/getuser", method = RequestMethod.POST)
	public ResponseEntity<UserInfo> getUser(
			@RequestParam(value = "name", required = true, defaultValue = "ymn") @ApiParam("用户名") String name) {
		UserInfo userInfo = new UserInfo();
		userInfo.setAge(10);
		userInfo.setName(name);
		return new ResponseEntity<UserInfo>(userInfo, HttpStatus.OK);
	}

}
