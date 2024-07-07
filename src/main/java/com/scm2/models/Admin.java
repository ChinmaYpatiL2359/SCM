package com.scm2.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// admin table
@Entity
@Table(name ="admins")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Admin {

    //login information
    @Id
    @Column(name = "admin_id")
    private String IdForAdmin;

    @Column(name = "admin_password")
    private String passwordForAdmin;

    //profile picture
    @Column(name = "profile_link", nullable = true, length = 1000)
    private String profileForAdmin;

    //admin account enable by default
    @Column(name = "account_staus")
    private boolean isAdminAccountEnabled=true;
}
