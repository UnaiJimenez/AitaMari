package modelo;

import java.util.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class Rescate {

	private int id;
	private DateTimeAtCompleted fechaHora;
	private String posicion;
	private int idRuta;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public DateTimeAtCompleted getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(DateTimeAtCompleted fechaHora) {
		this.fechaHora = fechaHora;
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
		return "Rescate [id=" + id + ", fechaHora=" + fechaHora + ", posicion=" + posicion + ", idRuta=" + idRuta + "]";
	}
	
}
