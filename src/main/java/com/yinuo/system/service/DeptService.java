package com.yinuo.system.service;

import java.util.List;

import com.yinuo.common.domain.Tree;
import com.yinuo.common.service.IService;
import com.yinuo.system.domain.Dept;

public interface DeptService extends IService<Dept> {

	Tree<Dept> getDeptTree();

	List<Dept> findAllDepts(Dept dept);

	Dept findByName(String deptName);

	Dept findById(Long deptId);
	
	void addDept(Dept dept);
	
	void updateDept(Dept dept);

	void deleteDepts(String deptIds);
}
