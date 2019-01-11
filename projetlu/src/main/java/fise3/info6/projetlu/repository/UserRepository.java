package fise3.info6.projetlu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fise3.info6.projetlu.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	User findByUserId(int id);
}
