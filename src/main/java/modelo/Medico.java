package modelo;

public class Medico {

	private int id;
	private String nombre;
	private String apellido;
	private String especialidad;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	
	@Override
	public String toString() {
		return "Medico [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", especialidad=" + especialidad
				+ "]";
	}
}

