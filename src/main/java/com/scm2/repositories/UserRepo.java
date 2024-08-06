package com.scm2.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.scm2.models.User;
import java.util.List;


@Repository
public interface UserRepo extends JpaRepository <User,String> {

    Optional<User> findByEmailOfUser(String emailOfUser);

    Optional<User> findByPasswordOfUser(String passwordOfUser);
}
