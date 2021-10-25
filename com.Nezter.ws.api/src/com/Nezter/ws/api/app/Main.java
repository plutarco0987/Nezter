package com.Nezter.ws.api.app;

import java.io.IOException;
import java.net.InetSocketAddress;

import javax.xml.ws.Endpoint;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Main {
	
	public static void main(String[] args) throws IOException {		
		 		
		Endpoint.publish("http://localhost:8900/api/UserWebService", new UserServiceImp());		
	}
}
