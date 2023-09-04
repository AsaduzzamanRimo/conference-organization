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

import ac.diu.asad.conference.model.Room;
import ac.diu.asad.conference.service.RoomService;

@Controller
public class RoomController {
	
	@Autowired
	private RoomService service;
	
	// handler methods...
			@RequestMapping("/room")
			public String viewHomePage(Model model) {
				List<Room> listRoom = service.listAll();
				model.addAttribute("listRoom" , listRoom);
				return "room_index";
				
				
			}
			
			@RequestMapping("/newRoom")
			public String showNewRoomPage(Model model) {
				
				Room room = new Room();
				model.addAttribute("room" , room);
				return "new_room";
				
			}
			
			@RequestMapping(value = "/saveRoom" , method = RequestMethod.POST)
			public String saveVenu(@ModelAttribute("room") Room room,Model model) {
				
				service.save(room);
				List<Room> listRoom = service.listAll();
				model.addAttribute("listRoom" , listRoom);
				return "redirect:/";
				
				
			}
			
			@RequestMapping(value = "/updateRoom" , method = RequestMethod.POST)
			public String updateRoom(@ModelAttribute("room") Room room,Model model) {
				
				Room r = service.get(room.getRoomNumber());
				r.setRoomCapcity(room.getRoomCapcity());//.getRoomName());
				service.save(r);
				List<Room> listRoom = service.listAll();
				model.addAttribute("listRoom" , listRoom);
				return "redirect:/";
			}
			
			@RequestMapping("/editRoom/{id}")
					public ModelAndView showEditRoomPage(@PathVariable(name = "id") int id) {
						ModelAndView mav = new ModelAndView("edit_room");
						Room room = service.get(id);
						mav.addObject("room", room);
						return mav;
						
						
					}
			@RequestMapping("/deleteRoom/{id}")
			public String deleteRoom(@PathVariable(name = "id") int id) {
				service.delete(id);
				return "redirect:/";
				
			}


}
