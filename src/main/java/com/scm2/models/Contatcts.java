package com.scm2.models;



import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
//contact table
@Entity
@Table(name = "contacts")
public class Contatcts {

//mapping to user
   @ManyToOne
   private User user;

//mapping to social links
    @OneToMany(mappedBy = "contacts", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private List<SocialLink> socialLinks = new ArrayList<>();   
//____________________________________________________

//basic contact information
    @Column(name = "contact_name")
    private String nameOfContact;
   
    @Column(name = "contact_email", unique = true)
    private String emailOfContact;

    @Column(name ="contact_phone_number", unique = true)
    private String phoneNumberOfContact;

    @Column(name = "contact_picture_link")
    private String pictureLinkOfContact;

    @Column(name = "contact_full_address")
    private String AdddressOfContact;

    @Column(name = "contact_discription",length = 1000, columnDefinition = "TEXT")
    private String discriptionOfContact;
//_______________________________________________________________________________________

//contact identifiers
    @Id
    @Column(name = "id_number", unique = true, nullable = false)
    private String idOfContact;

    @Column(name = "id_group")
    private String groupIdOfContact;

//_______________________________________________________________________________    

//contact account status
    @Column(name = "status_favorite")
    private boolean isContactFavorite=false;

    //scocial accounts
    @Column(name = "contact_scocial_link")
    private String scocialLinkOfContact;

    //private List<ScocialLinks> scocialLinks = new ArrayList<>();
    
//_________________________________________________________________________________________
}
