package ac.diu.conference.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ac.diu.asad.conference.model.LabRoom;


@Repository
public interface LabRoomRepository extends CrudRepository<LabRoom, Long>{
	
	List<LabRoom> findByName(String name);
	LabRoom findById(long Id);

}
