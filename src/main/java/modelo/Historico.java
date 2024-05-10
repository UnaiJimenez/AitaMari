package modelo;

public class Historico {


	private String ano;
	private String mes;
	private Ruta ruta;
	private int totalRescatados;
	
	public String getAno() {
		return ano;
	}
	public void setAno(String ano) {
		this.ano = ano;
	}
	public String getMes() {
		return mes;
	}
	public void setMes(String mes) {
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
		return "Historico [año=" + ano + ", mes=" + mes + ", ruta=" + ruta + ", totalRescatados="
				+ totalRescatados + "]";
	}
	
}
