package co.simplon.japanier.japanierbusiness.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class CreateCategory {
    @Size(min = 5, max = 5, message = "Le code doit être composé de 5 caractères.")
    @NotEmpty
    private String code;

    @Size(max = 50, message = "Le nom ne doit pas contenir plus de 50 caractères.")
    @NotEmpty
    private String libelle;

    public CreateCategory() {

    }

    public String getCode() {
	return code;
    }

    public void setCode(String code) {
	this.code = code;
    }

    public String getLibelle() {
	return libelle;
    }

    public void setLibelle(String libelle) {
	this.libelle = libelle;
    }
}

