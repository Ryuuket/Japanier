package co.simplon.japanier.japanierbusiness.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.simplon.japanier.japanierbusiness.services.VideoLessonService;

@RestController
@RequestMapping("/videoLesson")
public class VideoLessonController {
    private VideoLessonService service;

    VideoLessonController(VideoLessonService service) {
    	this.service = service;
    }

    @GetMapping("/default")
    @ResponseStatus(HttpStatus.OK)
    public void getDefault() {
	service.getDefault();
    }
}
