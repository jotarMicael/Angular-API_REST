package ttps.grupo14.models;

import javax.persistence.*;



@Entity
@Table (name="imagen")
public class Imagen {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id; 
	
	@Column (name = "ruta", nullable = false, length = 100)
	private String ruta;
	
	@ManyToOne
	@JoinColumn(name="servicio_id",referencedColumnName="id")	
	private Servicio servicio;
	
	
	
	public Imagen() {
		super();
		
		
	}
	
	public Imagen(String ruta) {
		this.ruta = ruta;
		
		
	}

	

	public long getId() {
		return id;
	}

	

	public String getRuta() {
		return ruta;
	}
	



	public void setServicio(Servicio servicio) {
		
		this.servicio = servicio;
	}
	
	
	
	
	

}
