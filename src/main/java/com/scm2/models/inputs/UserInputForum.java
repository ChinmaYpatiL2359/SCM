package com.scm2.models.inputs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * UserInputForum
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class UserInputForum {

    private String inputEmail;

    private String inputPassword;

    private String inputName;

    private String inputPhoneNumber;

    
}