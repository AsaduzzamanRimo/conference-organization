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

import ac.diu.asad.conference.model.Venu;
import ac.diu.asad.conference.service.VenuService;

@Controller
public class VenuController {
	
	@Autowired
	private VenuService service;
	
	// handler methods...
		@RequestMapping("/venu")
		public String viewHomePage(Model model) {
			List<Venu> listVenu = service.listAll();
			model.addAttribute("listVenu" , listVenu);
			return "venu_index";
			
			
		}
		
		@RequestMapping("/newVenu")
		public String showNewVenuPage(Model model) {
			
			Venu venu = new Venu();
			model.addAttribute("venu" , venu);
			return "new_venu";
			
		}
		
		@RequestMapping(value = "/saveVenu" , method = RequestMethod.POST)
		public String saveVenu(@ModelAttribute("venu") Venu venu,Model model) {
			
			service.save(venu);
			List<Venu> listVenu = service.listAll();
			model.addAttribute("listVenu" , listVenu);
			return "redirect:/";
			
			
		}
		
		@RequestMapping(value = "/updateVenu" , method = RequestMethod.POST)
		public String updateVenu(@ModelAttribute("venu") Venu venu,Model model) {
			
			Venu v = service.get(venu.getVenuId());
			v.setVenuName(venu.getVenuName());
			service.save(v);
			List<Venu> listVenu = service.listAll();
			model.addAttribute("listVenu" , listVenu);
			return "redirect:/";
		}
		
		@RequestMapping("/editVenu/{id}")
				public ModelAndView showEditVenuPage(@PathVariable(name = "id") int id) {
					ModelAndView mav = new ModelAndView("edit_venu");
					Venu venu = service.get(id);
					mav.addObject("venu", venu);
					return mav;
					
					
				}
		@RequestMapping("/deleteVenu/{id}")
		public String deleteVenu(@PathVariable(name = "id") int id) {
			service.delete(id);
			return "redirect:/";
			
		}
	
	

}
