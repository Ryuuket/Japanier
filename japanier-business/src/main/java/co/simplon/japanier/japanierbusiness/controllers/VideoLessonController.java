package co.simplon.japanier.japanierbusiness.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.japanier.japanierbusiness.entities.VideoLesson;
import co.simplon.japanier.japanierbusiness.services.VideoLessonService;

@RestController
@RequestMapping("/videoLessons")
public class VideoLessonController {
    private VideoLessonService service;

    VideoLessonController(VideoLessonService service) {
    	this.service = service;
    }

    @GetMapping("/default")
    @ResponseStatus(HttpStatus.OK)
    public List<VideoLesson> getDefault() {
	return service.getDefault();
    }
}
