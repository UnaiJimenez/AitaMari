package modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VoluntarioTest {

    private Voluntario voluntario;

    @BeforeEach
    public void setUp() {
        voluntario = new Voluntario();
    }

    @Test
    public void testSetAndGetId() {
        voluntario.setId(1);
        assertEquals(1, voluntario.getId());
    }

    @Test
    public void testSetAndGetEdad() {
        voluntario.setEdad("30");
        assertEquals("30", voluntario.getEdad());
    }

    @Test
    public void testSetAndGetNombre() {
        voluntario.setNombre("Juan");
        assertEquals("Juan", voluntario.getNombre());
    }

    @Test
    public void testSetAndGetApellido() {
        voluntario.setApellido("Perez");
        assertEquals("Perez", voluntario.getApellido());
    }

    @Test
    public void testSetAndGetEmail() {
        voluntario.setEmail("juan@example.com");
        assertEquals("juan@example.com", voluntario.getEmail());
    }

    @Test
    public void testSetAndGetTelefono() {
        voluntario.setTelefono("123456789");
        assertEquals("123456789", voluntario.getTelefono());
    }

    @Test
    public void testToString() {
        voluntario.setId(1);
        voluntario.setEdad("30");
        voluntario.setNombre("Juan");
        voluntario.setApellido("Perez");
        voluntario.setEmail("juan@example.com");
        voluntario.setTelefono("123456789");

        String expected = "Voluntario [id=1, edad=30, nombre=Juan, apellido=Perez, email=juan@example.com, telefono=123456789]";
        assertEquals(expected, voluntario.toString());
    }
}
