package modelo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;


public class ModeloVoluntarioTest {

    @Test
    public void testGetTodos() throws ClassNotFoundException, SQLException {
        ArrayList<Voluntario> voluntarios = ModeloVoluntario.getTodos();
        assertNotNull(voluntarios);
        // Supongamos que hay al menos un voluntario en la base de datos
        if (!voluntarios.isEmpty()) {
            Voluntario voluntario = voluntarios.get(0);
            assertNotNull(voluntario);
            assertNotNull(voluntario.getId());
            assertNotNull(voluntario.getNombre());
            assertNotNull(voluntario.getApellido());
            assertNotNull(voluntario.getEdad());
            assertNotNull(voluntario.getEmail());
            assertNotNull(voluntario.getTelefono());
        }
    }

    @Test
    public void testVerVoluntario() throws ClassNotFoundException, SQLException {
        // Supongamos que tenemos un voluntario existente con ID 1
        Voluntario voluntario = ModeloVoluntario.verVoluntario(1);
        assertNotNull(voluntario);
        assertNotNull(voluntario.getId());
        assertNotNull(voluntario.getNombre());
        assertNotNull(voluntario.getApellido());
        assertNotNull(voluntario.getEdad());
        assertNotNull(voluntario.getEmail());
        assertNotNull(voluntario.getTelefono());
    }

    @Test
    public void testInsertarYEliminarVoluntario() throws ClassNotFoundException, SQLException {
        // Insertar un nuevo voluntario
        Voluntario nuevoVoluntario = new Voluntario();
        nuevoVoluntario.setId(1);
        nuevoVoluntario.setNombre("Juan");
        nuevoVoluntario.setApellido("Perez");
        nuevoVoluntario.setEdad("30");
        nuevoVoluntario.setEmail("juan@example.com");
        nuevoVoluntario.setTelefono("123456789");

        ModeloVoluntario modeloVoluntario = new ModeloVoluntario();
        modeloVoluntario.insertarVoluntarios(nuevoVoluntario);

        // Verificar que se haya insertado correctamente
        Voluntario voluntarioInsertado = ModeloVoluntario.verVoluntario(nuevoVoluntario.getId());
        assertNotNull(voluntarioInsertado);
        assertEquals(nuevoVoluntario.getNombre(), voluntarioInsertado.getNombre());
        assertEquals(nuevoVoluntario.getApellido(), voluntarioInsertado.getApellido());
        assertEquals(nuevoVoluntario.getEdad(), voluntarioInsertado.getEdad());
        assertEquals(nuevoVoluntario.getEmail(), voluntarioInsertado.getEmail());
        assertEquals(nuevoVoluntario.getTelefono(), voluntarioInsertado.getTelefono());
        
    }



    @Test
    public void testModificar() throws ClassNotFoundException, SQLException {
        // Supongamos que tenemos un voluntario existente con ID 1
        Voluntario voluntario = ModeloVoluntario.verVoluntario(1);
        assertNotNull(voluntario);

        // Modificar el voluntario
        voluntario.setNombre("Juan");
        voluntario.setApellido("Perez");
        voluntario.setEdad("30");
        voluntario.setEmail("juan@example.com");
        voluntario.setTelefono("123456789");

        ModeloVoluntario modeloVoluntario = new ModeloVoluntario();
		modeloVoluntario.modificar(voluntario);

        // Verificar que se haya modificado correctamente
        Voluntario voluntarioModificado = ModeloVoluntario.verVoluntario(voluntario.getId());
        assertNotNull(voluntarioModificado);
        assertEquals("Juan", voluntarioModificado.getNombre());
        assertEquals("Perez", voluntarioModificado.getApellido());
        assertEquals("30", voluntarioModificado.getEdad());
        assertEquals("juan@example.com", voluntarioModificado.getEmail());
        assertEquals("123456789", voluntarioModificado.getTelefono());
    }
}
