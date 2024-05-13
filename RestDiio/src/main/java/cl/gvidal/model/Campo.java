package cl.gvidal.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "CAMPO")
public class Campo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CAMPO_ID")
	private int id;

	@Column(name = "RUP")
	private String rup;

	@Column(name = "DIRECCION")
	private String direccion;
	
	@OneToMany(mappedBy="campo", cascade = CascadeType.ALL)
	private Set<Diio> diios;

	public Campo(int id, String rup, String direccion) {
		super();
		this.id = id;
		this.rup = rup;
		this.direccion = direccion;
	}

	public Campo() {
	}

	
	  public int getId() { return id; }
	  
	  public void setId(int id) { this.id = id; }
	 

	public String getRup() {
		return rup;
	}

	public void setRup(String rup) {
		this.rup = rup;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Set<Diio> getDiios() {
		return diios;
	}

	public void setDiios(Set<Diio> diios) {
		this.diios = diios;
	}

	
	
}
