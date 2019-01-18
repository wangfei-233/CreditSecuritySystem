package com.yinuo.system.service;

import java.util.List;

import com.yinuo.system.domain.UserOnline;

public interface SessionService {

	List<UserOnline> list();

	boolean forceLogout(String sessionId);
}
