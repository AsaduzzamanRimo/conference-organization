package ac.diu.conference.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ac.diu.asad.conference.model.HallRoom;


@Repository
public interface HallRoomRepository extends CrudRepository<HallRoom, Long> {
	
	List<HallRoom> findByName(String name);
	HallRoom findById(long Id);

}
