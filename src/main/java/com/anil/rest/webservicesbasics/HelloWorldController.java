package com.anil.rest.webservicesbasics;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;


@RestController
public class HelloWorldController {
    
    //@GetMapping(value="/hello-world")
    @RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    public String helloWorld(){
        return "Hello World - Anil !!";
    }


    @RequestMapping(method = RequestMethod.GET, path = "/hello-world-bean")
    public HelloWorld helloWorldBean(){
        return new HelloWorld("Hello world from bean !!");
    }

    @RequestMapping(method = RequestMethod.GET, path = "/hello-world/{param}")
    public HelloWorld helloWorldWithPathParams(@PathVariable String param){
        return new HelloWorld("Hello world using param -> " + param);
    }
    
}
