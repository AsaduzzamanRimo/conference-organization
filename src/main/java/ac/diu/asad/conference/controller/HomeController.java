package ac.diu.asad.conference.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class HomeController {
	
	
	@RequestMapping("/")
    public String viewHomePage(Model model) {
        
         
        return "home";
    }

	@RequestMapping("/classRoom")
    public String viewClassRoomrPage(Model model) {
        
         
        return "classroomindex";
    }
	
	@RequestMapping("/conference")
    public String viewConferencePage(Model model) {
        
         
        return "conferenceindex";
    }
	
	@RequestMapping("/facilities")
    public String viewFacilitiesPage(Model model) {
        
         
        return "facilitiesindex";
    }
	
	@RequestMapping("/hallRoom")
    public String viewHallRoomPage(Model model) {
        
         
        return "hallRoomindex";
    }
	
	@RequestMapping("/labRoom")
    public String viewLabRoomPage(Model model) {
        
         
        return "labRoomindex";
    }
	
	@RequestMapping("/location")
    public String viewLocationPage(Model model) {
        
         
        return "locationindex";
    }
	
	@RequestMapping("/room")
    public String viewRoomPage(Model model) {
        
         
        return "roomindex";
    }
	
	@RequestMapping("/speaker")
    public String viewSpeakerPage(Model model) {
        
         
        return "speakerindex";
    }
	
	@RequestMapping("/timeSlot")
    public String viewTimeSlotPage(Model model) {
        
         
        return "timeSlotindex";
    }
	
	@RequestMapping("/topics")
    public String viewTopicsPage(Model model) {
        
         
        return "topicsindex";
    }
	
	@RequestMapping("/university")
    public String viewUniversityPage(Model model) {
        
         
        return "universityindex";
    }
	
	@RequestMapping("/venu")
    public String viewVenuPage(Model model) {
        
         
        return "venuindex";
    }
}
