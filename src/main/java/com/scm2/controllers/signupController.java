package com.scm2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class signupController {

//SignUp Controllers
  //signup.html
   @RequestMapping("/signup")
    public String loginPage() {
        System.out.println("SignUp Page Handler");

        
        return "signup";
    }

}
