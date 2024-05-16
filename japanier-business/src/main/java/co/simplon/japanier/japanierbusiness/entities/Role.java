package co.simplon.japanier.japanierbusiness.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "t_roles")
public class Role extends BaseEntity {
    @Column(name = "role_code")
    private String code;

    @Column(name = "libelle")
    private String libelle;

    @Column(name = "default_role")
    private boolean defaultRole;

    public Role(String code, String libelle, boolean defaultRole) {
	super();
	this.code = code;
	this.libelle = libelle;
	this.defaultRole = defaultRole;
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

    public boolean isDefaultRole() {
	return defaultRole;
    }

    public void setDefaultRole(boolean defaultRole) {
	this.defaultRole = defaultRole;
    }

}
