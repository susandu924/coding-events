package org.launchcode.codingevents.models.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


//dtos help with form rendering and processing. A DTO associated with a form as an object
//that represents each of the form fields. Using a DTO to represent data associated with a form
//makes form rendering and processing much easier when the form does not line up with a specific model class.
//password field stores plain-text password. doesnt contradict about NOT storing password since
// LoginFormDTO is not a persistent class.

public class LoginFormDTO {

        @NotNull
        @NotBlank
        @Size(min = 3, max = 20, message = "Invalid username. Must be between 3 and 20 characters.")
        private String username;

        @NotNull
        @NotBlank
        @Size(min = 5, max = 30, message = "Invalid password. Must be between 5 and 30 characters.")
        private String password;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

    }

