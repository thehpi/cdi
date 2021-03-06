package com.hpi.test;


import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestInterceptor2
{
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Inject
	Context context;

	@AroundInvoke
	public Object intercept(InvocationContext ic) throws Exception {
		this.logger.info("Start interception 2");
		try {
			this.context.setMessage(this.context.getMessage() + "2");
			return ic.proceed();
		} finally {
			this.logger.info("Done intercepting 2 :)");
		}

	}
}
