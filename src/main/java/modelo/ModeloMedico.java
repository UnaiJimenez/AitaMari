package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloMedico {

    public static ArrayList<Medico> getTodos() {

        Connection con;
        ArrayList<Medico> medicos = new ArrayList<>();

        try {
            con = Conector.getConnection();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Medico");
            // Iterar sobre los resultados

            while (rs.next()) {
                Medico medico = new Medico();

                medico.setId(rs.getInt("id"));
                medico.setNombre(rs.getString("nombre"));
                medico.setApellido(rs.getString("apellido"));
                medico.setEspecialidad(rs.getString("especialidad"));

                medicos.add(medico);
            }
            rs.close();
            st.close();
            con.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return medicos;

    }

    public static void modificar(Medico medico) throws ClassNotFoundException {

        try {

            Connection con = Conector.getConnection();
            PreparedStatement pst = con.prepareStatement(
                    "UPDATE Medico SET nombre = ?, apellido = ?, especialidad = ? WHERE id = ?");
            pst.setString(1, medico.getNombre());
            pst.setString(2, medico.getApellido());
            pst.setString(3, medico.getEspecialidad());
            pst.setInt(4, medico.getId());

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public static Medico verMedico(int id) throws ClassNotFoundException, SQLException {

        try {
            Connection con = Conector.getConnection();
            PreparedStatement pst = con.prepareStatement("SELECT * FROM Medico WHERE id = ?");
            pst.setInt(1, id);            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                Medico medico = new Medico();
                medico.setId(rs.getInt("id"));
                medico.setNombre(rs.getString("nombre"));
                medico.setApellido(rs.getString("apellido"));
                medico.setEspecialidad(rs.getString("especialidad"));

                return medico;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public static void insertarMedico(Medico medico) throws ClassNotFoundException, SQLException {
        Connection con = Conector.getConnection();
        PreparedStatement pst = con.prepareStatement("INSERT INTO Medico (nombre,apellido,especialidad) VALUES (?,?,?)");
        pst.setString(1, medico.getNombre());
        pst.setString(2, medico.getApellido());
        pst.setString(3, medico.getEspecialidad());
        pst.execute();
    }

    public static void eliminarMedico(int id) throws ClassNotFoundException, SQLException {
        Connection con = Conector.getConnection();
        PreparedStatement pst = con.prepareStatement("DELETE FROM Medico WHERE id=?");
        pst.setInt(1, id);
        pst.execute();

    }
}
