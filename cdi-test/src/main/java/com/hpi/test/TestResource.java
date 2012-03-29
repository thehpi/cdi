package com.hpi.test;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RequestScoped
@Path("/rest")
public class TestResource
{
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Inject
	private Logic logic;

	@Inject
	private Context context;

	@GET
	public Object service()
	{
		this.logger.info("Start TestResource");
		this.logic.doit();
		this.logic.doit2();
		this.logger.info("End TestResource");

		return Response.ok().entity("OK" + this.context.getMessage() + "\n").build();
	}

}
