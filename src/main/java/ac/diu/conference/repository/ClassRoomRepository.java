package ac.diu.conference.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ac.diu.asad.conference.model.ClassRoom;

@Repository
public interface ClassRoomRepository extends CrudRepository<ClassRoom, Long>  {
	
	List<ClassRoom> findByName(String name);
	ClassRoom findById(long Id);

}
