package modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ModeloFichaMedicaTest {

    private ModeloFichaMedica modeloFichaMedica;

    @BeforeEach
    public void setUp() {
        modeloFichaMedica = new ModeloFichaMedica();
    }

    @Test
    public void testGetTodos() {
        ArrayList<FichaMedica> fichasMedicas = modeloFichaMedica.getTodos();
        assertNotNull(fichasMedicas);
    }

    @Test
    public void testModificar() {
        // Supongamos que tenemos una ficha médica existente
        FichaMedica fichaMedica = new FichaMedica();
        fichaMedica.setId(1);
        fichaMedica.setConstantesVitales("120/80");
        fichaMedica.setAlergias("Polen");
        fichaMedica.setTipoSangre("A+");
        Rescatado rescatado = new Rescatado();
        rescatado.setId(1);
        fichaMedica.setRescatado(rescatado);

        // Intentamos modificar la ficha médica
        assertDoesNotThrow(() -> modeloFichaMedica.modificar(fichaMedica));
    }

    @Test
    public void testVerFichaMedica() throws ClassNotFoundException, SQLException {
        // Supongamos que tenemos una ficha médica existente con ID 1
        FichaMedica fichaMedica = modeloFichaMedica.verFichaMedica(1);
        assertNull(fichaMedica);
    }

    @Test
    public void testInsertarFichasMedicas() throws ClassNotFoundException, SQLException {
        // Supongamos que tenemos una ficha médica nueva
        FichaMedica fichaMedica = new FichaMedica();
        fichaMedica.setConstantesVitales("120/80");
        fichaMedica.setAlergias("Polen");
        fichaMedica.setTipoSangre("A+");
        Rescatado rescatado = new Rescatado();
        rescatado.setId(1);
        fichaMedica.setRescatado(rescatado);

        // Intentamos insertar la ficha médica
        assertDoesNotThrow(() -> modeloFichaMedica.insertarFichasMedicas(fichaMedica));
    }

    @Test
    public void testEliminarFichaMedica() throws ClassNotFoundException, SQLException {
        // Supongamos que queremos eliminar una ficha médica existente con ID 1
        assertDoesNotThrow(() -> modeloFichaMedica.eliminarFichaMedica(1));
    }
}
