package com.yinuo.system.service;

import com.yinuo.common.service.IService;
import com.yinuo.system.domain.RoleMenu;

public interface RoleMenuServie extends IService<RoleMenu> {

	void deleteRoleMenusByRoleId(String roleIds);

	void deleteRoleMenusByMenuId(String menuIds);
}
