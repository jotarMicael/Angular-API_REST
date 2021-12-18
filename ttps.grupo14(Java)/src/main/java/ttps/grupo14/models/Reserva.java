package ttps.grupo14.models;


import javax.persistence.*;

@Entity
@Table (name="reserva")
public class Reserva {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id; 
	
	
	@Column (name = "descripcion", nullable = false, length = 50)
	private String descripcion;
	@Column (name = "email", nullable = false, length = 50)
	private String email;
	@Column (name = "telefono", nullable = false, length = 50)
	private String telefono;
	
	
	
	@ManyToOne
	
	private  Servicio servicio;
	
	@ManyToOne
	private  Usuario usuario;
	
	@ManyToOne
	
	private  Evento evento;
	
	@ManyToOne
	
	private  FormaDePago formaDePago;
	
	
	public Reserva() {
		super();
		
	}

	public Reserva(String descripcion, String email, String telefono, Servicio servicio, Usuario usuario, Evento evento,
			FormaDePago formaDePago) {
		super();
		this.descripcion = descripcion;
		this.email = email;
		this.telefono = telefono;
		this.servicio = servicio;
		this.usuario = usuario;
		this.evento = evento;
		this.formaDePago = formaDePago;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public FormaDePago getFormaDePago() {
		return formaDePago;
	}

	public void setFormaDePago(FormaDePago formaDePago) {
		this.formaDePago = formaDePago;
	}
	
	
	
	
}
