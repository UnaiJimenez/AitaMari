package validacion;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

public class MetodosValidacionTest {

    @Test
    public void testEsEntero_ConEntero() {
        assertTrue(MetodosValidacion.esEntero("123"));
    }

    @Test
    public void testEsEntero_ConTexto() {
        assertFalse(MetodosValidacion.esEntero("abc"));
    }

    @Test
    public void testEsFechaAnterior_FechaAnterior() {
        Date fechaSalida = new Date(2022, 5, 15);
        Date fechaLlegada = new Date(2022, 5, 20);
        assertTrue(MetodosValidacion.esFechaAnterior(fechaSalida, fechaLlegada));
    }

    @Test
    public void testEsFechaAnterior_FechaPosterior() {
        Date fechaSalida = new Date(2022, 5, 20);
        Date fechaLlegada = new Date(2022, 5, 15);
        assertFalse(MetodosValidacion.esFechaAnterior(fechaSalida, fechaLlegada));
    }

    @Test
    public void testEsTipoSangre_Valido() {
        assertTrue(MetodosValidacion.esTipoSangre("A+"));
    }

    @Test
    public void testEsTipoSangre_Invalido() {
        assertFalse(MetodosValidacion.esTipoSangre("Z-"));
    }

    @Test
    public void testEsGenero_Valido() {
        assertTrue(MetodosValidacion.esGenero("Masculino"));
    }

    @Test
    public void testEsGenero_Invalido() {
        assertFalse(MetodosValidacion.esGenero("Otro"));
    }
}
