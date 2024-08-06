package com.scm2.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.scm2.models.User;
import com.scm2.models.inputs.UserInputForum;
import com.scm2.repositories.UserRepo;
import com.scm2.services.UserService;




@Controller
public class signupController {

  @Autowired
  private UserService userService;
  //signup.html
   @RequestMapping("/signup")
    public String sigupPage(Model model) {
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
    //validate current data 
    //saving to database
    User user = User.builder()
    .nameOfUser(userInputForum.getInputName())
    .emailOfUser(userInputForum.getInputEmail())
    .passwordOfUser(userInputForum.getInputPassword())
    .phoneNumberOfUser(userInputForum.getInputPhoneNumber())
    .picOfUser("/images/DefualtProPic.png")
    .build();

    User savedUser = userService.saveUser(user);
    //cofirmation to front
    System.out.println(savedUser);
    //redirect sigup page
      return "redirect:/signup";
  }
  

}
