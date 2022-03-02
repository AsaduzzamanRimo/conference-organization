package ac.diu.asad.conference.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.diu.asad.conference.model.Topics;
import ac.diu.conference.repository.TopicsRepository;

@Service
@Transactional
public class TopicsService {
	
	@Autowired
	private TopicsRepository repo;
	
	public List<Topics> listAll(){
		
		return (List<Topics>) repo.findAll();
	}
	public void save(Topics topics) {
		
		repo.save(topics);
	}
	
	public Topics get(long id) {
		return repo.findById(id);
		
	}
	
	public void delete(long id) {
        repo.deleteById(id);
    }

}
