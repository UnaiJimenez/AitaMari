package modelo;

import java.util.Date;

public class Historico {

	private int id;
	private Date ano;
	private Date mes;
	private Ruta ruta;
	private int totalRescatados;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getAno() {
		return ano;
	}
	public void setAno(Date ano) {
		this.ano = ano;
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
		return "Historico [id=" + id + ", ano=" + ano + ", mes=" + mes + ", ruta=" + ruta + ", totalRescatados="
				+ totalRescatados + "]";
	}
	
}
