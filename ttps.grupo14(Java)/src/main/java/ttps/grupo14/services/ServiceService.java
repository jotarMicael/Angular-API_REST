package ttps.grupo14.services;

import java.util.Optional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import ttps.grupo14.models.Servicio;

import ttps.grupo14.repository.ServiceRepository;


@Service
public class ServiceService {

	@Autowired
	private ServiceRepository serviceRepository;

	public Servicio save(Servicio service) {

		return serviceRepository.save(service);

	}

	public List<Servicio> findServicesByUser(Long id){
		
		return serviceRepository.findServicesByUser(id);
	}
	
	public Optional<Servicio> findById(Long id) {
		
		return serviceRepository.findById(id);
	}
	
	public void deleteById(Long id) {
		
		serviceRepository.deleteById(id);
	}
	
	public boolean existsById(Long id) {
		return serviceRepository.existsById(id);
	}

}
