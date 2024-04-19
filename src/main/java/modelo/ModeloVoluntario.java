package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloVoluntario {

	public static ArrayList<Voluntario> getTodos() {

		Connection con;
		ArrayList<Voluntario> voluntarios = new ArrayList<>();

		try {
			con = Conector.getConnection();

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Voluntario");
			// Iterar sobre los resultados

			while (rs.next()) {
				Voluntario voluntario = new Voluntario();

				voluntario.setId(rs.getInt("id"));
				voluntario.setEdad(rs.getString("edad"));
				voluntario.setNombre(rs.getString("nombre"));
				voluntario.setApellido(rs.getString("apellido"));
				voluntario.setEmail(rs.getString("email"));
				voluntario.setTelefono(rs.getString("telefono"));

				voluntarios.add(voluntario);
			}
			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return voluntarios;

	}

	public void modificar(Voluntario voluntario) throws ClassNotFoundException {

		try {

			Connection con = Conector.getConnection();
			PreparedStatement pst = con.prepareStatement(
					"UPDATE Voluntario SET nombre = ?, apellido = ?, edad = ?, email = ?, telefono = ? WHERE id = ?");
			pst.setString(1, voluntario.getNombre());
			pst.setString(2, voluntario.getApellido());
			pst.setString(3, voluntario.getEdad());
			pst.setString(4, voluntario.getEmail());
			pst.setString(5, voluntario.getTelefono());
			pst.setInt(6, voluntario.getId());

			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public static Voluntario verVoluntario(int id) throws ClassNotFoundException, SQLException {

		try {
			Connection con = Conector.getConnection();
			PreparedStatement pst = con.prepareStatement("SELECT * FROM Voluntario WHERE id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				Voluntario voluntario = new Voluntario();
				voluntario.setId(rs.getInt("id"));
				voluntario.setNombre(rs.getString("nombre"));
				voluntario.setApellido(rs.getString("apellido"));
				voluntario.setEdad(rs.getString("edad"));
				voluntario.setEmail(rs.getString("email"));
				voluntario.setTelefono(rs.getString("telefono"));

				
				return voluntario;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
	

	public void insertarVoluntarios(Voluntario voluntario) throws ClassNotFoundException, SQLException {
		Connection con = Conector.getConnection();
		PreparedStatement pst = con.prepareStatement("INSERT INTO Voluntario (nombre,apellido,edad,email,telefono) VALUES (?,?,?,?,?)");
		pst.setString(1, voluntario.getNombre());
		pst.setString(2, voluntario.getApellido());
		pst.setString(3, voluntario.getEdad());
		pst.setString(4, voluntario.getEmail());
		pst.setString(5, voluntario.getTelefono());
		pst.execute();
	}
}