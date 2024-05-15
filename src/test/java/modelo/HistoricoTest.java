package modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HistoricoTest {

    private Historico historico;
    private Ruta ruta;

    @BeforeEach
    public void setUp() {
        historico = new Historico();
        ruta = new Ruta();
    }

    @Test
    public void testSetAndGetAno() {
        historico.setAno("2023");
        assertEquals("2023", historico.getAno());
    }

    @Test
    public void testSetAndGetMes() {
        historico.setMes("Mayo");
        assertEquals("Mayo", historico.getMes());
    }

    @Test
    public void testSetAndGetRuta() {
        historico.setRuta(ruta);
        assertEquals(ruta, historico.getRuta());
    }

    @Test
    public void testSetAndGetTotalRescatados() {
        historico.setTotalRescatados(50);
        assertEquals(50, historico.getTotalRescatados());
    }

    @Test
    public void testToString() {
        historico.setAno("2023");
        historico.setMes("Mayo");
        historico.setRuta(ruta);
        historico.setTotalRescatados(50);

        String expected = "Historico [año=2023, mes=Mayo, ruta=" + ruta + ", totalRescatados=50]";
        assertEquals(expected, historico.toString());
    }
}
