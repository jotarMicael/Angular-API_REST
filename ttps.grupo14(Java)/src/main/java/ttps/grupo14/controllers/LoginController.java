package ttps.grupo14.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ttps.grupo14.models.Usuario;
import ttps.grupo14.services.UserService;

import ttps.grupo14.services.Credentials;
import ttps.grupo14.services.TokenService;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class LoginController {

	private final int EXPIRATION_IN_SEC = 100;
	
	@Autowired
	private UserService userService;

	@Transactional(readOnly = true)
	@PostMapping
	private ResponseEntity<?> login(@RequestBody Usuario user) {
		
		Usuario userM = userService.login(user.getEmail(), user.getContrasenia());
		
		if (userM==null) {
			
			 return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario o contraseña incorrecto");
		}
		
		String token = TokenService.generateToken(userM.getEmail(), EXPIRATION_IN_SEC);
		String status = "ok";
		String userID = Long.toString(userM.getId()) ;
		
		return ResponseEntity.ok(new Credentials(token, EXPIRATION_IN_SEC, status,userID));
		
		//return new ResponseEntity<String>(token, header , HttpStatus.CREATED);
	}

}
