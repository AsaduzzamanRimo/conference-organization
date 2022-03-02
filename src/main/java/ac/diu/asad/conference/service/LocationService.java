package ac.diu.asad.conference.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.diu.asad.conference.model.Location;
import ac.diu.conference.repository.LocationRepository;

@Service
@Transactional
public class LocationService {
	
	@Autowired
	private LocationRepository repo;
	
	
	public List<Location> listAll(){
		
		return (List<Location>) repo.findAll();
	}
	public void save(Location location) {
		
		repo.save(location);
	}
	
	public Location get(long id) {
		return repo.findById(id);
		
	}
	
	public void delete(long id) {
        repo.deleteById(id);
    }

}
