package com.alibaba.mapper;

import com.alibaba.bean.User;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

/**
 * mapper的具体表达式
 */
@Mapper //标记mapper文件位置，否则在Application.class启动类上配置mapper包扫描
@Repository
public class UserMapper {
	//定义一个HashMap来模拟数据库
	Map<String,User> usermap = new HashMap<String,User>();

	public User findUserByName(String username) {
		// TODO Auto-generated method stub
		
		if(usermap.containsKey(username))
			return usermap.get(username);
		else
			return null;
	}

	public void regist(User user) {
		// TODO Auto-generated method stub
		usermap.put(user.getUsername(),user );
	}

	public Long login(User user) {
		// TODO Auto-generated method stub
		if(usermap.containsKey(user.getUsername()))
		{
			return user.getId();
		}
		else
			return null;
	}
	
	
}
