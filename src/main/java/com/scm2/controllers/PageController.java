package com.scm2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PageController {
//PageControllers  
    //home.html
    @RequestMapping("/home")
    public String homePage(Model model) {
        System.out.println("Home Page Handler");

        //Sending Data to Page
        model.addAttribute("WelcomeSign", "Welcome To SCM");
        model.addAttribute("WelcomeDescription", "A Smart Way to Manage Contacts");
        model.addAttribute("RedirectToSignUp", "GetStarted");
        model.addAttribute("RedirectToLogin", "Login");

        return "home";
    }

    //about.html
    @RequestMapping("/about")
    public String aboutPage() {
        System.out.println("About Page Handler");



        return "about";
    }

    //help.html
    @RequestMapping("/help")
    public String helpPage() {
        System.out.println("Help Page Handler");


        return "help";
    }

    //contact.html
    @RequestMapping("/contact")
    public String contactPage() {
        System.out.println("Contact Page Handler");


        return "contact";
    }
    
    

    //index.html - Out Of Service
    @RequestMapping("/index")
    public String indexPage() {
        System.out.println("index Page Handler");

        return "index";
    }
    


    
}
