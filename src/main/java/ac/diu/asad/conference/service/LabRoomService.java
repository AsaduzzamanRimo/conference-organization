package ac.diu.asad.conference.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.diu.asad.conference.model.LabRoom;
import ac.diu.conference.repository.LabRoomRepository;

@Service
@Transactional
public class LabRoomService {
	
	@Autowired
	private LabRoomRepository repo;
	
	
	public List<LabRoom> listAll(){
		
		return (List<LabRoom>) repo.findAll();
	}
	public void save(LabRoom labRoom) {
		
		repo.save(labRoom);
	}
	
	public LabRoom get(long id) {
		return repo.findById(id);
		
	}
	
	public void delete(long id) {
        repo.deleteById(id);
    }

}
