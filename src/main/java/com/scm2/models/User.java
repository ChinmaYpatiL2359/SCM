package com.scm2.models;

import java.util.ArrayList;
import java.util.List;

import com.scm2.models.providers.Providers;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//user table
@Entity(name = "user")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {


//mapping to contacts
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Contatcts> contact = new ArrayList<>();

    
//_________________________________________________________________    

//basic information
    @Column(name = "user_name", nullable = false)
    private String nameOfUser;
   
    @Column(name = "user_email", unique = true, nullable = false)
    private String emailOfUser;

    @Column(name = "user_phone_number", unique = true, nullable = false)
    private String phoneNumberOfUser;
       
    @Column(name = "user_picture_link", length = 1000)
    private String picOfUser;

    @Column(name = "user_discription", length = 1000, columnDefinition = "TEXT")
    private String discriptionOfUser;
//_______________________________________________________________________

//login information and user identifiers
    @Id
    @Column(name = "id_number", unique = true, nullable = false)
    private String IdOfUser;

    @Column(name = "id_name", unique = true, nullable = true)
    private String userNameofUser;

    @Column(name = "id_password", unique = false, nullable = false)
    private String passwordOfUser;
//__________________________________________________________________________   

//account status 
    //user account is disable by default
    @Column(name = "status_account")
    private boolean isUserAccountEnabled=false;

    @Column(name = "status_email")
    private boolean isUserEmailVerified=false;

    @Column(name = "status_phone")
    private boolean isUserPhoneNumberVerified=false;


    //connected accounts 
    //provider is set to self by default
    @Column(name = "provider_name")
    private Providers accountProviderOfUser=Providers.SELF;

    @Column(name = "provider_id")
    private String accountProviderUserId;
//____________________________________________________________________________

}
