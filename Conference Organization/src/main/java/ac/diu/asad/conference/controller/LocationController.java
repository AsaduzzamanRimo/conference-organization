package ac.diu.asad.conference.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ac.diu.asad.conference.model.Location;
import ac.diu.asad.conference.service.LocationService;

@Controller
public class LocationController {
	
	@Autowired
	private LocationService service;
	
	
	// handler methods...
			@RequestMapping("/location")
			public String viewHomePage(Model model) {
				List<Location> listLocation = service.listAll();
				model.addAttribute("listLocation" , listLocation);
				return "location_index";
				
				
			}
			
			@RequestMapping("/newLocation")
			public String showNewLocationPage(Model model) {
				
				Location location = new Location();
				model.addAttribute("location" , location);
				return "new_location";
				
			}
			
			@RequestMapping(value = "/saveLocation" , method = RequestMethod.POST)
			public String saveLocation(@ModelAttribute("location") Location location,Model model) {
				
				service.save(location);
				List<Location> listLocation = service.listAll();
				model.addAttribute("listLocation" , listLocation);
				return "redirect:/";
				
				
			}
			
			@RequestMapping(value = "/updateLocation" , method = RequestMethod.POST)
			public String updateLocation(@ModelAttribute("location") Location location,Model model) {
				
				Location l = service.get(location.getLocationId());
				l.setLocationName(location.getLocationName());
				service.save(l);
				List<Location> listLocation = service.listAll();
				model.addAttribute("listLocation" , listLocation);
				return "redirect:/";
			}
			
			@RequestMapping("/editLocation/{id}")
					public ModelAndView showEditLocationPage(@PathVariable(name = "id") int id) {
						ModelAndView mav = new ModelAndView("edit_location");
						Location location = service.get(id);
						mav.addObject("location", location);
						return mav;
						
						
					}
			@RequestMapping("/deleteLocation/{id}")
			public String deleteVenu(@PathVariable(name = "id") int id) {
				service.delete(id);
				return "redirect:/";
				
			}


}
