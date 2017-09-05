package com.example.jaxrs.helloworld;

import java.io.IOException;
import java.net.URI;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public class App {

	private static final URI BASE_URI = URI.create("http://localhost:8085/helloworld");
	public static final String ROOT_PATH = "hello";
	
	public static void main(String[] args) throws IOException {
		
		ResourceConfig config= new ResourceConfig(HelloWorldResource.class);
		final HttpServer server = GrizzlyHttpServerFactory.createHttpServer(BASE_URI,config,false);
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                server.shutdownNow();
            }
        }));
        server.start();

	}
}
