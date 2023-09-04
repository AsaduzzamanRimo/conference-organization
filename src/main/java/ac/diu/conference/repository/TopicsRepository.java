package ac.diu.conference.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ac.diu.asad.conference.model.Topics;

@Repository
public interface TopicsRepository extends CrudRepository<Topics, Long> {
	
	List<Topics> findByName(String name);
	Topics findById(long Id);

}
