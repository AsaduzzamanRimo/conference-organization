package ac.diu.conference.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ac.diu.asad.conference.model.Facilities;



@Repository
public interface FacilitiesRepository extends CrudRepository<Facilities, Long>{
	
	List<Facilities> findByName(String name);
	Facilities findById(long Id);

}
