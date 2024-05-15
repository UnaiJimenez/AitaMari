package modelo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RutaTest {

    private Ruta ruta;
    private Date fechaSalida;
    private Date fechaLlegada;
    private ArrayList<Voluntario> voluntarios;
    private ArrayList<Medico> medicos;

    @BeforeEach
    public void setUp() {
        ruta = new Ruta();
        fechaSalida = new Date();
        fechaLlegada = new Date();
        voluntarios = new ArrayList<>();
        medicos = new ArrayList<>();
    }

    @Test
    public void testSetAndGetId() {
        ruta.setId(1);
        assertEquals(1, ruta.getId());
    }

    @Test
    public void testSetAndGetFechaSalida() {
        ruta.setFechaSalida(fechaSalida);
        assertEquals(fechaSalida, ruta.getFechaSalida());
    }

    @Test
    public void testSetAndGetFechaLlegada() {
        ruta.setFechaLlegada(fechaLlegada);
        assertEquals(fechaLlegada, ruta.getFechaLlegada());
    }

    @Test
    public void testSetAndGetOrigen() {
        ruta.setOrigen("Origen");
        assertEquals("Origen", ruta.getOrigen());
    }

    @Test
    public void testSetAndGetDestino() {
        ruta.setDestino("Destino");
        assertEquals("Destino", ruta.getDestino());
    }

    @Test
    public void testSetAndGetVoluntarios() {
        Voluntario voluntario = new Voluntario();
        voluntarios.add(voluntario);
        ruta.setVoluntarios(voluntarios);
        assertEquals(voluntarios, ruta.getVoluntarios());
    }

    @Test
    public void testSetAndGetMedicos() {
        Medico medico = new Medico();
        medicos.add(medico);
        ruta.setMedicos(medicos);
        assertEquals(medicos, ruta.getMedicos());
    }

    @Test
    public void testToString() {
        ruta.setId(1);
        ruta.setFechaSalida(fechaSalida);
        ruta.setFechaLlegada(fechaLlegada);
        ruta.setOrigen("Origen");
        ruta.setDestino("Destino");
        ruta.setVoluntarios(voluntarios);
        ruta.setMedicos(medicos);

        String expected = "Ruta [id=1, fechaSalida=" + fechaSalida + ", fechaLlegada=" + fechaLlegada + ", origen=Origen, destino=Destino, voluntarios=" + voluntarios + ", medicos=" + medicos + "]";
        assertEquals(expected, ruta.toString());
    }
}

