package com.scm2.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm2.models.inputs.UserInputForum;




@Controller
public class signupController {

  //signup.html
   @RequestMapping("/signup")
    public String loginPage(Model model) {
        System.out.println("SignUp Page Handler");
       UserInputForum userInputForum = new UserInputForum();

      //  userInputForum.setInputEmail("chim@email.com");
      //  userInputForum.setInputPassword("chim@email.com");
      //  userInputForum.setInputName("chim@email.com");
      //  userInputForum.setInputPhoneNumber("chim@email.com");
      

       model.addAttribute("userinput", userInputForum);

        return "signup";
    }

//Incoming Signup Handler
  @RequestMapping(value = "/do-signup", method=RequestMethod.POST)
  public String startSignup(@ModelAttribute UserInputForum userInputForum) {
    System.out.println("Signup Handler");
    //fetch data from front
    System.out.println(userInputForum);
    //validate current data 
    //saving to database
    //cofirmation to front
    //redirect sigup page
      return "redirect:/signup";
  }
  

}
