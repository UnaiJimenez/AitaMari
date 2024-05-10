package modelo;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Rescate {

	private int id;
	private LocalDateTime fechaHora;
	private String posicion;
	private Ruta ruta;
	private ArrayList<Rescatado> rescatados;
	
	public ArrayList<Rescatado> getRescatados() {
		return rescatados;
	}
	public void setRescatados(ArrayList<Rescatado> rescatados) {
		this.rescatados = rescatados;
	}
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
	@Override
	public String toString() {
		return "Rescate [id=" + id + ", fechaHora=" + fechaHora + ", posicion=" + posicion + ", ruta=" + ruta
				+ ", rescatados=" + rescatados + "]";
	}
}
