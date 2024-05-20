package co.simplon.japanier.japanierbusiness.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.japanier.japanierbusiness.entities.VideoLesson;
import co.simplon.japanier.japanierbusiness.repositories.VideoLessonRepository;

@Service
public class VideoLessonService {
    @Autowired
    private VideoLessonRepository repository;

    public List<VideoLesson> getDefault() {
	return repository.findAll();
    }
}
