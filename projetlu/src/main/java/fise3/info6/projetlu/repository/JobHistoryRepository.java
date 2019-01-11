package fise3.info6.projetlu.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import fise3.info6.projetlu.model.JobHistory;

public interface JobHistoryRepository extends JpaRepository<JobHistory, String> {
	JobHistory findByIdEmployeeIdAndIdStartDate(long employeeId,Date startDate);
	JobHistory save(JobHistory jobHistory);
	List<JobHistory> findAll();
}