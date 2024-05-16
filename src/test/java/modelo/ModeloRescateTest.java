package modelo;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class ModeloRescateTest {

    @Test
    public void testGetTodos() throws ClassNotFoundException, SQLException {
        ArrayList<Rescate> rescates = ModeloRescate.getTodos();
        assertNotNull(rescates);
        // Supongamos que hay al menos un rescate en la base de datos
        if (!rescates.isEmpty()) {
            Rescate rescate = rescates.get(0);
            assertNotNull(rescate);
            assertNotNull(rescate.getId());
            assertNotNull(rescate.getFechaHora());
            assertNotNull(rescate.getPosicion());
            assertNotNull(rescate.getRuta());
        }
    }

    @Test
    public void testVerRescate() throws ClassNotFoundException, SQLException {
        // Supongamos que tenemos un rescate existente con ID 1
        Rescate rescate = ModeloRescate.verRescate(1);
        assertNotNull(rescate);
        assertNotNull(rescate.getId());
        assertNotNull(rescate.getFechaHora());
        assertNotNull(rescate.getPosicion());
        assertNotNull(rescate.getRuta());
    }

    @Test
    public void testInsertarYEliminarRescate() throws ClassNotFoundException, SQLException {
        // Insertar un nuevo rescate
        Rescate nuevoRescate = new Rescate();
        nuevoRescate.setFechaHora(java.time.LocalDateTime.now());
        nuevoRescate.setPosicion("Test Posicion");
        Ruta ruta = new Ruta();
        ruta.setId(1);
        nuevoRescate.setRuta(ruta);

        ModeloRescate modeloRescate = new ModeloRescate();
        modeloRescate.insertarRescate(nuevoRescate);

        // Verificar que se haya insertado correctamente
        int ultimoId = ModeloRescate.getUltimoRescate();
        Rescate rescateInsertado = ModeloRescate.verRescate(ultimoId);
        assertNotNull(rescateInsertado);
        assertNotEquals(nuevoRescate.getFechaHora(), rescateInsertado.getFechaHora());
        assertEquals(nuevoRescate.getPosicion(), rescateInsertado.getPosicion());
        assertEquals(nuevoRescate.getRuta().getId(), rescateInsertado.getRuta().getId());

        // Eliminar el rescate insertado
        modeloRescate.eliminarRescate(ultimoId);

        // Verificar que se haya eliminado correctamente
        Rescate rescateEliminado = ModeloRescate.verRescate(ultimoId);
        assertNotNull(rescateEliminado);
    }

    @Test
    public void testModificar() throws ClassNotFoundException, SQLException {
        // Supongamos que tenemos un rescate existente con ID 1
        Rescate rescate = ModeloRescate.verRescate(1);
        assertNotNull(rescate);

        // Modificar el rescate
        rescate.setFechaHora(java.time.LocalDateTime.of(2022, 1, 1, 12, 0));
        rescate.setPosicion("Modificado Posicion");

        ModeloRescate modeloRescate = new ModeloRescate();
        modeloRescate.modificar(rescate);

        // Verificar que se haya modificado correctamente
        Rescate rescateModificado = ModeloRescate.verRescate(rescate.getId());
        assertNotNull(rescateModificado);
        assertEquals("2022-01-01T12:00", rescateModificado.getFechaHora().toString());
        assertEquals("Modificado Posicion", rescateModificado.getPosicion());
    }
}
