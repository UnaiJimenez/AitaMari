package modelo;

import java.util.Date;

public class Rescate {

	private int id;
	private Date fechaHora;
	private String posicion;
	private Ruta ruta;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(Date fechaHora) {
		this.fechaHora = fechaHora;
	}
	public String getPosicion() {
		return posicion;
	}
	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}
	public Ruta getRuta() {
		return ruta;
	}
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}
	@Override
	public String toString() {
		return "Rescate [id=" + id + ", fechaHora=" + fechaHora + ", posicion=" + posicion + ", Ruta=" + ruta + "]";
	}
	
}
