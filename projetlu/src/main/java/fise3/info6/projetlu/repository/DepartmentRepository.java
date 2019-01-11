package fise3.info6.projetlu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import fise3.info6.projetlu.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, String>{
	List<Department> findAll();
	Department save(Department country);
	Department findByDepartmentId(long id);
}
