package ac.diu.asad.conference.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.diu.asad.conference.model.Room;
import ac.diu.conference.repository.RoomRepository;

@Service
@Transactional
public class RoomService {
	
	@Autowired
	private RoomRepository repo;
	
	public List<Room> listAll(){
		
		return (List<Room>) repo.findAll();
	}
	public void save(Room room) {
		
		repo.save(room);
	}
	
	public Room get(long id) {
		return repo.findById(id);
		
	}
	
	public void delete(long id) {
        repo.deleteById(id);
    }

}
