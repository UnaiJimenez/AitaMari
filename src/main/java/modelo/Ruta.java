package modelo;

import java.util.Date;
import java.util.ArrayList;

public class Ruta {

	private int id;
	private Date fechaSalida;
	private Date fechaLlegada;
	private String origen;
	private String destino;
	private ArrayList<Voluntario> voluntarios;
	private ArrayList<Medico> medicos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(Date fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public Date getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(Date fechaLlegada) {
		this.fechaLlegada = fechaLlegada;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;

	}

	public ArrayList<Voluntario> getVoluntarios() {
		return voluntarios;
	}

	public void setVoluntarios(ArrayList<Voluntario> voluntarios) {
		this.voluntarios = voluntarios;
	}

	public ArrayList<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(ArrayList<Medico> medicos) {
		this.medicos = medicos;
	}

	@Override
	public String toString() {
		return "Ruta [id=" + id + ", fechaSalida=" + fechaSalida + ", fechaLlegada=" + fechaLlegada + ", origen="
				+ origen + ", destino=" + destino + ", voluntarios=" + voluntarios + ", medicos=" + medicos + "]";
	}

	
}
