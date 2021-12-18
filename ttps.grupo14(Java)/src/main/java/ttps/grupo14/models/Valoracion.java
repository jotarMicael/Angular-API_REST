package ttps.grupo14.models;



import javax.persistence.*;

@Entity
@Table (name="valoracion")
public class Valoracion {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id; 
	
	
	@Column (name = "puntajeLimpieza", nullable = true)
	private Integer puntajeLimpieza;
	@Column (name = "puntajeSimpatia", nullable = true)
	private Integer puntajeSimpatia;
	@Column (name = "puntajeCalidadPrecio", nullable = true)
	private Integer puntajeCalidadPrecio;
	@Column (name = "puntajeSabor", nullable = true)
	private Integer puntajeSabor;
	@Column (name = "puntajeDisenio", nullable = true)
	private Integer puntajeDisenio;
	
	
	
	@ManyToOne
	private  Servicio servicio;
	
	@ManyToOne	
	private  Usuario usuario;
	
	
	public Valoracion() {
		super();
		
	}

	public Valoracion(Integer puntajeLimpieza, Integer puntajeSimpatia, Integer puntajeCalidadPrecio,
			Integer puntajeSabor, Integer puntajeDisenio) {
		super();
		this.puntajeLimpieza = puntajeLimpieza;
		this.puntajeSimpatia = puntajeSimpatia;
		this.puntajeCalidadPrecio = puntajeCalidadPrecio;
		this.puntajeSabor = puntajeSabor;
		this.puntajeDisenio = puntajeDisenio;

	}
	
	

	public long getId() {
		return id;
	}



	public Integer getPuntajeLimpieza() {
		return puntajeLimpieza;
	}



	public Integer getPuntajeSimpatia() {
		return puntajeSimpatia;
	}



	public Integer getPuntajeCalidadPrecio() {
		return puntajeCalidadPrecio;
	}



	public Integer getPuntajeSabor() {
		return puntajeSabor;
	}


	public Integer getPuntajeDisenio() {
		return puntajeDisenio;
	}



	public void setServicio(Servicio service) {
		
		this.servicio = service;
	}
	
	public void setUsuario (Usuario user) {
		this.usuario = user;
	}
	
	
	
	
	
	
	
}