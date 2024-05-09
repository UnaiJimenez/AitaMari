package modelo;

import java.time.LocalDateTime;

public class Rescate {
  
	private int id;
	private LocalDateTime fechaHora;
	private String posicion;
	private Ruta ruta;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
  }
	public LocalDateTime getFechaHora() {
		return fechaHora;
	}
	public void setFechaHora(LocalDateTime fechaHora) {
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
