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

import ac.diu.asad.conference.model.Topics;
import ac.diu.asad.conference.service.TopicsService;

@Controller
public class TopicsController {
	
	@Autowired
	private TopicsService service;
	
	// handler methods...
			@RequestMapping("/topics")
			public String viewHomePage(Model model) {
				List<Topics> listTopics = service.listAll();
				model.addAttribute("listTopics" , listTopics);
				return "topics_index";
				
				
			}
			
			@RequestMapping("/newTopics")
			public String showNewTopicsPage(Model model) {
				
				Topics topics = new Topics();
				model.addAttribute("topics" , topics);
				return "new_topics";
				
			}
			
			@RequestMapping(value = "/saveTopics" , method = RequestMethod.POST)
			public String saveTopics(@ModelAttribute("topics") Topics topics,Model model) {
				
				service.save(topics);
				List<Topics> listTopics = service.listAll();
				model.addAttribute("listTopics" , listTopics);
				return "redirect:/";
				
				
			}
			
			@RequestMapping(value = "/updateTopics" , method = RequestMethod.POST)
			public String updateTopics(@ModelAttribute("topics") Topics topics,Model model) {
				
				Topics t = service.get(topics.getTopicsId());
				t.setTopicsName(topics.getTopicsName());
				service.save(t);
				List<Topics> listTopics = service.listAll();
				model.addAttribute("listTopics" , listTopics);
				return "redirect:/";
			}
			
			@RequestMapping("/editTopics/{id}")
					public ModelAndView showEditTopicsPage(@PathVariable(name = "id") int id) {
						ModelAndView mav = new ModelAndView("edit_topics");
						Topics topics = service.get(id);
						mav.addObject("topics", topics);
						return mav;
						
						
					}
			@RequestMapping("/deleteTopics/{id}")
			public String deleteTopics(@PathVariable(name = "id") int id) {
				service.delete(id);
				return "redirect:/";
				
			}


}
