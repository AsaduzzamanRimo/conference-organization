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

import ac.diu.asad.conference.model.HallRoom;
import ac.diu.asad.conference.service.HallRoomService;

@Controller
public class HallRoomController {
	
	@Autowired
	private HallRoomService service;
	
	// handler methods...
			@RequestMapping("/hallRoom")
			public String viewHomePage(Model model) {
				List<HallRoom> listHallRoom = service.listAll();
				model.addAttribute("listHallRoom" , listHallRoom);
				return "hallRoom_index";
				
				
			}
			
			@RequestMapping("/newHallRoom")
			public String showNewHallRoomPage(Model model) {
				
				HallRoom hallRoom = new HallRoom();
				model.addAttribute("hallRoom" , hallRoom);
				return "new_hallRoom";
				
			}
			
			@RequestMapping(value = "/saveHallRoom" , method = RequestMethod.POST)
			public String saveHallRoom(@ModelAttribute("hallRoom") HallRoom hallRoom,Model model) {
				
				service.save(hallRoom);
				List<HallRoom> listHallRoom = service.listAll();
				model.addAttribute("listHallRoom" , listHallRoom);
				return "redirect:/";
				
				
			}
			
			@RequestMapping(value = "/updateHallRoom" , method = RequestMethod.POST)
			public String updateHallRoom(@ModelAttribute("hallRoom") HallRoom hallRoom,Model model) {
				
				HallRoom hr = service.get(hallRoom.getHallId());
				hr.setHallName(hallRoom.getHallName());
				service.save(hr);
				List<HallRoom> listHallRoom = service.listAll();
				model.addAttribute("listHallRoom" , listHallRoom);
				return "redirect:/";
			}
			
			@RequestMapping("/editHallRoom/{id}")
					public ModelAndView showEditHallRoomPage(@PathVariable(name = "id") int id) {
						ModelAndView mav = new ModelAndView("edit_hallRoom");
						HallRoom hallRoom = service.get(id);
						mav.addObject("hallRoom", hallRoom);
						return mav;
						
						
					}
			@RequestMapping("/deleteHallRoom/{id}")
			public String deleteHallRoom(@PathVariable(name = "id") int id) {
				service.delete(id);
				return "redirect:/";
				
			}


}
