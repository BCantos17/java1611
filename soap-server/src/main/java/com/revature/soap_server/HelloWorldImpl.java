
package com.revature.soap_server;

import javax.jws.WebService;

@WebService(endpointInterface = "com.revature.soap_server.HelloWorld")
public class HelloWorldImpl implements HelloWorld {

    public String sayHi(String text) {
        return "Hello " + text;
    }

	@Override
	public void work(String message) {
		System.out.println("[MESSAGE]: " + message);
	}
}

