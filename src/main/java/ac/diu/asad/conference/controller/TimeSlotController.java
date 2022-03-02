package ac.diu.asad.conference.controller;

import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ac.diu.asad.conference.model.TimeSlot;
import ac.diu.asad.conference.service.TimeSlotService;

@Controller
public class TimeSlotController {
	
	@Autowired
	private TimeSlotService service;
	
	
	// handler methods...
			@RequestMapping("/timeSlot")
			public String viewHomePage(Model model) {
				List<TimeSlot> listTimeSlot = service.listAll();
				model.addAttribute("listTimeSlot" , listTimeSlot);
				return "timeSlot_index";
				
				
			}
			
			@RequestMapping("/newTimeSlot")
			public String showNewTimeSlotPage(Model model) {
				
				TimeSlot timeSlot = new TimeSlot();
				model.addAttribute("timeSlot" , timeSlot);
				return "new_timeSlot";
				
			}
			
			@RequestMapping(value = "/saveTimeSlot" , method = RequestMethod.POST)
			public String saveTimeSlot(@ModelAttribute("timeSlot") TimeSlot timeSlot,Model model) {
				
				service.save(timeSlot);
				List<TimeSlot> listTimeSlot = service.listAll();
				model.addAttribute("listTimeSlot" , listTimeSlot);
				return "redirect:/";
				
				
			}
			
			@RequestMapping(value = "/updateTimeSlot" , method = RequestMethod.POST)
			public String updateTimeSlot(@ModelAttribute("timeSlot") TimeSlot timeSlot,Model model) {
				
				TimeSlot ts = service.get(timeSlot.getTimeSlotId());
				ts.setTimeSlot(timeSlot.getTimeSlot());
				service.save(ts);
				List<TimeSlot> listTimeSlot = service.listAll();
				model.addAttribute("listTimeSlot" , listTimeSlot);
				return "redirect:/";
			}
			
			@RequestMapping("/editTimeSlot/{id}")
					public ModelAndView showEditTimeSlotPage(@PathVariable(name = "id") int id) {
						ModelAndView mav = new ModelAndView("edit_timeSlot");
						TimeSlot timeSlot = service.get(id);
						mav.addObject("timeSlot", timeSlot);
						return mav;
						
						
					}
			@RequestMapping("/deleteTimeSlot/{id}")
			public String deleteTimeSlot(@PathVariable(name = "id") int id) {
				service.delete(id);
				return "redirect:/";
				
			}


}
