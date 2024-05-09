package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloRescatado {

	public static ArrayList<Rescatado> getTodos() {

		Connection con;
		ArrayList<Rescatado> rescatados = new ArrayList<>();

		try {
			con = Conector.getConnection();

			PreparedStatement pst = con.prepareStatement("SELECT * FROM Rescatado");
			ResultSet rs = pst.executeQuery();
			// Iterar sobre los resultados

			while (rs.next()) {
				Rescatado rescatado = new Rescatado();

				rescatado.setId(rs.getInt("id"));
				rescatado.setNacionalidad(rs.getString("nacionalidad"));
				rescatado.setNombre(rs.getString("nombre"));
				rescatado.setSexo(rs.getString("sexo"));
				rescatado.setEdad(rs.getString("edad"));
				rescatado.setIdRescate(rs.getInt("idRescate"));

				rescatados.add(rescatado);
			}
			rs.close();
			pst.close();
			con.close();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		return rescatados;

	}

	public void modificar(Rescatado rescatado) throws ClassNotFoundException {

		try {

			Connection con = Conector.getConnection();
			PreparedStatement pst = con.prepareStatement(
					"UPDATE Rescatado SET nacionalidad = ?, nombre = ?, sexo = ?, edad = ?, idRescate = ? WHERE id = ?");
			pst.setString(1, rescatado.getNacionalidad());
			pst.setString(2, rescatado.getNombre());
			pst.setString(3, rescatado.getSexo());
			pst.setString(4, rescatado.getEdad());
			pst.setInt(5, rescatado.getIdRescate());
			pst.setInt(6, rescatado.getId());

			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public static Rescatado verRescatado(int id) throws ClassNotFoundException, SQLException {

		try {
			Connection con = Conector.getConnection();
			PreparedStatement pst = con.prepareStatement("SELECT * FROM Rescatado WHERE id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				Rescatado rescatado = new Rescatado();
				
				rescatado.setId(rs.getInt("id"));
				rescatado.setNacionalidad(rs.getString("nacionalidad"));
				rescatado.setNombre(rs.getString("nombre"));
				rescatado.setSexo(rs.getString("sexo"));
				rescatado.setEdad(rs.getString("edad"));
				rescatado.setIdRescate(rs.getInt("idRescate"));

				return rescatado;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insertarRescatado(Rescatado rescatado) throws ClassNotFoundException, SQLException {
		Connection con = Conector.getConnection();
		PreparedStatement pst = con
				.prepareStatement("INSERT INTO Rescatado (nacionalidad,nombre,sexo,edad,idRescate) VALUES (?,?,?,?,?)");
		pst.setString(1, rescatado.getNacionalidad());
		pst.setString(2, rescatado.getNombre());
		pst.setString(3, rescatado.getSexo());
		pst.setString(4, rescatado.getEdad());
		pst.setInt(5, rescatado.getIdRescate());
		pst.execute();
	}

	public void eliminarRescatado(int id) throws ClassNotFoundException, SQLException {
		Connection con = Conector.getConnection();
		PreparedStatement pst = con.prepareStatement("DELETE FROM Rescatado WHERE id = ?");
		pst.setInt(1, id);
		pst.execute();

	}
	
public static int getUltimoRescatado() throws ClassNotFoundException {
		
		try { 
			Connection con = Conector.getConnection();
			PreparedStatement pst = con.prepareStatement("SELECT id FROM Rescatado ORDER BY id DESC LIMIT 1");
			ResultSet rs = pst.executeQuery();
		
			if (rs.next()) {
				int id = rs.getInt("id");
				return id;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return -1;
	}
}
