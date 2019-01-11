package fise3.info6.projetlu.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fise3.info6.projetlu.model.Country;


public interface CountryRepository extends PagingAndSortingRepository<Country, String> {

	List<Country> findByCountryName(@Param("name") String name);
	List<Country> findAll();
	Country save(Country country);
	Country findByCountryId(String id);
	void delete(Country country);

}

