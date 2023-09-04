package ac.diu.conference.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ac.diu.asad.conference.model.Location;


@Repository
public interface LocationRepository extends CrudRepository<Location, Long> {
	
	List<Location> findByName(String name);
	Location findById(long Id);

}
