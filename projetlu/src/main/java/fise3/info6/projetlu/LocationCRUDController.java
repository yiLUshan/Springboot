package fise3.info6.projetlu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import fise3.info6.projetlu.model.*;
import fise3.info6.projetlu.repository.CountryRepository;
import fise3.info6.projetlu.repository.LocationRepository;

@Controller
public class LocationCRUDController {
	private LocationRepository myLocationRepository;
	private CountryRepository myCountryRepository;
	@Autowired
	public void setLocationService(LocationRepository locationRepository) {
	    this.myLocationRepository = locationRepository;
	}
	@Autowired
	public void setCountryService(CountryRepository countryRepository) {
	    this.myCountryRepository = countryRepository;
	}
	@RequestMapping(value="/allLocation")
	public String showLocation(Model model){
		model.addAttribute("locations", myLocationRepository.findAll());
		model.addAttribute("allCountry", myCountryRepository.findAll());
		return "allLocation";
	}
	@RequestMapping(value="/updateLocation")
	public String updateLocation(Model model,long locationId,String streetAddress,String postalCode,String city,String stateProvince,String countryId){
		Location thisLocation=myLocationRepository.findByLocationId(locationId);
		thisLocation.setLocationId(locationId);
		thisLocation.setCity(city);
		thisLocation.setPostalCode(postalCode);
		thisLocation.setStateProvince(stateProvince);
		thisLocation.setStreetAddress(streetAddress);
		Country thisCountry=myCountryRepository.findByCountryId(countryId);
		thisLocation.setCountry(thisCountry);
		myLocationRepository.save(thisLocation);
		model.addAttribute("locations", myLocationRepository.findAll());
		model.addAttribute("allCountry", myCountryRepository.findAll());
		return "allLocation";
	}
	@RequestMapping(value="/addLocation")
	public String addLocation(Model model,long locationId,String streetAddress,String postalCode,String city,String stateProvince,String countryId){
		Location thisLocation=new Location();
		thisLocation.setLocationId(locationId);
		thisLocation.setCity(city);
		thisLocation.setPostalCode(postalCode);
		thisLocation.setStateProvince(stateProvince);
		thisLocation.setStreetAddress(streetAddress);
		Country thisCountry=myCountryRepository.findByCountryId(countryId);
		thisLocation.setCountry(thisCountry);
		myLocationRepository.save(thisLocation);
		model.addAttribute("locations", myLocationRepository.findAll());
		model.addAttribute("allCountry", myCountryRepository.findAll());
		return "allLocation";
	}
}
