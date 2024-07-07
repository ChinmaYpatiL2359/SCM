package com.scm2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class loginController {

//Login Controllers
  //login.html
   @RequestMapping("/login")
    public String loginPage() {
        System.out.println("Login Page Handler");

        
        return "login";
    }

}
