package ac.diu.asad.conference.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.diu.asad.conference.model.University;
import ac.diu.conference.repository.UniversityRepository;

@Service
@Transactional
public class UniversityService {
	
	@Autowired
	private UniversityRepository repo;
	
	public List<University> listAll(){
		
		return (List<University>) repo.findAll();
	}
	public void save(University university) {
		
		repo.save(university);
	}
	
	public University get(long id) {
		return repo.findById(id);
		
	}
	
	public void delete(long id) {
        repo.deleteById(id);
    }

}
