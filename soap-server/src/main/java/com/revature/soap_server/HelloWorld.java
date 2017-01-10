package com.revature.soap_server;

import javax.jws.WebService;

@WebService
public interface HelloWorld {
    String sayHi(String text);
    void work(String message);
}

