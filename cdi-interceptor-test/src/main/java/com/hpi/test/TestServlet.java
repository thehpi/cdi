package com.hpi.test;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(urlPatterns = { "/test" })
public class TestServlet extends HttpServlet
{
	private static final long serialVersionUID = -5824803675499996104L;

	private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

	@Inject
	private Logic logic;

	@Inject
	Context context;

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException
	{
		this.logger.info("Start TestServlet");
		this.logic.doit();
		this.logic.doit2();
		this.logger.info("Stop TestServlet");

		arg1.getWriter().write("OK" + this.context.getMessage() + "\n");
		arg1.flushBuffer();
	}

}
