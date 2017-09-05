package com.example.jaxrs.helloworld;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("hello")
public class HelloWorldResource {

	private static final String MESSAGE = "Hi Jersey...";

	@GET
	@Produces("text/plain")
	public String sayHello() {
		return MESSAGE;
	}
}
