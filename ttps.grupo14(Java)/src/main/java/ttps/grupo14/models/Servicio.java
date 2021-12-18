package ttps.grupo14.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;



@Entity
@Table (name="servicio")
@NamedQuery(name="Servicio.findServicesByUser", query="Select s FROM Servicio as s INNER JOIN s.usuario as t WHERE t.id = ?1" )

public class Servicio {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	
	@Column (name = "nombre", nullable = false, length = 50)
	private String nombre;
	@Column (name = "descripcion", nullable = false, length = 50)
	private String descripcion;
	
	@OneToMany(cascade=CascadeType.ALL ,mappedBy="servicio")	
	private List <Reserva> reservas = new ArrayList<>();
	
	
	
	@ManyToOne
	@JoinColumn(name = "tipoServicio_id")
	private  TipoServicio tipoServicio; 
	
	
	@OneToMany(cascade=CascadeType.ALL ,mappedBy = "servicio")	
	private List <Imagen> imagenes;
	
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "servicio")
	private List <RedSocial> redesSociales;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy = "servicio")
	private List <Valoracion> valoraciones = new ArrayList<>();
	
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	
	public Servicio() {
		super();
		
	}
	public Servicio(String nombre, String descripcion, TipoServicio tipoServicio,Usuario usuario) {

		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipoServicio = tipoServicio;
		this.usuario = usuario;

	}
	public Servicio(String nombre, String descripcion, TipoServicio tipoServicio,Usuario usuario, Imagen imagen, RedSocial redSocial, Valoracion valoracion) {

		this.nombre = nombre;
		this.descripcion = descripcion;
		this.tipoServicio = tipoServicio;
		this.usuario = usuario;
		this.imagenes.add(imagen);
		this.redesSociales.add(redSocial);
		this.valoraciones.add(valoracion);
	}
	

	public Long getId() {
		return id;
	}

	

	public String getNombre() {
		return nombre;
	}

	

	public String getDescripcion() {
		return descripcion;
	}

	public Usuario getUsuario() {
		return usuario;
	}
	
	
	

	public TipoServicio getTipoServicio() {
		return tipoServicio;
	}
	

	public List<Imagen> getImagenes() {
		return imagenes;
	}
	public List<RedSocial> getRedesSociales() {
		return redesSociales;
	}
	public List<Valoracion> getValoraciones() {
		return valoraciones;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	
	
	

	
	
}
	
	
	
	


