package ttps.grupo14.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
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

import ttps.grupo14.models.Imagen;
import ttps.grupo14.models.RedSocial;
import ttps.grupo14.models.Servicio;

import ttps.grupo14.models.Valoracion;

import ttps.grupo14.services.ServiceService;
import ttps.grupo14.services.TokenService;

@RestController
@RequestMapping("/service")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class ServiceController {

	@Autowired
	private ServiceService serviceService;

	@PostMapping(value = "/create")
	@Transactional
	public ResponseEntity<?> save(@RequestBody Servicio service, @RequestHeader String token) {

		if (TokenService.validateToken(token)) {
			Servicio serv = serviceService.save(service);
			if (serv != null) {

				for (RedSocial rd : serv.getRedesSociales()) {
					rd.setServicio(serv);
				}

				for (Imagen im : serv.getImagenes()) {
					im.setServicio(serv);
				}

				for (Valoracion v : serv.getValoraciones()) {
					v.setServicio(serv);
					v.setUsuario(serv.getUsuario());
				}
				return ResponseEntity.status(HttpStatus.CREATED).body(serviceService.save(service));

			}
			return new ResponseEntity<String>("Debe completar los campos con *", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>("Token invalido", HttpStatus.UNAUTHORIZED);
	}

	@GetMapping(value = "/find/{id}")
	@Transactional(readOnly = true)
	public ResponseEntity<?> findServicesByUser(@PathVariable Long id, @RequestHeader String token) {

		if (TokenService.validateToken(token)) {
			List<Servicio> services = serviceService.findServicesByUser(id);

			if (!services.isEmpty()) {
				return ResponseEntity.status(HttpStatus.CREATED).body(services);

			}
			return new ResponseEntity<String>("El usuario con ese Email,NO posee servicios", HttpStatus.NOT_FOUND);

		} else {
			return new ResponseEntity<String>("Token invalido", HttpStatus.UNAUTHORIZED);
		}

	}
	
	@GetMapping(value = "/{id}")
	@Transactional(readOnly = true)
	public ResponseEntity<?> findService(@PathVariable Long id, @RequestHeader String token) {

		if (TokenService.validateToken(token)) {
			Optional<Servicio> service = serviceService.findById(id);

			if (service.isPresent()) {
				Servicio s = service.get();
				return ResponseEntity.status(HttpStatus.CREATED).body(s);

			}
			return new ResponseEntity<String>("No existe el servicio", HttpStatus.NOT_FOUND);

		} else {
			return new ResponseEntity<String>("Token invalido", HttpStatus.UNAUTHORIZED);
		}

	}

	@PutMapping(value = "/update/{id}")
	@Transactional
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Servicio service, @RequestHeader String token) {

		if (!TokenService.validateToken(token)) {
			return new ResponseEntity<String>("Token Inválido", HttpStatus.UNAUTHORIZED);
		}

		

		if (!serviceService.findById(id).isPresent()) {
			return new ResponseEntity<String>("No existe el servicio con ese ID", HttpStatus.NOT_FOUND);
		}
		
		
		Servicio serv = serviceService.save(service);
		
		for (RedSocial rd : serv.getRedesSociales()) {
			rd.setServicio(serv);
		}
		
		for (Imagen i : serv.getImagenes()) {
			i.setServicio(serv);
		}
		
		return new ResponseEntity<String>("OK", HttpStatus.OK);
		
	}

	@GetMapping(value = "/delete/{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable Long id, @RequestHeader String token) {

		if (TokenService.validateToken(token)) {
			if (!serviceService.existsById(id)) {
				return new ResponseEntity<String>("No existe el servicio con ese ID", HttpStatus.BAD_REQUEST);
			}

	
			serviceService.deleteById(id);
			return new ResponseEntity<String>("OK", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Token Inválido", HttpStatus.UNAUTHORIZED);
	}

}
