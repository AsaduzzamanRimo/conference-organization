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

import ac.diu.asad.conference.model.ClassRoom;
import ac.diu.asad.conference.service.ClassRoomService;

@Controller
public class ClassRoomController {
	
	@Autowired
	private ClassRoomService service;
	
	// handler methods...
			@RequestMapping("/classRoom")
			public String viewHomePage(Model model) {
				List<ClassRoom> listClassRoom = service.listAll();
				model.addAttribute("listClassRoom" , listClassRoom);
				return "classRoom_index";
				
				
			}
			
			@RequestMapping("/newClassRoom")
			public String showNewClassRoomPage(Model model) {
				
				ClassRoom classRoom = new ClassRoom();
				model.addAttribute("classRoom" , classRoom);
				return "new_classRoom";
				
			}
			
			@RequestMapping(value = "/saveClassRoom" , method = RequestMethod.POST)
			public String saveClassRoom(@ModelAttribute("classRoom") ClassRoom classRoom,Model model) {
				
				service.save(classRoom);
				List<ClassRoom> listClassRoom = service.listAll();
				model.addAttribute("listClassRoom" , listClassRoom);
				return "redirect:/";
				
				
			}
			
			@RequestMapping(value = "/updateClassRoom" , method = RequestMethod.POST)
			public String updateClassRoom(@ModelAttribute("venu") ClassRoom classRoom,Model model) {
				
				ClassRoom cr = service.get(classRoom.getClassRoomId());
				cr.setSeats(classRoom.getSeats());
				service.save(cr);
				List<ClassRoom> listClassRoom = service.listAll();
				model.addAttribute("listClassRoom" , listClassRoom);
				return "redirect:/";
			}
			
			@RequestMapping("/editClassRoom/{id}")
					public ModelAndView showEditClassRoomPage(@PathVariable(name = "id") int id) {
						ModelAndView mav = new ModelAndView("edit_classRoom");
						ClassRoom classRoom = service.get(id);
						mav.addObject("classRoom", classRoom);
						return mav;
						
						
					}
			@RequestMapping("/deleteClassRoom/{id}")
			public String deleteClassRoom(@PathVariable(name = "id") int id) {
				service.delete(id);
				return "redirect:/";
				
			}


}
