package co.simplon.japanier.japanierbusiness.entities;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    BaseEntity() {

    }

    public long getId() {
	return this.id;
    }

    public void setId(long id) {
	this.id = id;
    }
}
