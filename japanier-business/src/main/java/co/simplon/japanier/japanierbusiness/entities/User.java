package co.simplon.japanier.japanierbusiness.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "t_users")
public class User extends BaseEntity {
    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public User(String email, String password) {
	super();
	this.email = email;
	this.password = password;
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
