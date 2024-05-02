package modelo;

import java.sql.Date;

public class Rescate {

	private int id;
	private String fecha;
	private String posicion;
	private int idRuta;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public int getIdRuta() {
		return idRuta;
	}
	public void setIdRuta(int idRuta) {
		this.idRuta = idRuta;
	}
	
	
	@Override
	public String toString() {
		return "Rescate [id=" + id + ", fecha=" + fecha + ", posicion=" + posicion + ", idRuta=" + idRuta + "]";
	}
}
