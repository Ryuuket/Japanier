package co.simplon.japanier.japanierbusiness.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.japanier.japanierbusiness.entities.SubCategory;

@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {
    List<SubCategory> findAll();

    SubCategory findOneById(Integer id);
}
