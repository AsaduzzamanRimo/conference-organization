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

import ac.diu.asad.conference.model.Conference;
import ac.diu.asad.conference.service.ConferenceService;

@Controller
public class ConferenceController {
	
	@Autowired
	private ConferenceService service;
	
	// handler methods...
			@RequestMapping("/conference")
			public String viewHomePage(Model model) {
				List<Conference> listConference = service.listAll();
				model.addAttribute("listConference" , listConference);
				return "conference_index";
				
				
			}
			
			@RequestMapping("/newConference")
			public String showNewConferencePage(Model model) {
				
				Conference conference = new Conference();
				model.addAttribute("conference" , conference);
				return "new_conference";
				
			}
			
			@RequestMapping(value = "/saveConference" , method = RequestMethod.POST)
			public String saveConference(@ModelAttribute("conference") Conference conference,Model model) {
				
				service.save(conference);
				List<Conference> listConference = service.listAll();
				model.addAttribute("listConference" , listConference);
				return "redirect:/";
				
				
			}
			
			@RequestMapping(value = "/updateConference" , method = RequestMethod.POST)
			public String updateConference(@ModelAttribute("conference") Conference conference,Model model) {
				
				Conference c = service.get(conference.getConferenceId());
				c.setStartDate(conference.getStartDate());
				c.setEndDate(conference.getEndDate());
				service.save(c);
				List<Conference> listConference = service.listAll();
				model.addAttribute("listConference" , listConference);
				return "redirect:/";
			}
			
			@RequestMapping("/editConference/{id}")
					public ModelAndView showEditConferencePage(@PathVariable(name = "id") int id) {
						ModelAndView mav = new ModelAndView("edit_conference");
						Conference conference = service.get(id);
						mav.addObject("conference", conference);
						return mav;
						
						
					}
			@RequestMapping("/deleteConference/{id}")
			public String deleteConference(@PathVariable(name = "id") int id) {
				service.delete(id);
				return "redirect:/";
				
			}


}
