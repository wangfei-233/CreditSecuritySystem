package com.yinuo.job.service;

import java.util.List;

import com.yinuo.common.service.IService;
import com.yinuo.job.domain.JobLog;

public interface JobLogService extends IService<JobLog>{

	List<JobLog> findAllJobLogs(JobLog jobLog);

	void saveJobLog(JobLog log);
	
	void deleteBatch(String jobLogIds);
}
