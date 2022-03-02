package ac.diu.asad.conference.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.diu.asad.conference.model.Speaker;
import ac.diu.conference.repository.SpeakerRepository;

@Service
@Transactional
public class SpeakerService {
	
	@Autowired
	private SpeakerRepository repo;
	
	public List<Speaker> listAll(){
		
		return (List<Speaker>) repo.findAll();
	}
	public void save(Speaker speaker) {
		
		repo.save(speaker);
	}
	
	public Speaker get(long id) {
		return repo.findById(id);
		
	}
	
	public void delete(long id) {
        repo.deleteById(id);
    }

}
