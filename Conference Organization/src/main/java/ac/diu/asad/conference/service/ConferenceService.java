package ac.diu.asad.conference.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.diu.asad.conference.model.Conference;
import ac.diu.conference.repository.ConferenceRepository;

@Service
@Transactional
public class ConferenceService {
	
	@Autowired
	private ConferenceRepository repo;
	
	
	public List<Conference> listAll(){
		
		return (List<Conference>) repo.findAll();
	}
	public void save(Conference conference) {
		
		repo.save(conference);
	}
	
	public Conference get(long id) {
		return repo.findById(id);
		
	}
	
	public void delete(long id) {
        repo.deleteById(id);
    }

}
