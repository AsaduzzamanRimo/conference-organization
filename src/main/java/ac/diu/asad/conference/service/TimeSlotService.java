package ac.diu.asad.conference.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.diu.asad.conference.model.TimeSlot;
import ac.diu.conference.repository.TimeSlotRepository;

@Service
@Transactional
public class TimeSlotService {
	
	@Autowired
	private TimeSlotRepository repo;
	
	public List<TimeSlot> listAll(){
		
		return (List<TimeSlot>) repo.findAll();
	}
	public void save(TimeSlot timeSlot) {
		
		repo.save(timeSlot);
	}
	
	public TimeSlot get(int id) {
		return repo.findById(id);
		
	}
	
	public void delete(long id) {
        repo.deleteById(id);
    }

}
