package fise3.info6.projetlu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fise3.info6.projetlu.model.Region;
import fise3.info6.projetlu.repository.RegionRepository;

@Controller
public class RegionCRUDController {
	private RegionRepository myRegionRepository;
	@Autowired
	public void setRegionService(RegionRepository regionRepository) {
	    this.myRegionRepository = regionRepository;
	}
	@RequestMapping(value="/allRegion")
	public String showRegion(Model model){
		model.addAttribute("regions", myRegionRepository.findAll());
		return "allRegion";
	}
	@RequestMapping(value="/updateRegion")
	public String updateRegion(Model model,long regionId,String regionName){
		Region thisRegion=myRegionRepository.findByRegionId(regionId);
		thisRegion.setRegionId(regionId);
		thisRegion.setRegionName(regionName);
		myRegionRepository.save(thisRegion);
		model.addAttribute("regions", myRegionRepository.findAll());
		return "allRegion";
	}
	@RequestMapping(value="/addRegion")
	public String addRegion(Model model,long regionId,String regionName){
		Region thisRegion=new Region();
		thisRegion.setRegionId(regionId);
		thisRegion.setRegionName(regionName);
		myRegionRepository.save(thisRegion);
		model.addAttribute("regions", myRegionRepository.findAll());
		return "allRegion";
	}
}