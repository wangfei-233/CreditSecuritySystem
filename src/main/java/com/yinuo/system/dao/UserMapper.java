package com.yinuo.system.dao;

import java.util.List;

import com.yinuo.common.config.MyMapper;
import com.yinuo.system.domain.User;
import com.yinuo.system.domain.UserWithRole;

public interface UserMapper extends MyMapper<User> {

	List<User> findUserWithDept(User user);
	
	List<UserWithRole> findUserWithRole(Long userId);
	
	User findUserProfile(User user);
}