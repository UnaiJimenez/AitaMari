package modelo;

public class FichaMedica {

	private int id;
	private String constantesVitales;
	private String alergias;
	private String tipoSangre;
	private Rescatado rescatado;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getConstantesVitales() {
		return constantesVitales;
	}
	public void setConstantesVitales(String constantesVitales) {
		this.constantesVitales = constantesVitales;
	}
	public String getAlergias() {
		return alergias;
	}
	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}
	public String getTipoSangre() {
		return tipoSangre;
	}
	public void setTipoSangre(String tipoDeSangre) {
		this.tipoSangre = tipoDeSangre;
	}
	public Rescatado getRescatado() {
		return rescatado;
	}
	public void setRescatado(Rescatado rescatado) {
		this.rescatado = rescatado;
	}
	@Override
	public String toString() {
		return "FichaMedica [id=" + id + ", constantesVitales=" + constantesVitales + ", alergias=" + alergias
				+ ", tipoSangre=" + tipoSangre + ", rescatado=" + rescatado + "]";
	}
	
}
