package ttps.grupo14.models;


import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name="formaDePago")
public class FormaDePago {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id; 
	
	@Column (name = "nombre", nullable = false, length = 50)
	private String nombre;
	
	
	@OneToMany( mappedBy = "formaDePago")
	private List<Reserva> reservas = new ArrayList<>();


	public FormaDePago() {
		super();
	}
	public FormaDePago(String nombre) {
		super();
		this.nombre = nombre;
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


	public List<Reserva> getReservas() {
		return reservas;
	}


	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}
	
	
	


}
