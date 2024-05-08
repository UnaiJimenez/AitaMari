package modelo;

public class Rescatado {

	private int id;
	private String nacionalidad;
	private String nombre;
	private String sexo;
	private String edad;
	private int idRescate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEdad() {
		return edad;
	}
	public void setEdad(String edad) {
		this.edad = edad;
	}
	public int getIdRescate() {
		return idRescate;
	}
	public void setIdRescate(int idRescate) {
		this.idRescate = idRescate;
	}
	@Override
	public String toString() {
		return "Rescatado [id=" + id + ", nacionalidad=" + nacionalidad + ", nombre=" + nombre + ", sexo=" + sexo
				+ ", edad=" + edad + ", idRescate=" + idRescate + "]";
	}
	
}
