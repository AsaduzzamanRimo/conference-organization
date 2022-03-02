package ac.diu.conference.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ac.diu.asad.conference.model.University;



@Repository
public interface UniversityRepository extends CrudRepository<University, Long> {
	
	List<University> findByName(String name);
	University findById(long Id);

}
