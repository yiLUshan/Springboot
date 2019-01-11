package fise3.info6.projetlu;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fise3.info6.projetlu.model.JobHistory;
import fise3.info6.projetlu.model.JobHistoryPK;
import fise3.info6.projetlu.repository.DepartmentRepository;
import fise3.info6.projetlu.repository.EmployeeRepository;
import fise3.info6.projetlu.repository.JobHistoryRepository;
import fise3.info6.projetlu.repository.JobRepository;

@Controller
public class JobHistoryCRUDController {
	JobHistoryRepository myJobHistoryRepository;
	EmployeeRepository myEmployeeRepository;
	JobRepository myJobRepository;
	DepartmentRepository myDepartmentRepository;
	@Autowired
	public void setJobHistoryService(JobHistoryRepository jobHistoryRepository) {
	    this.myJobHistoryRepository = jobHistoryRepository;
	}
	@Autowired
	public void setDepartmentService(DepartmentRepository departmentRepository) {
	    this.myDepartmentRepository = departmentRepository;
	}
	@Autowired
	public void setJobService(JobRepository jobRepository) {
	    this.myJobRepository = jobRepository;
	}
	@Autowired
	public void setEmployeeService(EmployeeRepository employeeRepository) {
	    this.myEmployeeRepository = employeeRepository;
	}
	@RequestMapping(value="/allJobHistory")
	public String showJobHistory(Model model){
		model.addAttribute("jobHistorys", myJobHistoryRepository.findAll());
		model.addAttribute("allEmployee", myEmployeeRepository.findAll());
		model.addAttribute("allDepartment", myDepartmentRepository.findAll());
		model.addAttribute("allJob", myJobRepository.findAll());
		return "allJobHistory";
	}
	@RequestMapping(value="/updateJobHistory")
	public String updateJobHistory(Model model,long employeeId,String startDate,String endDate,String jobId,long departmentId){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date myStartDate=null;
		Date myEndDate=null;
		try {
			myStartDate = sdf.parse(startDate);
			myEndDate = sdf.parse(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JobHistory thisJobHistory=myJobHistoryRepository.findByIdEmployeeIdAndIdStartDate(employeeId, myStartDate);
		thisJobHistory.setEndDate(myEndDate);
		thisJobHistory.setEmployeeBean(myEmployeeRepository.findByEmployeeId(employeeId));
		thisJobHistory.setDepartment(myDepartmentRepository.findByDepartmentId(departmentId));
		thisJobHistory.setJobBean(myJobRepository.findByJobId(jobId));
		model.addAttribute("jobHistorys", myJobHistoryRepository.findAll());
		model.addAttribute("allEmployee", myEmployeeRepository.findAll());
		model.addAttribute("allDepartment", myDepartmentRepository.findAll());
		model.addAttribute("allJob", myJobRepository.findAll());
		return "allJobHistory";
	}
	@RequestMapping(value="/addJobHistory")
	public String addJobHistory(Model model,long employeeId,String startDate,String endDate,String jobId,long departmentId){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date myStartDate=null;
		Date myEndDate=null;
		try {
			myStartDate = sdf.parse(startDate);
			myEndDate = sdf.parse(endDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JobHistory thisJobHistory=new JobHistory();
		JobHistoryPK thisJobHistoryPK=new JobHistoryPK();
		thisJobHistoryPK.setEmployeeId(employeeId);
		thisJobHistoryPK.setStartDate(myStartDate);
		thisJobHistory.setId(thisJobHistoryPK);
		thisJobHistory.setEndDate(myEndDate);
		thisJobHistory.setEmployeeBean(myEmployeeRepository.findByEmployeeId(employeeId));
		thisJobHistory.setDepartment(myDepartmentRepository.findByDepartmentId(departmentId));
		thisJobHistory.setJobBean(myJobRepository.findByJobId(jobId));
		model.addAttribute("jobHistorys", myJobHistoryRepository.findAll());
		model.addAttribute("allEmployee", myEmployeeRepository.findAll());
		model.addAttribute("allDepartment", myDepartmentRepository.findAll());
		model.addAttribute("allJob", myJobRepository.findAll());
		return "allJobHistory";
	}
}
