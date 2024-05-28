package co.simplon.japanier.japanierbusiness.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity(name = "t_video_lessons")
public class VideoLesson extends BaseEntity {
    @Column(name = "title")
    private String title;

    @Column(name = "link")
    private String link;

    @Column(name = "video_description")
    private String description;

    public VideoLesson() {

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
}
