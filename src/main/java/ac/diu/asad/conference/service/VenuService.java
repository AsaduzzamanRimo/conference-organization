package ac.diu.asad.conference.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.diu.asad.conference.model.Venu;
import ac.diu.conference.repository.VenuRepository;

@Service
@Transactional
public class VenuService {
	
	@Autowired
	private VenuRepository repo;
	
public List<Venu> listAll(){
		
		return (List<Venu>) repo.findAll();
	}
	public void save(Venu venu) {
		
		repo.save(venu);
	}
	
	public Venu get(long id) {
		return repo.findById(id);
		
	}
	
	public void delete(long id) {
        repo.deleteById(id);
    }

}
