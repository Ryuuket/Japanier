package co.simplon.japanier.japanierbusiness.dto;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Pattern;

public class CreateUser {
    @Pattern(regexp = "^[\\p{L}0-9._%+-]+@[\\p{L}0-9.-]+\\.[a-zA-Z]{2,}$", message = "L'adresse mail doit être valide.")
    private String email;

    @Length(min = 8, message = "Le mot de passe doit contenir au moins 8 caractères.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z]).*$", message = "Le mot de passe doit contenir au moins une majuscule et une minuscule.")
    @Pattern(regexp = "^(?=.*\\d).*$", message = "Le mot de passe doit contenir au moins un nombre.")
    @Pattern(regexp = "^(?=.*[\\W_]).*$", message = "Le mot de passe doit contenir au moins un caractère spécial.")
    private String password;

    public CreateUser() {

    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public String getPassword() {
	return password;
    }

    public void setPassword(String password) {
	this.password = password;
    }
}