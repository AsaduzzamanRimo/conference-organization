package ac.diu.asad.conference.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.diu.asad.conference.model.HallRoom;
import ac.diu.conference.repository.HallRoomRepository;

@Service
@Transactional
public class HallRoomService {
	
	@Autowired
	private HallRoomRepository repo;
	
	
	public List<HallRoom> listAll(){
		
		return (List<HallRoom>) repo.findAll();
	}
	public void save(HallRoom hallRoom) {
		
		repo.save(hallRoom);
	}
	
	public HallRoom get(long id) {
		return repo.findById(id);
		
	}
	
	public void delete(long id) {
        repo.deleteById(id);
    }

}
