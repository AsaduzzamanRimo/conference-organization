package ac.diu.conference.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ac.diu.asad.conference.model.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
	
	List<Room> findByName(String name);
	Room findById(long Id);

}
