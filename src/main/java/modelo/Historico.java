package modelo;

import java.util.Date;

public class Historico {

	private Date año;
	private Date mes;
	private Ruta ruta;
	private int totalRescatados;
	
	public Date getAño() {
		return año;
	}
	public void setAño(Date año) {
		this.año = año;
	}
	public Date getMes() {
		return mes;
	}
	public void setMes(Date mes) {
		this.mes = mes;
	}
	public Ruta getRuta() {
		return ruta;
	}
	public void setRuta(Ruta ruta) {
		this.ruta = ruta;
	}
	public int getTotalRescatados() {
		return totalRescatados;
	}
	public void setTotalRescatados(int totalRescatados) {
		this.totalRescatados = totalRescatados;
	}
	@Override
	public String toString() {
		return "Historico [año=" + año + ", mes=" + mes + ", ruta=" + ruta + ", totalRescatados=" + totalRescatados
				+ "]";
	}
	
}
