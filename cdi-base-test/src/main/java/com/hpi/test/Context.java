package com.hpi.test;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class Context
{
	private String message = "";

	public String getMessage()
	{
		return this.message;
	}

	public void setMessage(String message)
	{
		this.message = message;
	}
}
