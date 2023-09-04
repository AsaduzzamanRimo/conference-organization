package ac.diu.conference.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ac.diu.asad.conference.model.Speaker;

@Repository
public interface SpeakerRepository extends CrudRepository<Speaker, Long> {
	
	List<Speaker> findByName(String name);
	Speaker findById(long Id);

}
