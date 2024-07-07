package com.scm2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ServiceController {

//ServiceControllers 
    //Service-1
    @RequestMapping("/service-1")
    public String requestMethodName() {
        System.out.println("Service Handler - '1'");

        
        return "service-1";
    }
}
