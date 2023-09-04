package ac.diu.conference.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ac.diu.asad.conference.model.TimeSlot;

@Repository
public interface TimeSlotRepository extends CrudRepository<TimeSlot, Long> {
	
	List<TimeSlot> findByName(String name);
	TimeSlot findById(long Id);

}
