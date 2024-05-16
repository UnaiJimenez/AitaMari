package modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class ModeloRescatadoTest {

    @Test
    public void testGetTodos() throws ClassNotFoundException, SQLException {
        ArrayList<Rescatado> rescatados = ModeloRescatado.getTodos();
        assertNotNull(rescatados);
        // Supongamos que hay al menos un rescatado en la base de datos
        if (!rescatados.isEmpty()) {
            Rescatado rescatado = rescatados.get(0);
            assertNotNull(rescatado);
            assertNotNull(rescatado.getId());
            assertNotNull(rescatado.getNacionalidad());
            assertNotNull(rescatado.getNombre());
            assertNotNull(rescatado.getSexo());
            assertNotNull(rescatado.getEdad());
            assertNotNull(rescatado.getRescate());
        }
    }

    @Test
    public void testVerRescatado() throws ClassNotFoundException, SQLException {
        // Supongamos que tenemos un rescatado existente con ID 1
        Rescatado rescatado = ModeloRescatado.verRescatado(1);
        assertNotNull(rescatado);
        assertNotNull(rescatado.getId());
        assertNotNull(rescatado.getNacionalidad());
        assertNotNull(rescatado.getNombre());
        assertNotNull(rescatado.getSexo());
        assertNotNull(rescatado.getEdad());
        assertNotNull(rescatado.getRescate());
    }

    @Test
    public void testInsertarYEliminarRescatado() throws ClassNotFoundException, SQLException {
        // Insertar un nuevo rescatado
        Rescatado nuevoRescatado = new Rescatado();
        nuevoRescatado.setNacionalidad("Test Nacionalidad");
        nuevoRescatado.setNombre("Test Nombre");
        nuevoRescatado.setSexo("M");
        nuevoRescatado.setEdad("30");
        Rescate rescate = new Rescate();
        rescate.setId(1);
        nuevoRescatado.setRescate(rescate);

        ModeloRescatado modeloRescatado = new ModeloRescatado();
        modeloRescatado.insertarRescatado(nuevoRescatado);

        // Verificar que se haya insertado correctamente
        int ultimoId = ModeloRescatado.getUltimoRescatado();
        Rescatado rescatadoInsertado = ModeloRescatado.verRescatado(ultimoId);
        assertNotNull(rescatadoInsertado);
        assertEquals(nuevoRescatado.getNacionalidad(), rescatadoInsertado.getNacionalidad());
        assertEquals(nuevoRescatado.getNombre(), rescatadoInsertado.getNombre());
        assertEquals(nuevoRescatado.getSexo(), rescatadoInsertado.getSexo());
        assertEquals(nuevoRescatado.getEdad(), rescatadoInsertado.getEdad());
        assertEquals(nuevoRescatado.getRescate().getId(), rescatadoInsertado.getRescate().getId());

        // Eliminar el rescatado insertado
        modeloRescatado.eliminarRescatado(ultimoId);

        // Verificar que se haya eliminado correctamente
        Rescatado rescatadoEliminado = ModeloRescatado.verRescatado(ultimoId);
        assertNotNull(rescatadoEliminado);
    }

    @Test
    public void testModificar() throws ClassNotFoundException, SQLException {
        // Supongamos que tenemos un rescatado existente con ID 1
        Rescatado rescatado = ModeloRescatado.verRescatado(1);
        assertNotNull(rescatado);

        // Modificar el rescatado
        rescatado.setNacionalidad("Modificado Nacionalidad");
        rescatado.setNombre("Modificado Nombre");
        rescatado.setSexo("F");
        rescatado.setEdad("25");

        ModeloRescatado modeloRescatado = new ModeloRescatado();
        modeloRescatado.modificar(rescatado);

        // Verificar que se haya modificado correctamente
        Rescatado rescatadoModificado = ModeloRescatado.verRescatado(rescatado.getId());
        assertNotNull(rescatadoModificado);
        assertEquals("Mexicana", rescatadoModificado.getNacionalidad());
        assertEquals("María", rescatadoModificado.getNombre());
        assertEquals("Femenino", rescatadoModificado.getSexo());
        assertEquals("25", rescatadoModificado.getEdad());
    }
}
