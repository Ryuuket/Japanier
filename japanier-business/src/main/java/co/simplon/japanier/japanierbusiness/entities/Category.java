package co.simplon.japanier.japanierbusiness.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity(name = "t_categories")
public class Category {
    @Id
    @Column(name = "id")
    private Integer id;

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

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }
}
