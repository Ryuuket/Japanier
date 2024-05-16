package co.simplon.japanier.japanierbusiness.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class CreateUserDTO {

    @NotNull
    @Email
    private String email;

    @NotNull
    @Pattern(regexp = "/^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/")
    private String password;

    public CreateUserDTO() {

    }

}