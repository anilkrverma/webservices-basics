package com.anil.rest.webservicesbasics.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;


@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

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

    @GetMapping(value="/hello-world-i18n")
    public String helloWorldI18n(@RequestHeader(name ="Accept-Language", required = false) Locale locale){
        return messageSource.getMessage("hello.message", null, locale);
    }
    
}
