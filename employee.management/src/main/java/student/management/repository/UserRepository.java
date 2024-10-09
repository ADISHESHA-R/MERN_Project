package student.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import student.management.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {

	User findByUsername(String username);

	User findByEmail(String email);

}
