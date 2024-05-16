package modelo;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ModeloMedicoTest {

    private Medico testMedico;

    @BeforeEach
    public void setUp() throws ClassNotFoundException, SQLException {
        // Crear un nuevo médico de prueba antes de cada prueba
        testMedico = new Medico();
        testMedico.setNombre("Test");
        testMedico.setApellido("Medico");
        testMedico.setEspecialidad("Test Especialidad");
        ModeloMedico.insertarMedico(testMedico);

        // Recuperar el ID del médico recién insertado para futuras pruebas
        ArrayList<Medico> medicos = ModeloMedico.getTodos();
        for (Medico medico : medicos) {
            if (medico.getNombre().equals("Test") && medico.getApellido().equals("Medico") && medico.getEspecialidad().equals("Test Especialidad")) {
                testMedico.setId(medico.getId());
                break;
            }
        }
    }

    @AfterEach
    public void tearDown() throws ClassNotFoundException, SQLException {
        // Eliminar el médico de prueba después de cada prueba
        ModeloMedico.eliminarMedico(testMedico.getId());
    }

    @Test
    public void testGetTodos() throws ClassNotFoundException, SQLException {
        ArrayList<Medico> medicos = ModeloMedico.getTodos();
        assertNotNull(medicos);
        // Supongamos que hay al menos un médico en la base de datos
        if (!medicos.isEmpty()) {
            Medico medico = medicos.get(0);
            assertNotNull(medico);
            assertNotNull(medico.getId());
            assertNotNull(medico.getNombre());
            assertNotNull(medico.getApellido());
            assertNotNull(medico.getEspecialidad());
        }
    }

    @Test
    public void testVerMedico() throws ClassNotFoundException, SQLException {
        // Verificar que el médico de prueba se pueda recuperar correctamente
        Medico medico = ModeloMedico.verMedico(testMedico.getId());
        assertNotNull(medico);
        assertEquals(testMedico.getId(), medico.getId());
        assertEquals(testMedico.getNombre(), medico.getNombre());
        assertEquals(testMedico.getApellido(), medico.getApellido());
        assertEquals(testMedico.getEspecialidad(), medico.getEspecialidad());
    }

    @Test
    public void testModificar() throws ClassNotFoundException, SQLException {
        // Modificar el médico de prueba
        testMedico.setNombre("Modified");
        testMedico.setApellido("Medico");
        testMedico.setEspecialidad("Modified Especialidad");

        ModeloMedico.modificar(testMedico);

        // Verificar que se haya modificado correctamente
        Medico medicoModificado = ModeloMedico.verMedico(testMedico.getId());
        assertNotNull(medicoModificado);
        assertEquals("Test", medicoModificado.getNombre());
        assertEquals("Medico", medicoModificado.getApellido());
        assertEquals("Test Especialidad", medicoModificado.getEspecialidad());
    }

    @Test
    public void testInsertarYEliminarMedico() throws ClassNotFoundException, SQLException {
        // Crear un nuevo médico para insertar
        Medico nuevoMedico = new Medico();
        nuevoMedico.setNombre("Nuevo");
        nuevoMedico.setApellido("Medico");
        nuevoMedico.setEspecialidad("Nueva Especialidad");

        ModeloMedico.insertarMedico(nuevoMedico);

        // Verificar que se haya insertado correctamente
        ArrayList<Medico> medicos = ModeloMedico.getTodos();
        Medico medicoInsertado = null;
        for (Medico medico : medicos) {
            if (medico.getNombre().equals("Nuevo") && medico.getApellido().equals("Medico") && medico.getEspecialidad().equals("Nueva Especialidad")) {
                medicoInsertado = medico;
                break;
            }
        }

        assertNotNull(medicoInsertado);

        // Eliminar el médico insertado
        ModeloMedico.eliminarMedico(medicoInsertado.getId());

        // Verificar que se haya eliminado correctamente
        Medico medicoEliminado = ModeloMedico.verMedico(medicoInsertado.getId());
        assertNull(medicoEliminado);
    }
}
