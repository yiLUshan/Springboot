package fise3.info6.projetlu.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fise3.info6.projetlu.model.Job;


public interface JobRepository extends JpaRepository<Job, String>{
	Job findByJobId(String jobID);
	List<Job> findAll();
	Job save(Job job);
	List<Job> findAllByMinSalaryGreaterThanOrderByMaxSalaryDesc(BigDecimal minSalary);
}


