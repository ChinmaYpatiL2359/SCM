package com.scm2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm2.models.User;

@Repository
public interface UserRepo extends JpaRepository <User,String> {


}
