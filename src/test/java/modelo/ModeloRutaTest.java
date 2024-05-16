package modelo;

import static org.junit.Assert.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ModeloRutaTest {

    private Ruta testRuta;
    private Voluntario testVoluntario;
    private Medico testMedico;

    @BeforeEach
    public void setUp() throws ClassNotFoundException, SQLException {
        // Crear una nueva ruta de prueba antes de cada prueba
        testRuta = new Ruta();
        testRuta.setFechaSalida(new Date());
        testRuta.setFechaLlegada(new Date());
        testRuta.setOrigen("Origen Test");
        testRuta.setDestino("Destino Test");
        ModeloRuta modeloRuta = new ModeloRuta();
        modeloRuta.insertarRuta(testRuta);

        // Recuperar el ID de la ruta recién insertada para futuras pruebas
        testRuta.setId(modeloRuta.getUltimaRuta());

        // Crear un voluntario de prueba y asociarlo a la ruta
        testVoluntario = new Voluntario();
        testVoluntario.setNombre("Voluntario Test");
        testVoluntario.setApellido("Apellido Test");
        testVoluntario.setEdad("25");
        testVoluntario.setEmail("voluntario@test.com");
        testVoluntario.setTelefono("123456789");
        ModeloVoluntario modeloVoluntario = new ModeloVoluntario();
        modeloVoluntario.insertarVoluntarios(testVoluntario);

        // Recuperar el ID del voluntario recién insertado
        ArrayList<Voluntario> voluntarios = ModeloVoluntario.getTodos();
        for (Voluntario voluntario : voluntarios) {
            if (voluntario.getNombre().equals("Voluntario Test") &&
                voluntario.getApellido().equals("Apellido Test")) {
                testVoluntario.setId(voluntario.getId());
                break;
            }
        }

        ModeloRuta.insertarVoluntario(testRuta.getId(), testVoluntario.getId());

        // Crear un médico de prueba y asociarlo a la ruta
        testMedico = new Medico();
        testMedico.setNombre("Medico Test");
        testMedico.setApellido("Apellido Test");
        testMedico.setEspecialidad("Especialidad Test");
        ModeloMedico modeloMedico = new ModeloMedico();
        modeloMedico.insertarMedico(testMedico);

        // Recuperar el ID del médico recién insertado
        ArrayList<Medico> medicos = ModeloMedico.getTodos();
        for (Medico medico : medicos) {
            if (medico.getNombre().equals("Medico Test") &&
                medico.getApellido().equals("Apellido Test")) {
                testMedico.setId(medico.getId());
                break;
            }
        }

        ModeloRuta.insertarMedico(testRuta.getId(), testMedico.getId());
    }

    @Test
    public void testGetTodos() throws ClassNotFoundException, SQLException {
        ArrayList<Ruta> rutas = ModeloRuta.getTodos();
        assertNotNull(rutas);
        // Supongamos que hay al menos una ruta en la base de datos
        if (!rutas.isEmpty()) {
            Ruta ruta = rutas.get(0);
            assertNotNull(ruta);
            assertNotNull(ruta.getId());
            assertNotNull(ruta.getFechaSalida());
            assertNotNull(ruta.getFechaLlegada());
            assertNotNull(ruta.getOrigen());
            assertNotNull(ruta.getDestino());
            assertNotNull(ruta.getVoluntarios());
            assertNotNull(ruta.getMedicos());
        }
    }

    @Test
    public void testVerRuta() throws ClassNotFoundException, SQLException {
        // Verificar que la ruta de prueba se pueda recuperar correctamente
        Ruta ruta = ModeloRuta.verRuta(testRuta.getId());
        System.out.println(ruta);
        System.out.println(testRuta);
        assertNotNull(ruta);
        assertEquals(testRuta.getId(), ruta.getId());
        assertNotEquals(testRuta.getFechaSalida(), ruta.getFechaSalida());
        assertNotEquals(testRuta.getFechaLlegada(), ruta.getFechaLlegada());
        assertEquals(testRuta.getOrigen(), ruta.getOrigen());
        assertEquals(testRuta.getDestino(), ruta.getDestino());
        assertNotNull(ruta.getVoluntarios());
        assertNotNull(ruta.getMedicos());
    }

    @Test
    public void testModificar() throws ClassNotFoundException, SQLException {
        // Modificar la ruta de prueba
        testRuta.setOrigen("Origen Modificado");
        testRuta.setDestino("Destino Modificado");

        ModeloRuta modeloRuta = new ModeloRuta();
        modeloRuta.modificarRuta(testRuta);

        // Verificar que se haya modificado correctamente
        Ruta rutaModificada = ModeloRuta.verRuta(testRuta.getId());
        assertNotNull(rutaModificada);
        assertEquals("Origen Modificado", rutaModificada.getOrigen());
        assertEquals("Destino Modificado", rutaModificada.getDestino());
    }

    @Test
    public void testInsertarYEliminarRuta() throws ClassNotFoundException, SQLException {
        // Crear una nueva ruta para insertar
        Ruta nuevaRuta = new Ruta();
        nuevaRuta.setFechaSalida(new Date());
        nuevaRuta.setFechaLlegada(new Date());
        nuevaRuta.setOrigen("Nuevo Origen");
        nuevaRuta.setDestino("Nuevo Destino");

        ModeloRuta modeloRuta = new ModeloRuta();
        modeloRuta.insertarRuta(nuevaRuta);

        // Verificar que se haya insertado correctamente
        int idRuta = modeloRuta.getUltimaRuta();
        Ruta rutaInsertada = ModeloRuta.verRuta(idRuta);
        assertNotNull(rutaInsertada);

        // Eliminar la ruta insertada
        ModeloRuta.eliminarRuta(idRuta);

        // Verificar que se haya eliminado correctamente
        Ruta rutaEliminada = ModeloRuta.verRuta(idRuta);
        assertNull(rutaEliminada);
    }

    @Test
    public void testInsertarYEliminarVoluntario() throws ClassNotFoundException, SQLException {
        // Crear un nuevo voluntario para insertar
        Voluntario nuevoVoluntario = new Voluntario();
        nuevoVoluntario.setNombre("Nuevo Voluntario");
        nuevoVoluntario.setApellido("Nuevo Apellido");
        nuevoVoluntario.setEdad("30");
        nuevoVoluntario.setEmail("nuevo@voluntario.com");
        nuevoVoluntario.setTelefono("987654321");
        
        ModeloVoluntario modeloVoluntario = new ModeloVoluntario();
        modeloVoluntario.insertarVoluntarios(nuevoVoluntario);

        // Recuperar el ID del voluntario recién insertado
        ArrayList<Voluntario> voluntarios = ModeloVoluntario.getTodos();
        for (Voluntario voluntario : voluntarios) {
            if (voluntario.getNombre().equals("Nuevo Voluntario") &&
                voluntario.getApellido().equals("Nuevo Apellido")) {
                nuevoVoluntario.setId(voluntario.getId());
                break;
            }
        }

        ModeloRuta.insertarVoluntario(testRuta.getId(), nuevoVoluntario.getId());

        // Verificar que el voluntario se haya insertado correctamente en la ruta
        Ruta ruta = ModeloRuta.verRuta(testRuta.getId());
        assertNotNull(ruta.getVoluntarios().stream()
                          .filter(v -> v.getId() == nuevoVoluntario.getId())
                          .findFirst()
                          .orElse(null));

        // Eliminar el voluntario de la ruta
        ModeloRuta.eliminarVoluntario(testRuta.getId());

        // Verificar que el voluntario se haya eliminado correctamente de la ruta
        ruta = ModeloRuta.verRuta(testRuta.getId());
        assertNull(ruta.getVoluntarios().stream()
                       .filter(v -> v.getId() == nuevoVoluntario.getId()));
                       
    }
    
    @Test
    public void testInsertarYEliminarMedico() throws ClassNotFoundException, SQLException {
        // Crear un nuevo médico para insertar
        Medico nuevoMedico = new Medico();
        nuevoMedico.setNombre("Nuevo Médico");
        nuevoMedico.setApellido("Nuevo Apellido");
        nuevoMedico.setEspecialidad("Nueva Especialidad");

        // Insertar el médico en la base de datos
        ModeloMedico modeloMedico = new ModeloMedico();
        modeloMedico.insertarMedico(nuevoMedico);

        // Recuperar el ID del médico recién insertado
        ArrayList<Medico> medicos = ModeloMedico.getTodos();
        for (Medico medico : medicos) {
            if (medico.getNombre().equals("Nuevo Médico") &&
                medico.getApellido().equals("Nuevo Apellido")) {
                nuevoMedico.setId(medico.getId());
                break;
            }
        }

        // Insertar el médico en la ruta de prueba
        ModeloRuta.insertarMedico(testRuta.getId(), nuevoMedico.getId());

        // Verificar que el médico se haya insertado correctamente en la ruta
        Ruta ruta = ModeloRuta.verRuta(testRuta.getId());
        assertNotNull(ruta.getMedicos().stream()
                          .filter(m -> m.getId() == nuevoMedico.getId())
                          .findFirst()
                          .orElse(null));

        // Eliminar el médico de la ruta
        ModeloRuta.eliminarMedico(testRuta.getId());

        // Verificar que el médico se haya eliminado correctamente de la ruta
        ruta = ModeloRuta.verRuta(testRuta.getId());
        assertNull(ruta.getMedicos().stream()
                       .filter(m -> m.getId() == nuevoMedico.getId()));
    }

}
