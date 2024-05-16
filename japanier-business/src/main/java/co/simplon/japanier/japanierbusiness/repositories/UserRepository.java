package co.simplon.japanier.japanierbusiness.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.simplon.japanier.japanierbusiness.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> existsByEmailIgnoreCase(String email);

    User findOneByEmail(String email);
}
