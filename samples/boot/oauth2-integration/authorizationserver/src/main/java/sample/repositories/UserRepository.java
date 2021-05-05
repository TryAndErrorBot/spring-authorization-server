package sample.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.entities.UserDB;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserDB, String> {
	Optional<UserDB> findUserById(String u);
}
