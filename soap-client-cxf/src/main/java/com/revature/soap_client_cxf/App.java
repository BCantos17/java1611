package com.revature.soap_client_cxf;

import com.revature.soap_server.HelloWorld;
import com.revature.soap_server.HelloWorldImplService;

public class App{
	public static void main(String[] args) {
		// HelloWorld - service endpoint interface
		// HelloWorldImplService - service locator pattern
		HelloWorld sei = new HelloWorldImplService()
				.getHelloWorldImplPort();
		System.out.println(sei.sayHi("Dan Pickles"));
	}
}