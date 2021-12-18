package ttps.grupo14.models;
import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name="tipoServicio")
public class TipoServicio {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	
	@Column (name = "nombre", nullable = false, length = 50)
	private String nombre;
	
	
	@OneToMany
	@JoinColumn(name="tipoServicio_id")
	private List<Servicio> servicios = new ArrayList<>();

	public TipoServicio() {
		super();
	}
	public TipoServicio(String nombre) {
		super();
		this.nombre = nombre;
	}


	public Long getId() {
		return id;
	}



	public String getNombre() {
		return nombre;
	}




	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}
	
	
	
	
	
}
	