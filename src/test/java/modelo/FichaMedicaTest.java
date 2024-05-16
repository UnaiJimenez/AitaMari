package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FichaMedicaTest {

	@Test
	public void testGetSetId() {
		FichaMedica fichaMedica = new FichaMedica();
		fichaMedica.setId(1);
		assertEquals(1, fichaMedica.getId());
	}

	@Test
	public void testGetSetConstantesVitales() {
		FichaMedica fichaMedica = new FichaMedica();
		fichaMedica.setConstantesVitales("Presión arterial: 120/80");
		assertEquals("Presión arterial: 120/80", fichaMedica.getConstantesVitales());
	}

	@Test
	public void testGetSetAlergias() {
		FichaMedica fichaMedica = new FichaMedica();
		fichaMedica.setAlergias("Alergias: Polvo");
		assertEquals("Alergias: Polvo", fichaMedica.getAlergias());
	}

	@Test
	public void testGetSetTipoSangre() {
		FichaMedica fichaMedica = new FichaMedica();
		fichaMedica.setTipoSangre("Tipo de Sangre: B+");
		assertEquals("Tipo de Sangre: B+", fichaMedica.getTipoSangre());
	}

	@Test
	public void testGetSetRescatado() {
		Rescatado rescatado = new Rescatado();
		rescatado.setId(1);
		rescatado.setNombre("Juan");
		FichaMedica fichaMedica = new FichaMedica();
		fichaMedica.setRescatado(rescatado);
		assertEquals(rescatado, fichaMedica.getRescatado());
	}

	@Test
	public void testToString() {
	    // Crear una instancia de FichaMedica con valores de ejemplo
	    FichaMedica fichaMedica = new FichaMedica();
	    fichaMedica.setId(1);
	    fichaMedica.setConstantesVitales("Presión arterial: 120/80");
	    fichaMedica.setAlergias("Ninguna");
	    fichaMedica.setTipoSangre("O+");
	   Rescatado rescatado = new Rescatado();
	    rescatado.setId(1001);
	    rescatado.setNombre("Juan");
	    fichaMedica.setRescatado(rescatado);
	    String expected = "FichaMedica [id=1, constantesVitales=Presión arterial: 120/80, alergias=Ninguna, tipoSangre=O+, rescatado=" + rescatado + "]";
	    String actual = fichaMedica.toString();
	    assertEquals(expected, actual);
	}
}