package fise3.info6.projetlu;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fise3.info6.projetlu.model.Department;
import fise3.info6.projetlu.model.Employee;
import fise3.info6.projetlu.model.Job;
import fise3.info6.projetlu.repository.DepartmentRepository;
import fise3.info6.projetlu.repository.EmployeeRepository;
import fise3.info6.projetlu.repository.JobRepository;

@Controller
public class EmployeeCRUDController {
	private DepartmentRepository myDepartmentService;
	private JobRepository myJobService;
	private EmployeeRepository myEmployeeService;
	@Autowired
	public void setDepartmentService(DepartmentRepository departmentService) {
	    this.myDepartmentService = departmentService;
	}
	@Autowired
	public void setJobService(JobRepository jobService) {
	    this.myJobService = jobService;
	}
	@Autowired
	public void setEmployeeService(EmployeeRepository employeeService) {
	    this.myEmployeeService = employeeService;
	}
	@RequestMapping(value="/allEmployee")
	public String showEmployee(Model model){
		model.addAttribute("employees", myEmployeeService.findAll());
		model.addAttribute("allDepartment", myDepartmentService.findAll());
		model.addAttribute("allJob", myJobService.findAll());
		return "allEmployee";
	}
	@RequestMapping(value="/updateEmployee")
	public String updateEmployee(Model model,long employeeId,String firstName,String lastName,String email,
			String phoneNumber,String hireDate,String jobId,BigDecimal salary,BigDecimal commissionPct,BigDecimal managerId,long departmentId){
		Employee thisEmployee=myEmployeeService.findByEmployeeId(employeeId);
		thisEmployee.setEmployeeId(employeeId);
		thisEmployee.setFirstName(firstName);
		thisEmployee.setLastName(lastName);
		thisEmployee.setEmail(email);
		thisEmployee.setPhoneNumber(phoneNumber);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date myDate=null;
		try {
			myDate = sdf.parse(hireDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thisEmployee.setHireDate(myDate);
		thisEmployee.setSalary(salary);
		thisEmployee.setCommissionPct(commissionPct);
		thisEmployee.setManagerId(managerId);
		Job thisJob=myJobService.findByJobId(jobId);
		thisEmployee.setJobBean(thisJob);
		Department thisDepartment=myDepartmentService.findByDepartmentId(departmentId);
		thisEmployee.setDepartment(thisDepartment);
		myEmployeeService.save(thisEmployee);
		model.addAttribute("employees", myEmployeeService.findAll());
		model.addAttribute("allDepartment", myDepartmentService.findAll());
		model.addAttribute("allJob", myJobService.findAll());
		return "allEmployee";
	}
	@RequestMapping(value="/addEmployee")
	public String addEmployee(Model model,long employeeId,String firstName,String lastName,String email,
			String phoneNumber,String hireDate,String jobId,BigDecimal salary,BigDecimal commissionPct,BigDecimal managerId,long departmentId){
		Employee thisEmployee=new Employee();
		thisEmployee.setEmployeeId(employeeId);
		thisEmployee.setFirstName(firstName);
		thisEmployee.setLastName(lastName);
		thisEmployee.setEmail(email);
		thisEmployee.setPhoneNumber(phoneNumber);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date myDate=null;
		try {
			myDate = sdf.parse(hireDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		thisEmployee.setHireDate(myDate);
		thisEmployee.setSalary(salary);
		thisEmployee.setCommissionPct(commissionPct);
		thisEmployee.setManagerId(managerId);
		Job thisJob=myJobService.findByJobId(jobId);
		thisEmployee.setJobBean(thisJob);
		Department thisDepartment=myDepartmentService.findByDepartmentId(departmentId);
		thisEmployee.setDepartment(thisDepartment);
		myEmployeeService.save(thisEmployee);
		model.addAttribute("employees", myEmployeeService.findAll());
		model.addAttribute("allDepartment", myDepartmentService.findAll());
		model.addAttribute("allJob", myJobService.findAll());
		return "allEmployee";
	}
}
