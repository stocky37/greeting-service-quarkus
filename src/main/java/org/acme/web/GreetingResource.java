package org.acme.web;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/hello")
public class GreetingResource {
	@ConfigProperty(name = "greeting.template", defaultValue = "Hello, %s!")
	String template;

	@ConfigProperty(name = "greeting.defaultName", defaultValue = "world")
	String defaultName;

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return hello(defaultName);
	}

	@GET
	@Path("{name}")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello(@PathParam("name") String name) {
		return String.format(template, name);
	}

}
