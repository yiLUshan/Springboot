package fise3.info6.projetlu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fise3.info6.projetlu.model.Employee;
import fise3.info6.projetlu.repository.EmployeeRepository;

import java.math.BigDecimal;


@Controller
public class EmployeeSalaryController {
	private EmployeeRepository myEmployeeRepository;
	@Autowired
	public void setEmployeeService(EmployeeRepository employeeService) {
	    this.myEmployeeRepository = employeeService;
	}
	 @RequestMapping(value="/salary")
	 public String showSalary(Model model){
		    int rowCount = (int)myEmployeeRepository.count();
		    Object[][] result = new Object[rowCount][3];

		    int i = 0;
		    for (Employee e : myEmployeeRepository.findAll()){
		        result[i][0] = e.getFirstName();
		        result[i][1] = e.getLastName();
		        result[i][2] = e.getSalary();
		        i++;
		    }
		    model.addAttribute("allSalary",result);
		 return "salary";
	 }
	 @RequestMapping(value="/salaryDistributed")
	 public String showSalaryDistribued(Model model){
		 Object[][] result=new Object[10][2];
		 int i;
		 for(i=0;i<10;i++){
			 result[i][0]=String.valueOf(i*2500)+"-"+String.valueOf(i*2500+2500);
			 result[i][1]=(int)myEmployeeRepository.countBySalaryBetween(BigDecimal.valueOf(i*2500), BigDecimal.valueOf(i*2500+2500));
		 }
		 model.addAttribute("salaryDistribued",result);
		 return "salaryDistributed";
	 }
}

