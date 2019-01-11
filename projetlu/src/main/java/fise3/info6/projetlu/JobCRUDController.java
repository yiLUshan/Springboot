package fise3.info6.projetlu;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fise3.info6.projetlu.model.Job;
import fise3.info6.projetlu.repository.JobRepository;

@Controller
public class JobCRUDController {
	JobRepository myJobRepository;
	@Autowired
	public void setJobRepository(JobRepository jobRepository) {
	    this.myJobRepository = jobRepository;
	}
	@RequestMapping(value="/allJob")
	public String showCountry(Model model){
		model.addAttribute("jobs", myJobRepository.findAll());
		return "allJob";
	}
	@RequestMapping(value="/updateJob")
	public String updateJob(Model model,String jobId,String jobTitle,BigDecimal minSalary,BigDecimal maxSalary){
		Job thisJob=myJobRepository.findByJobId(jobId);
		thisJob.setJobId(jobId);
		thisJob.setJobTitle(jobTitle);
		thisJob.setMaxSalary(maxSalary);
		thisJob.setMinSalary(minSalary);
		myJobRepository.save(thisJob);
		model.addAttribute("jobs", myJobRepository.findAll());
		return "allJob";
	}
	@RequestMapping(value="/addJob")
	public String addJob(Model model,String jobId,String jobTitle,BigDecimal minSalary,BigDecimal maxSalary){
		Job thisJob=new Job();
		thisJob.setJobId(jobId);
		thisJob.setJobTitle(jobTitle);
		thisJob.setMaxSalary(maxSalary);
		thisJob.setMinSalary(minSalary);
		myJobRepository.save(thisJob);
		model.addAttribute("jobs", myJobRepository.findAll());
		return "allJob";
	}
}

