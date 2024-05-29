package com.scm2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PageController {
//1.PageControllers  
    //home.html
    @RequestMapping("/home")
    public String homePage(Model model) {
        System.out.println("Home Page Handler");

        //Sending Data to Page
        model.addAttribute("WelcomeSign", "Welcome To SCM");
        model.addAttribute("WelcomeDescription", "Smart Contact Manager");
        model.addAttribute("RedirectToSignUp", "GetStarted");

        return "home";
    }

    //about.html
    @RequestMapping("/about")
    public String aboutPage() {
        System.out.println("About Page Handler");



        return "about";
    }

//2.ServiceControllers 
    //Service-1
    @RequestMapping("/service-1")
    public String requestMethodName() {
        System.out.println("Service Handler - '1'");
        return "service-1";
    }
    
}
