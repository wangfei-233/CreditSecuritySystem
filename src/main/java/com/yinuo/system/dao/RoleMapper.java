package com.yinuo.system.dao;

import java.util.List;

import com.yinuo.common.config.MyMapper;
import com.yinuo.system.domain.Role;
import com.yinuo.system.domain.RoleWithMenu;

public interface RoleMapper extends MyMapper<Role> {
	
	List<Role> findUserRole(String userName);
	
	List<RoleWithMenu> findById(Long roleId);
}