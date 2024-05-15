package modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedicoTest {

    private Medico medico;

    @BeforeEach
    public void setUp() {
        medico = new Medico();
    }

    @Test
    public void testSetAndGetId() {
        medico.setId(1);
        assertEquals(1, medico.getId());
    }

    @Test
    public void testSetAndGetNombre() {
        medico.setNombre("Juan");
        assertEquals("Juan", medico.getNombre());
    }

    @Test
    public void testSetAndGetApellido() {
        medico.setApellido("Perez");
        assertEquals("Perez", medico.getApellido());
    }

    @Test
    public void testSetAndGetEspecialidad() {
        medico.setEspecialidad("Cardiología");
        assertEquals("Cardiología", medico.getEspecialidad());
    }

    @Test
    public void testToString() {
        medico.setId(1);
        medico.setNombre("Juan");
        medico.setApellido("Perez");
        medico.setEspecialidad("Cardiología");

        String expected = "Medico [id=1, nombre=Juan, apellido=Perez, especialidad=Cardiología]";
        assertEquals(expected, medico.toString());
    }
}
