package fise3.info6.projetlu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fise3.info6.projetlu.model.*;
import fise3.info6.projetlu.repository.CountryRepository;
import fise3.info6.projetlu.repository.RegionRepository;

@Controller
public class CountryCRUDController {
	private CountryRepository myCountryRepository;
	private RegionRepository myRegionRepository;
	@Autowired
	public void setCountryService(CountryRepository countryService) {
	    this.myCountryRepository = countryService;
	}
	@Autowired
	public void setRegionService(RegionRepository regionService) {
	    this.myRegionRepository = regionService;
	}
	@RequestMapping(value="/allCountry")
	public String showCountry(Model model){
		model.addAttribute("countries", myCountryRepository.findAll());
		model.addAttribute("allRegion", myRegionRepository.findAll());
		return "allCountry";
	}
	@RequestMapping(value="/updateCountry")
	public String updateCountry(Model model,String countryId,String countryName,long regionId){
		Country thisCountry=myCountryRepository.findByCountryId(countryId);
		thisCountry.setCountryId(countryId);
		thisCountry.setCountryName(countryName);
		Region thisRegion=myRegionRepository.findByRegionId(regionId);
		thisCountry.setRegion(thisRegion);
		myCountryRepository.save(thisCountry);
		model.addAttribute("countries", myCountryRepository.findAll());
		model.addAttribute("allRegion", myRegionRepository.findAll());
		return "allCountry";
	}
	@RequestMapping(value="/addCountry")
	public String addCountry(Model model,String countryId,String countryName,long regionId){
		Country thisCountry=new Country();
		thisCountry.setCountryId(countryId);
		thisCountry.setCountryName(countryName);
		Region thisRegion=myRegionRepository.findByRegionId(regionId);
		thisCountry.setRegion(thisRegion);
		myCountryRepository.save(thisCountry);
		model.addAttribute("countries", myCountryRepository.findAll());
		model.addAttribute("allRegion", myRegionRepository.findAll());
		return "allCountry";
	}
}

