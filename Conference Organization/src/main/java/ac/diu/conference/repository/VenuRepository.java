package ac.diu.conference.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ac.diu.asad.conference.model.Venu;

@Repository
public interface VenuRepository extends CrudRepository<Venu, Long> {
	
	List<Venu> findByName(String name);
	Venu findById(long Id);

}
