package co.simplon.japanier.japanierbusiness.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.japanier.japanierbusiness.entities.Category;
import co.simplon.japanier.japanierbusiness.repositories.CategoryRepository;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    public List<Category> getDefault() {
	return repository.findAll();
    }
}
