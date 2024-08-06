package com.scm2.models;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//scoial links table
@Entity
@Table(name = "social_links")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SocialLink {

//mapping to contacts
    @ManyToOne
    private Contatcts contacts;
//__________________________________________

// basic information
    @Column(name = "social_links")    
    private String SocialLink;

    @Column(name = "social_title")    
    private String SocialTitle;
//________________________________________    

//Social Link identifiers
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_number", unique = true)
    private int idOfSocialLink;
//_____________________________________________    

}
