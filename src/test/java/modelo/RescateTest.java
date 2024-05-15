package modelo;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class RescateTest {

    private Rescate rescate;

    @BeforeEach
    public void setUp() {
        rescate = new Rescate();
    }

    @Test
    public void testSetAndGetId() {
        rescate.setId(1);
        assertEquals(1, rescate.getId());
    }

    @Test
    public void testSetAndGetFechaHora() {
        LocalDateTime fechaHora = LocalDateTime.now();
        rescate.setFechaHora(fechaHora);
        assertEquals(fechaHora, rescate.getFechaHora());
    }

    @Test
    public void testSetAndGetPosicion() {
        rescate.setPosicion("Latitud: 40, Longitud: -73");
        assertEquals("Latitud: 40, Longitud: -73", rescate.getPosicion());
    }

    @Test
    public void testSetAndGetRuta() {
        Ruta ruta = new Ruta();
        rescate.setRuta(ruta);
        assertEquals(ruta, rescate.getRuta());
    }

    @Test
    public void testSetAndGetRescatados() {
        ArrayList<Rescatado> rescatados = new ArrayList<>();
        rescatados.add(new Rescatado());
        rescate.setRescatados(rescatados);
        assertNotNull(rescate.getRescatados());
        assertEquals(1, rescate.getRescatados().size());
    }

    @Test
    public void testToString() {
        LocalDateTime fechaHora = LocalDateTime.now();
        Ruta ruta = new Ruta();
        ArrayList<Rescatado> rescatados = new ArrayList<>();
        rescatados.add(new Rescatado());

        rescate.setId(1);
        rescate.setFechaHora(fechaHora);
        rescate.setPosicion("Latitud: 40, Longitud: -73");
        rescate.setRuta(ruta);
        rescate.setRescatados(rescatados);

        String expected = "Rescate [id=1, fechaHora=" + fechaHora + ", posicion=Latitud: 40, Longitud: -73, ruta=" + ruta + ", rescatados=" + rescatados + "]";
        assertEquals(expected, rescate.toString());
    }
}
