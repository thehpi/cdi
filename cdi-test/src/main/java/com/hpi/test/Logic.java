package com.hpi.test;

import javax.interceptor.Interceptors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Logic
{
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@TestIntercept
	public void doit()
	{
		this.logger.info("Logic: doit");
	}

	@Interceptors(TestInterceptor2.class)
	public void doit2()
	{
		this.logger.info("Logic: doit2");
	}
}
