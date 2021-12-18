package ttps.grupo14.models;

import javax.persistence.*;



import java.util.List;
import java.util.ArrayList;
import java.util.Date;

@Entity
@Table (name="usuario")
@NamedQuery(name="Usuario.logearse", query = "SELECT u FROM Usuario u WHERE u.email = ?1 AND u.contrasenia = ?2 ")
@NamedQuery(name="Usuario.findByEmail", query = "SELECT u FROM Usuario u WHERE u.email = ?1 ")
public class Usuario {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id; 
	
	@Column (name = "nombre", nullable = false,length = 50)
	private String nombre;
	@Column (name = "apellido", nullable = false,length = 50)
	private String apellido;
	@Column (name = "email", nullable = false,length = 50, unique = true)
	private String email;
	@Column (name = "fechaNacimiento", nullable = false)
	private Date fechaNacimiento;
	@Column (name = "contrasenia", nullable = false,length = 50)
	private String contrasenia;
	
	@OneToMany(cascade=CascadeType.ALL ,mappedBy = "usuario")
	private List <Servicio> contratados = new ArrayList<Servicio>();
	
	@OneToMany(cascade=CascadeType.ALL ,mappedBy = "usuario")
	private List <Evento> eventos = new ArrayList<Evento>();
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy = "usuario")
	private List <Valoracion> valoraciones = new ArrayList<Valoracion>();
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy = "usuario")
	private List <Reserva> reservas = new ArrayList<Reserva>();
	
	
	public Usuario() {
		super();
	
	}
	

	public Usuario(String nombre, String apellido, String email, Date fechaNacimiento, String contrasenia) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
		this.contrasenia = contrasenia;
		
	}



	public Long getId() {
		return id;
	}



	public String getApellido() {
		return apellido;
	}



	



	public String getEmail() {
		return email;
	}



	



	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}





	public String getContrasenia() {
		return contrasenia;
	}

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public void setContrasenia(String contrasenia) {
		
		this.contrasenia = contrasenia;
	}






	
	
}
