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

import ac.diu.asad.conference.model.University;
import ac.diu.asad.conference.service.UniversityService;

@Controller
public class UniversityController {
	
	@Autowired
	private UniversityService service;
	
	
	// handler methods...
			@RequestMapping("/university")
			public String viewHomePage(Model model) {
				List<University> listUniversity = service.listAll();
				model.addAttribute("listUniversity" , listUniversity);
				return "university_index";
				
				
			}
			
			@RequestMapping("/newUniversity")
			public String showNewUniversityPage(Model model) {
				
				University university = new University();
				model.addAttribute("university" , university);
				return "new_university";
				
			}
			
			@RequestMapping(value = "/saveUniversity" , method = RequestMethod.POST)
			public String saveUniversity(@ModelAttribute("university") University university,Model model) {
				
				service.save(university);
				List<University> listUniversity = service.listAll();
				model.addAttribute("listUniversity" , listUniversity);
				return "redirect:/";
				
				
			}
			
			@RequestMapping(value = "/updateUniversity" , method = RequestMethod.POST)
			public String updateUniversity(@ModelAttribute("university") University university,Model model) {
				
				University u = service.get(university.getUniversityId());
				u.setUniversityName(university.getUniversityName());
				service.save(u);
				List<University> listUniversity = service.listAll();
				model.addAttribute("listUniversity" , listUniversity);
				return "redirect:/";
			}
			
			@RequestMapping("/editUniversity/{id}")
					public ModelAndView showEditUniversityPage(@PathVariable(name = "id") int id) {
						ModelAndView mav = new ModelAndView("edit_university");
						University university = service.get(id);
						mav.addObject("university", university);
						return mav;
						
						
					}
			@RequestMapping("/deleteUniversity/{id}")
			public String deleteUniversity(@PathVariable(name = "id") int id) {
				service.delete(id);
				return "redirect:/";
				
			}

	
	

}
