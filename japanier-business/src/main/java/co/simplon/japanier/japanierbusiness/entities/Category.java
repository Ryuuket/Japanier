package co.simplon.japanier.japanierbusiness.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "t_categories")
public class Category extends BaseEntity {
    @Column(name = "category_code")
    private String code;

    @Column(name = "libelle")
    private String libelle;

    public Category() {

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
