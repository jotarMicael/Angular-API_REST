package ttps.grupo14.models;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name="ubicacion")
public class Ubicacion {	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id; 
	
	@Column (name = "codigoPostal", nullable = false,length = 50)
	private String codigoPostal;
	@Column (name = "localidad", nullable = false,length = 50)
	private String localidad;
	@Column (name = "provincia", nullable = false,length = 50)
	private String provincia;
	@Column (name = "latitud", nullable = false,length = 50)
	private double latitud;
	@Column (name = "longitud", nullable = false,length = 50)
	private double longitud;
	@Column (name = "direccion", nullable = false,length = 50)
	private String direccion;

	
	@OneToMany(mappedBy = "ubicacion")
	private List<Evento> eventos = new ArrayList<>();


	public Ubicacion() {
		super();
		
	}
	public Ubicacion(String codigoPostal, String localidad,String provincia, double latitud, double longitud, String direccion) {
		super();
		this.codigoPostal = codigoPostal;
		this.provincia = provincia;
		this.latitud = latitud;
		this.longitud = longitud;
		this.direccion = direccion;
		this.localidad = localidad;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getCodigoPostal() {
		return codigoPostal;
	}


	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}


	public String getProvincia() {
		return provincia;
	}


	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}


	public double getLatitud() {
		return latitud;
	}


	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}


	public double getLongitud() {
		return longitud;
	}


	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public List<Evento> getEventos() {
		return eventos;
	}


	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	
	
	
	
	
	
	
}
	
	
	