package com.scm2.services.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scm2.exceptions.ResourceNotFoundException;
import com.scm2.models.User;
import com.scm2.repositories.UserRepo;
import com.scm2.services.UserService;

@Service
public class UserServiceImpl implements UserService {

    //service injection
    @Autowired
    private UserRepo userRepo;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public User saveUser(User user) {
        //genrates unique id for user
        String genratedId = UUID.randomUUID().toString();
        user.setIdOfUser(genratedId);
        //save to database
        return userRepo.save(user);
    }

    //return user from db using id
    @Override
    public Optional<User> getUserByIdNumber(String id) {
        return userRepo.findById(id);
    }

    @Override
    public Optional<User> updatUser(User user) {
        
      User userfromDB = userRepo.findById(user.getIdOfUser())
                                .orElseThrow(() -> new ResourceNotFoundException("User Not Found"));

      userfromDB.setNameOfUser(user.getNameOfUser());                          
      userfromDB.setEmailOfUser(user.getEmailOfUser());
      userfromDB.setPasswordOfUser(user.getPasswordOfUser());
      userfromDB.setPhoneNumberOfUser(user.getPhoneNumberOfUser());
      userfromDB.setDiscriptionOfUser(user.getNameOfUser());
      userfromDB.setPicOfUser(user.getPicOfUser());
      userfromDB.setUserAccountEnabled(user.isUserAccountEnabled());
      userfromDB.setUserEmailVerified(user.isUserEmailVerified());
      userfromDB.setUserPhoneNumberVerified(user.isUserPhoneNumberVerified());
      userfromDB.setAccountProviderOfUser(user.getAccountProviderOfUser());
      userfromDB.setAccountProviderUserId(user.getAccountProviderUserId());
      userfromDB.setUserNameofUser(user.getUserNameofUser());

      User savedUser = userRepo.save(userfromDB);

      return Optional.ofNullable(savedUser);

    }

    @Override
    public void deleteUser(String id) {
        User userfromDB = userRepo.findById(id)
                                .orElseThrow(() -> new ResourceNotFoundException("User Not Found"));
            userRepo.delete(userfromDB);                    

    }

    @Override
    public boolean isUserExist(String id) {
        User userfromDB = userRepo.findById(id)
                                .orElse(null);
        
        return userfromDB != null ? true : false;                        
    }

    @Override
    public boolean isUserExistByEmail(String email) {
        User user = userRepo.findByEmailOfUser(email)
                            .orElse(null);

         return user != null ? true : false;                  
    }

    //return all users from database
    @Override
    public List<User> getAllUsers() {
        
        return userRepo.findAll();
    }


}
