package com.maryj.ecommercebackend.model.dto;

import jakarta.validation.constraints.*;

public class RegistrationBody {
    @Null
    @NotBlank
    @Size(min =3, max = 255)
    private String username;
    @Email
    @Null
    @NotBlank
    private String email;
    @Null
    @Size(max = 32, min = 6)
    private String password;
    @Null
    private String firstName;
    @Null
    @NotBlank
    private String lastName;

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
