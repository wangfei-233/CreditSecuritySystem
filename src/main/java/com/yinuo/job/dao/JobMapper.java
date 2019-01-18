package com.yinuo.job.dao;

import java.util.List;

import com.yinuo.common.config.MyMapper;
import com.yinuo.job.domain.Job;

public interface JobMapper extends MyMapper<Job> {
	
	List<Job> queryList();
}