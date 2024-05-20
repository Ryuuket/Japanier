package co.simplon.japanier.japanierbusiness.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.simplon.japanier.japanierbusiness.entities.SubCategory;
import co.simplon.japanier.japanierbusiness.repositories.SubCategoryRepository;

@Service
public class SubCategoryService {
    @Autowired
    private SubCategoryRepository repository;

    public List<SubCategory> getDefault() {
	return repository.findAll();
    }
}
