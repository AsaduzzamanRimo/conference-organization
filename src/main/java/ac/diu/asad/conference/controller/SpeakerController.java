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

import ac.diu.asad.conference.model.Speaker;
import ac.diu.asad.conference.service.SpeakerService;

@Controller
public class SpeakerController {
	
	@Autowired
	private SpeakerService service;
	
	
	// handler methods...
			@RequestMapping("/speaker")
			public String viewHomePage(Model model) {
				List<Speaker> listSpeaker = service.listAll();
				model.addAttribute("listSpeaker" , listSpeaker);
				return "speaker_index";
				
				
			}
			
			@RequestMapping("/newSpeaker")
			public String showNewSpeakerPage(Model model) {
				
				Speaker speaker = new Speaker();
				model.addAttribute("speaker" , speaker);
				return "new_speaker";
				
			}
			
			@RequestMapping(value = "/saveSpeaker" , method = RequestMethod.POST)
			public String saveSpeaker(@ModelAttribute("speaker") Speaker speaker,Model model) {
				
				service.save(speaker);
				List<Speaker> listSpeaker = service.listAll();
				model.addAttribute("listSpeaker" , listSpeaker);
				return "redirect:/";
				
				
			}
			
			@RequestMapping(value = "/updateSpeaker" , method = RequestMethod.POST)
			public String updateSpeaker(@ModelAttribute("speaker") Speaker speaker,Model model) {
				
				Speaker s = service.get(speaker.getSpeakerId());
				s.setSpeakerName(speaker.getSpeakerName());
				service.save(s);
				List<Speaker> listSpeaker = service.listAll();
				model.addAttribute("listSpeaker" , listSpeaker);
				return "redirect:/";
			}
			
			@RequestMapping("/editSpeaker/{id}")
					public ModelAndView showEditSpeakerPage(@PathVariable(name = "id") int id) {
						ModelAndView mav = new ModelAndView("edit_speaker");
						Speaker speaker = service.get(id);
						mav.addObject("speaker", speaker);
						return mav;
						
						
					}
			@RequestMapping("/deleteSpeaker/{id}")
			public String deleteSpeaker(@PathVariable(name = "id") int id) {
				service.delete(id);
				return "redirect:/";
				
			}


}
