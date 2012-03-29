package com.hpi.test;


import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterBeanDiscovery;
import javax.enterprise.inject.spi.AfterDeploymentValidation;
import javax.enterprise.inject.spi.BeforeBeanDiscovery;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.inject.spi.ProcessAnnotatedType;
import javax.enterprise.inject.spi.ProcessBean;
import javax.enterprise.inject.spi.ProcessInjectionTarget;
import javax.enterprise.inject.spi.ProcessObserverMethod;
import javax.enterprise.inject.spi.ProcessProducer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyExtension implements Extension
{
	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	void beforeBeanDiscovery(@Observes
	BeforeBeanDiscovery bbd)
	{
		this.logger.debug("beginning the scanning process1");
	}

	<T> void processAnnotatedType(@Observes
	ProcessAnnotatedType<T> pat)
	{
		this.logger.debug("scanning type: " + pat.getAnnotatedType().getJavaClass().getName());
	}

	void afterBeanDiscovery(@Observes
	AfterBeanDiscovery abd)
	{
		this.logger.debug("finished the scanning process");
	}

	<T> void processInjectionTarget(@Observes
	ProcessInjectionTarget<T> pit)
	{
		this.logger.debug("processing injection target: " + pit.getInjectionTarget().getClass().getName());
	}

	<T, X> void processProducer(@Observes
	ProcessProducer<T, X> pp)
	{
		this.logger.debug("process producer: " + pp.getProducer().getClass().getName());
	}

	<X> void processBean(@Observes
	ProcessBean<X> pb)
	{
		this.logger.debug("process bean: " + pb.getBean().getClass().getName());
	}

	<T, X> void processObserverMethod(@Observes
	ProcessObserverMethod<T, X> pom)
	{
		this.logger.debug("process observer method: " + pom.getObserverMethod().getClass().getName());
	}

	void afterDeploymentValidation(@Observes
	AfterDeploymentValidation adv)
	{
		this.logger.debug("after deployment validation");
	}
}
