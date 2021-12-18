package ttps.grupo14.models;
import javax.persistence.*;


@Entity
@Table (name="redSocial")
public class RedSocial {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id; 
	
	@Column (name = "nombre", nullable = false, length = 50)
	private String nombre;
	
	@Column (name = "icono", nullable = false, length = 50)
	private String icono;
	
	@Column (name = "urlWeb", nullable = false, length = 100)
	private String urlWeb;
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "servicio_id")
	private Servicio servicio;

	
	public RedSocial() {
		super();

		
	}
	
	public RedSocial(String nombre, String icono, String urlWeb) {
		
		this.nombre = nombre;
		this.icono = icono;
		this.urlWeb = urlWeb;

	}

	public long getId() {
		return id;
	}

	

	public String getNombre() {
		return nombre;
	}

	

	public String getIcono() {
		return icono;
	}



	public String getUrlWeb() {
		return urlWeb;
	}

	

	public void setServicio(Servicio service) {
		this.servicio = service;
		
	}
	
	
}

