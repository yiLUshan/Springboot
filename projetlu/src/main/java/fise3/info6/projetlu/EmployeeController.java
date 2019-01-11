package fise3.info6.projetlu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fise3.info6.projetlu.model.*;
import fise3.info6.projetlu.repository.EmployeeRepository;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;

@RestController
@RequestMapping(value="/employee")
public class EmployeeController {
private EmployeeRepository myEmployeeService;
	
	@Autowired
	public void setEmployeeService(EmployeeRepository employeeService) {
	    this.myEmployeeService = employeeService;
	}
	@ApiOperation(value="find the employee by the first name",response=Iterable.class)
	@RequestMapping(value = "/find",method=RequestMethod.POST)
    public List<EmployeeDTO> findbyfirstname(@RequestBody String firstname){
		List<Employee> employeeList = myEmployeeService.findByFirstName(firstname);
        List<EmployeeDTO> employeeDTOList=new ArrayList<EmployeeDTO>();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.addMappings(employeeMap);
        for (Employee e : employeeList) {  
        	EmployeeDTO dto = modelMapper.map(e, EmployeeDTO.class);  
        	employeeDTOList.add(dto);  
        }
        return employeeDTOList;
    }

	PropertyMap<Employee,EmployeeDTO> employeeMap = new PropertyMap<Employee, EmployeeDTO>() {  
	      protected void configure() {  
	          map().setFirstName(source.getFirstName());  
	          map().setLastName(source.getLastName());  
	          map().setDepartmentName(source.getDepartment().getDepartmentName()); 
	      }  
	};
}