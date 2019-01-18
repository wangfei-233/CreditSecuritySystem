package com.yinuo.web.dao;

import java.util.List;

import com.yinuo.common.config.MyMapper;
import com.yinuo.web.domain.Info;

public interface InfoMapper extends MyMapper<Info> {

	List<Info> findInfoWithNameAndInfoType(Info info);
	
}