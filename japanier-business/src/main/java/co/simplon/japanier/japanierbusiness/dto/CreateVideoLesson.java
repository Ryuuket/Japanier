package co.simplon.japanier.japanierbusiness.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class CreateVideoLesson {
    @Size(max = 128, message = "Le titre ne doit pas contenir plus de 128 caractères.")
    @NotEmpty
    private String title;

    @Size(max = 500, message = "Le lien ne doit pas contenir plus de 500 caractères.")
    @NotEmpty
    private String link;

    @Size(max = 2048, message = "La description de la vidéo ne doit pas contenir 2048 caractères.")
    @NotEmpty
    private String description;

    @NotEmpty
    private Integer category;

    public CreateVideoLesson() {

    }

    public String getTitle() {
	return title;
    }

    public void setTitle(String title) {
	this.title = title;
    }

    public String getLink() {
	return link;
    }

    public void setLink(String link) {
	this.link = link;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public Integer getCategory() {
	return category;
    }

    public void setCategory(Integer category) {
	this.category = category;
    }
}
