package fise3.info6.projetlu.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fise3.info6.projetlu.model.Employee;

public interface EmployeeRepository extends JpaRepository< Employee,String>{
	List<Employee> findByFirstName(String firstName);
	List<Employee> findAll();
	long count();
	long countBySalaryBetween(BigDecimal start,BigDecimal end);
	Employee findByEmployeeId(long id);
	Employee save(Employee employee);
	void delete(Employee employee);
}
