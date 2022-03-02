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

import ac.diu.asad.conference.model.Facilities;
import ac.diu.asad.conference.service.FacilitiesService;

@Controller
public class FacilitiesController {
	
	@Autowired
	private FacilitiesService service;
	
	// handler methods...
			@RequestMapping("/facilities")
			public String viewHomePage(Model model) {
				List<Facilities> listFacilities = service.listAll();
				model.addAttribute("listFacilities" , listFacilities);
				return "facilities_index";
				
				
			}
			
			@RequestMapping("/newFacilities")
			public String showNewFacilitiesPage(Model model) {
				
				Facilities facilities = new Facilities();
				model.addAttribute("facilities" , facilities);
				return "new_facilities";
				
			}
			
			@RequestMapping(value = "/saveFacilities" , method = RequestMethod.POST)
			public String saveFacilities(@ModelAttribute("facilities") Facilities facilities,Model model) {
				
				service.save(facilities);
				List<Facilities> listFacilities = service.listAll();
				model.addAttribute("listFacilities" , listFacilities);
				return "redirect:/";
				
				
			}
			
			@RequestMapping(value = "/updateFacilities" , method = RequestMethod.POST)
			public String updateFacilities(@ModelAttribute("facilities") Facilities facilities,Model model) {
				
				Facilities f = service.get(facilities.getFacilitiesId());
				f.setFacilitiesName(facilities.getFacilitiesName());
				service.save(f);
				List<Facilities> listFacilities = service.listAll();
				model.addAttribute("listFacilities" , listFacilities);
				return "redirect:/";
			}
			
			@RequestMapping("/editFacilities/{id}")
					public ModelAndView showEditFacilitiesPage(@PathVariable(name = "id") int id) {
						ModelAndView mav = new ModelAndView("edit_facilities");
						Facilities facilities = service.get(id);
						mav.addObject("facilities", facilities);
						return mav;
						
						
					}
			@RequestMapping("/deleteFacilities/{id}")
			public String deleteFacilities(@PathVariable(name = "id") int id) {
				service.delete(id);
				return "redirect:/";
				
			}


}
