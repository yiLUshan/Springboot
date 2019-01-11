package fise3.info6.projetlu;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fise3.info6.projetlu.model.Department;
import fise3.info6.projetlu.model.Location;
import fise3.info6.projetlu.repository.DepartmentRepository;
import fise3.info6.projetlu.repository.LocationRepository;

@Controller
public class DepartmentCRUDController {
	private DepartmentRepository myDepartmentService;
	private LocationRepository myLocationService;
	@Autowired
	public void setDepartmentService(DepartmentRepository departmentService) {
	    this.myDepartmentService = departmentService;
	}
	@Autowired
	public void setLocationService(LocationRepository locationService) {
	    this.myLocationService = locationService;
	}
	@RequestMapping(value="/allDepartment")
	public String showDepartment(Model model){
		model.addAttribute("departments", myDepartmentService.findAll());
		model.addAttribute("allLocation", myLocationService.findAll());
		return "allDepartment";
	}
	@RequestMapping(value="/updateDepartment")
	public String updateDepartment(Model model,long departmentId,String departmentName,BigDecimal managerId,long locationId){
		Department thisDepartment=myDepartmentService.findByDepartmentId(departmentId);
		thisDepartment.setDepartmentId(departmentId);
		thisDepartment.setDepartmentName(departmentName);
		thisDepartment.setManagerId(managerId);
		Location thisLocation=myLocationService.findByLocationId(locationId);
		thisDepartment.setLocation(thisLocation);
		myDepartmentService.save(thisDepartment);
		model.addAttribute("departments", myDepartmentService.findAll());
		model.addAttribute("allLocation", myLocationService.findAll());
		return "allDepartment";
	}
	@RequestMapping(value="/addDepartment")
	public String addDepartment(Model model,long departmentId,String departmentName,BigDecimal managerId,long locationId){
		Department thisDepartment=new Department();
		thisDepartment.setDepartmentId(departmentId);
		thisDepartment.setDepartmentName(departmentName);
		thisDepartment.setManagerId(managerId);
		Location thisLocation=myLocationService.findByLocationId(locationId);
		thisDepartment.setLocation(thisLocation);
		myDepartmentService.save(thisDepartment);
		model.addAttribute("departments", myDepartmentService.findAll());
		model.addAttribute("allLocation", myLocationService.findAll());
		return "allDepartment";
	}
}
