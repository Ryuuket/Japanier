package co.simplon.japanier.japanierbusiness.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "t_sub_categories")
public class SubCategory extends BaseEntity {
    @Column(name = "id_category")
    private Integer category;

    @Column(name = "sub_category_code")
    private String code;

    @Column(name = "libelle")
    private String libelle;

    public SubCategory() {

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

    public Integer getCategory() {
	return category;
    }

    public void setCategory(Integer category) {
	this.category = category;
    }
}
