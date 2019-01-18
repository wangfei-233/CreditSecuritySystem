package com.yinuo.common.shiro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CustomUserFilter implements Filter {

	@Override
	public void destroy() {
		System.out.println("destroy");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		chain.doFilter(request, response);
		System.out.println("doFilter");
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		System.out.println("init");
	}

}
