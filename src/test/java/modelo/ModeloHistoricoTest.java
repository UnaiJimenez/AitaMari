package modelo;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class ModeloHistoricoTest {

    @Test
    public void testGetTodos() {
        ArrayList<Historico> historicos = ModeloHistorico.getTodos();
        assertNotNull(historicos);
        // Aquí puedes agregar más aserciones para verificar otros aspectos de los datos recuperados
    }


    @Test
    public void testGetRuta() throws ClassNotFoundException {
        // Supongamos que tenemos una ruta existente con ID 1
        Ruta ruta = ModeloHistorico.getRuta(1);
        assertNotNull(ruta);
        // Aquí puedes agregar más aserciones para verificar otros aspectos de la ruta recuperada
    }

    @Test
    public void testGetVoluntarios() throws ClassNotFoundException, SQLException {
        // Supongamos que tenemos una ruta existente con ID 1
        ArrayList<Voluntario> voluntarios = ModeloHistorico.getVoluntarios(1);
        assertNotNull(voluntarios);
        // Aquí puedes agregar más aserciones para verificar otros aspectos de los voluntarios recuperados
    }

    @Test
    public void testGetMedicos() throws ClassNotFoundException, SQLException {
        // Supongamos que tenemos una ruta existente con ID 1
        ArrayList<Medico> medicos = ModeloHistorico.getMedicos(1);
        assertNotNull(medicos);
        // Aquí puedes agregar más aserciones para verificar otros aspectos de los medicos recuperados
    }
}
