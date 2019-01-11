package fise3.info6.projetlu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fise3.info6.projetlu.model.Region;

public interface RegionRepository extends JpaRepository<Region, String> {
	Region findByRegionId(long id);
	List<Region> findAll();
	Region save(Region region);
}

