package ac.diu.asad.conference.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ac.diu.asad.conference.model.ClassRoom;
import ac.diu.conference.repository.ClassRoomRepository;

@Service
@Transactional
public class ClassRoomService {
	
	@Autowired
	private ClassRoomRepository repo;
	
	
	public List<ClassRoom> listAll(){
		
		return (List<ClassRoom>) repo.findAll();
	}
	public void save(ClassRoom classRoom) {
		
		repo.save(classRoom);
	}
	
	public ClassRoom get(long id) {
		return repo.findById(id);
		
	}
	
	public void delete(long id) {
        repo.deleteById(id);
    }

}
