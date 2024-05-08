package modelo;

import java.util.Date;

public class Historico {

	private Date ano;
	private Date mes;
	private Ruta ruta;
	private int totalRescatados;
	
	public Date getA�o() {
		return ano;
	}
	public void setA�o(Date a�o) {
		this.ano = a�o;
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
		return "Historico [a�o=" + ano + ", mes=" + mes + ", ruta=" + ruta + ", totalRescatados=" + totalRescatados
				+ "]";
	}
	
}
