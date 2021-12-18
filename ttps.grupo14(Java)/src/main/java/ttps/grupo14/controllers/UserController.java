package ttps.grupo14.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ttps.grupo14.models.Usuario;
import ttps.grupo14.services.TokenService;
import ttps.grupo14.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/find/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id, @RequestHeader String token) {

		Optional<Usuario> user = userService.findById(id);

		if (!user.isPresent()) {

			return new ResponseEntity<String>("El usuario con ese ID no existe", HttpStatus.OK);
		}
		
		if ( TokenService.validateToken(token) ) {

		return ResponseEntity.status(HttpStatus.CREATED).body(user);
		
		}
		return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);

	}

	@PostMapping("/create")
	public ResponseEntity<?> create(@RequestBody Usuario user) {
		
	
		if (userService.findByEmail( user.getEmail() )!= null) {
			return new ResponseEntity<String>(HttpStatus.FOUND);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(userService.create(user));

	}

	@PutMapping("/update/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Usuario user, @RequestHeader String token) {
		
			
		
		Optional<Usuario> userM = userService.findById(id);
		
		
		if (!userM.isPresent()) {

			return new ResponseEntity<String>("El usuario con ese ID no existe", HttpStatus.OK);
		}
		
		if ( TokenService.validateToken(token) ) {
			Usuario u = userM.get();
			
			if ((user.getNombre()!=null)) {
				u.setNombre(user.getNombre()); 
			}
			if ((user.getApellido()!=null)) {
				u.setApellido(user.getApellido());
			}
			if (user.getEmail()!=null) {
				u.setEmail(user.getEmail());
			}
			if (user.getFechaNacimiento()!=null) {
				u.setFechaNacimiento(user.getFechaNacimiento());
			}
			if (user.getContrasenia()!=null) {
				u.setContrasenia(user.getContrasenia());
			}
			
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(userService.update(u));
			
		}
		return new ResponseEntity<String>(HttpStatus.UNAUTHORIZED);
		
		

	}

}
