package fise3.info6.projetlu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fise3.info6.projetlu.model.Location;

public interface LocationRepository extends JpaRepository<Location, String> {
	Location findByLocationId(long id);
	List<Location> findAll();
}
