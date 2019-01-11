package fise3.info6.projetlu;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fise3.info6.projetlu.model.*;
import fise3.info6.projetlu.repository.JobRepository;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/jobs")
public class JobController {
	private final JobRepository repository;
	
	JobController(JobRepository repository) {
		// TODO Auto-generated constructor stub
		this.repository = repository;
	}
	
	//Aggregate root
	@ApiOperation(value="get job list", notes="")
	@GetMapping("")
	List<Job> all(){
		return repository.findAll();
	}
	@ApiOperation(value="create new job", notes="create job with object Job")
    @ApiImplicitParam(name = "newJob", value = "Job instance newJob", required = true, dataType = "Job")
	@PostMapping("")
	Job newJob(@RequestBody Job newJob){
		return repository.save(newJob);
	}
/*	@ApiOperation(value="get job details", notes="get details according to JobId in url")
	@ApiImplicitParam(name = "jobId", value = "jobId", required = true, dataType = "String")
	@GetMapping("/{jobId}")
	Job one(@PathVariable String jobId){
		return repository.findById(jobId).orElseThrow(() -> new RuntimeException());
	}
	*/
	@ApiOperation(value="update job details", notes="update details according to JobId in url")
	@ApiImplicitParams({
        @ApiImplicitParam(name = "jobId", value = "jobId", required = true, dataType = "String"),
        @ApiImplicitParam(name = "newJob", value = "Job instance newJob", required = true, dataType = "Job")
})
	@PutMapping("/{jobId}")
	Job replaceJob(@RequestBody Job newJob,@PathVariable String jobId){
		return repository.findById(jobId)
				.map(job->{
					job.setJobTitle(newJob.getJobTitle());
					job.setMaxSalary(newJob.getMaxSalary());
					job.setMinSalary(newJob.getMinSalary());
					return repository.save(job);
				}).orElseGet(()->{
					newJob.setJobId(jobId);
					return repository.save(newJob);
				});
	}
	@ApiOperation(value="delete job", notes="delete job according to JobId in url")
    @ApiImplicitParam(name = "jobId", value = "jobId", required = true, dataType = "String")
	@DeleteMapping("/{jobId}")
	void deleteJob(@PathVariable String jobId){
		repository.deleteById(jobId);
	}
	
	@ApiOperation(value="get job list with certain minSalary",notes="")
	@PostMapping(value="/minSalary")
	public List<Job> searchJobSalary(@RequestBody BigDecimal minSalary){
		return repository.findAllByMinSalaryGreaterThanOrderByMaxSalaryDesc(minSalary);
	} 
}
