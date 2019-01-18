package com.yinuo.web.service.impl;

import java.util.List;

import org.assertj.core.util.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.yinuo.common.service.impl.BaseService;
import com.yinuo.web.dao.InfoMapper;
import com.yinuo.web.domain.Info;
import com.yinuo.web.service.InfoService;

@Service("infoService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class InfoServiceImpl extends BaseService<Info> implements InfoService {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private InfoMapper infoMapper;

	@Override
	public List<Info> findInfoWithNameAndInfoType(Info info) {
		try {
            return this.infoMapper.findInfoWithNameAndInfoType(info);
        } catch (Exception e) {
            log.error("error", e);
            return Lists.newArrayList();
        }
	}

}
