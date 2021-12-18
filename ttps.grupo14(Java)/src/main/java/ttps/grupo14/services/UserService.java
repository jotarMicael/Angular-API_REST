package ttps.grupo14.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ttps.grupo14.models.Usuario;
import ttps.grupo14.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	@Transactional(readOnly = true)
	public Optional<Usuario> findById(Long id) {
		return userRepository.findById(id);
	}
	@Transactional
	public Usuario create (Usuario user) {
		
		return userRepository.save(user);
	}
	@Transactional
	public Usuario update (Usuario user) {
				
		return userRepository.save(user);
	}
	@Transactional(readOnly = true)
	public Usuario login (String email, String contrasenia) {
		
		return userRepository.logearse(email, contrasenia);
		
		
	}
	
	public Usuario findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	

	

}
