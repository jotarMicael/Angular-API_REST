package ttps.grupo14.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ttps.grupo14.models.Usuario;

public interface UserRepository extends JpaRepository <Usuario,Long>{
	
	Optional<Usuario> findById(Long id);

	Usuario save(Usuario user);
	
	Usuario logearse (String email, String contrasenia);
	
	Usuario findByEmail(String email);

}
