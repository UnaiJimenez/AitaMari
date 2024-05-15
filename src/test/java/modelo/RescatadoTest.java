package modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RescatadoTest {

    private Rescatado rescatado;

    @BeforeEach
    public void setUp() {
        rescatado = new Rescatado();
    }

    @Test
    public void testSetAndGetId() {
        rescatado.setId(1);
        assertEquals(1, rescatado.getId());
    }

    @Test
    public void testSetAndGetNacionalidad() {
        rescatado.setNacionalidad("Español");
        assertEquals("Español", rescatado.getNacionalidad());
    }

    @Test
    public void testSetAndGetNombre() {
        rescatado.setNombre("Juan");
        assertEquals("Juan", rescatado.getNombre());
    }

    @Test
    public void testSetAndGetSexo() {
        rescatado.setSexo("Masculino");
        assertEquals("Masculino", rescatado.getSexo());
    }

    @Test
    public void testSetAndGetEdad() {
        rescatado.setEdad("30");
        assertEquals("30", rescatado.getEdad());
    }

    @Test
    public void testSetAndGetRescate() {
        Rescate rescate = new Rescate();
        rescatado.setRescate(rescate);
        assertEquals(rescate, rescatado.getRescate());
    }

    @Test
    public void testToString() {
        rescatado.setId(1);
        rescatado.setNacionalidad("Español");
        rescatado.setNombre("Juan");
        rescatado.setSexo("Masculino");
        rescatado.setEdad("30");
        Rescate rescate = new Rescate();
        rescatado.setRescate(rescate);

        String expected = "Rescatado [id=1, nacionalidad=Español, nombre=Juan, sexo=Masculino, edad=30, Rescate=" + rescate + "]";
        assertEquals(expected, rescatado.toString());
    }
}
