package com.yinuo.system.service;

import com.yinuo.common.service.IService;
import com.yinuo.system.domain.UserRole;

public interface UserRoleService extends IService<UserRole> {

	void deleteUserRolesByRoleId(String roleIds);

	void deleteUserRolesByUserId(String userIds);
}
