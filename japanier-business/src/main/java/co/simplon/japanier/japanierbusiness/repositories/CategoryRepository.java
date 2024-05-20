package co.simplon.japanier.japanierbusiness.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.japanier.japanierbusiness.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    List<Category> findAll();

    Category findOneByLibelle(String libelle);
}
