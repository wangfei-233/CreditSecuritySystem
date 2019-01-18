package com.yinuo.web.service;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;

import com.yinuo.common.service.IService;
import com.yinuo.web.domain.Info;

@CacheConfig(cacheNames = "InfoService")
public interface InfoService extends IService<Info> {
	
	List<Info> findInfoWithNameAndInfoType(Info info);
}
