package ttps.grupo14.repository;


import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import ttps.grupo14.models.Servicio;


public interface ServiceRepository extends JpaRepository <Servicio, Long>{
	
	Servicio save(Servicio service);
	
	List<Servicio> findServicesByUser(Long id);
	
	Optional<Servicio> findById(Long id);
	
	void deleteById(Long id);
	
	boolean existsById(Long id);

}
