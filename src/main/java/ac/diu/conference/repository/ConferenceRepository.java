package ac.diu.conference.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ac.diu.asad.conference.model.Conference;


@Repository
public interface ConferenceRepository extends CrudRepository<Conference, Long> {
	List<Conference> findByName(String name);
	Conference findById(long Id);

}
