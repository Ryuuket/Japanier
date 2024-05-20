package co.simplon.japanier.japanierbusiness.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.japanier.japanierbusiness.entities.VideoLesson;

@Repository
public interface VideoLessonRepository extends JpaRepository<VideoLesson, Integer> {
    List<VideoLesson> findAll();

    VideoLesson findOneByTitle(String title);
}
