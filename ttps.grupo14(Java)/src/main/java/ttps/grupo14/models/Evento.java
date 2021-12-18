package ttps.grupo14.models;
import java.time.LocalDateTime;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name="evento")
public class Evento {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id; 
	
	
	@Column (name = "nombre", nullable = false, length = 50)
	private String nombre;
	@Column (name = "fechaYHora", nullable = false)
	private LocalDateTime fechaYHora;
	@Column (name = "esPublico", nullable = false)
	private boolean esPublico;
	
	
	
	@ManyToOne
	
	private  Ubicacion ubicacion;

	@ManyToOne
	private  Usuario usuario;
	
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "evento")
	private  List <Reserva> reservas = new ArrayList<>();


	public Evento() {
		super();
	}
	
	public Evento(String nombre, LocalDateTime fechaYHora, boolean esPublico, Ubicacion ubicacion) {
		super();
		this.nombre = nombre;
		this.fechaYHora = fechaYHora;
		this.esPublico = esPublico;
		this.ubicacion = ubicacion;
		
	}
	
	public Evento(String nombre, LocalDateTime fechaYHora, boolean esPublico, Ubicacion ubicacion, Usuario usuario) {
		super();
		this.nombre = nombre;
		this.fechaYHora = fechaYHora;
		this.esPublico = esPublico;
		this.ubicacion = ubicacion;
		this.usuario = usuario;
		
	}



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}



	public void setFechaYHora(LocalDateTime fechaYHora) {
		this.fechaYHora = fechaYHora;
	}



	public boolean isEsPublico() {
		return esPublico;
	}



	public void setEsPublico(boolean esPublico) {
		this.esPublico = esPublico;
	}



	public Ubicacion getUbicacion() {
		return ubicacion;
	}



	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	
}
	
	

