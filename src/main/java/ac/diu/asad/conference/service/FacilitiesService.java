package ac.diu.asad.conference.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.diu.asad.conference.model.Facilities;
import ac.diu.conference.repository.FacilitiesRepository;

@Service
@Transactional
public class FacilitiesService {
	
	@Autowired
	private FacilitiesRepository repo;
	
	
	public List<Facilities> listAll(){
		
		return (List<Facilities>) repo.findAll();
	}
	public void save(Facilities facilities) {
		
		repo.save(facilities);
	}
	
	public Facilities get(long id) {
		return repo.findById(id);
		
	}
	
	public void delete(long id) {
        repo.deleteById(id);
    }

}
