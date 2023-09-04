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

import ac.diu.asad.conference.model.LabRoom;
import ac.diu.asad.conference.service.LabRoomService;

@Controller
public class LabRoomController {
	
	@Autowired
	private LabRoomService service;
	
	// handler methods...
			@RequestMapping("/labRoom")
			public String viewHomePage(Model model) {
				List<LabRoom> listLabRoom = service.listAll();
				model.addAttribute("listLabRoom" , listLabRoom);
				return "labRoom_index";
				
				
			}
			
			@RequestMapping("/newLabRoom")
			public String showNewLabRoomPage(Model model) {
				
				LabRoom labRoom = new LabRoom();
				model.addAttribute("labRoom" , labRoom);
				return "new_labRoom";
				
			}
			
			@RequestMapping(value = "/saveLabRoom" , method = RequestMethod.POST)
			public String saveLabRoom(@ModelAttribute("labRoom") LabRoom labRoom,Model model) {
				
				service.save(labRoom);
				List<LabRoom> listLabRoom = service.listAll();
				model.addAttribute("listLabRoom" , listLabRoom);
				return "redirect:/";
				
				
			}
			
			@RequestMapping(value = "/updateLabRoom" , method = RequestMethod.POST)
			public String updateLabRoom(@ModelAttribute("labRoom") LabRoom labRoom,Model model) {
				
				LabRoom lr = service.get(labRoom.getLabId());
				lr.setLabSubject(labRoom.getLabSubject());
				service.save(lr);
				List<LabRoom> listLabRoom = service.listAll();
				model.addAttribute("listLabRoom" , listLabRoom);
				return "redirect:/";
			}
			
			@RequestMapping("/editLabRoom/{id}")
					public ModelAndView showEditLabRoomPage(@PathVariable(name = "id") int id) {
						ModelAndView mav = new ModelAndView("edit_labRoom");
						LabRoom labRoom = service.get(id);
						mav.addObject("labRoom", labRoom);
						return mav;
						
						
					}
			@RequestMapping("/deleteLabRoom/{id}")
			public String deleteLabRoom(@PathVariable(name = "id") int id) {
				service.delete(id);
				return "redirect:/";
				
			}


}
