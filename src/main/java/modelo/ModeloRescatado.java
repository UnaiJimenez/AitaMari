package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
				
				Rescate rescate = getRescate(rs.getInt("idRescate"));
				rescatado.setRescate(rescate);

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

	public static Rescate getRescate(int id) throws ClassNotFoundException {
		
		try {
			Connection con = Conector.getConnection();
			PreparedStatement pst = con.prepareStatement("SELECT * FROM Rescate WHERE id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				Rescate rescate = new Rescate();
				
				rescate.setId(rs.getInt("id"));
				rescate.setFechaHora(((Timestamp) rs.getTimestamp("fechaHora")).toLocalDateTime());
				rescate.setPosicion(rs.getString("posicion"));
				
				Ruta ruta = new Ruta();
				rescate.setRuta(ruta);
				
				return rescate;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
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
			pst.setInt(5, rescatado.getRescate().getId());
			pst.setInt(6, rescatado.getId());

			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public static Rescatado verRescatado(int idRescate) throws ClassNotFoundException, SQLException {

		Rescatado rescatado = new Rescatado();
		
		try {
			Connection con = Conector.getConnection();
			PreparedStatement pst = con.prepareStatement("SELECT * FROM Rescatado WHERE id = ?");
			pst.setInt(1, idRescate);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				
				rescatado.setId(rs.getInt("id"));
				rescatado.setNacionalidad(rs.getString("nacionalidad"));
				rescatado.setNombre(rs.getString("nombre"));
				rescatado.setSexo(rs.getString("sexo"));
				rescatado.setEdad(rs.getString("edad"));
					
				Rescate rescate = getRescate(rs.getInt("idRescate"));
				rescatado.setRescate(rescate);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rescatado;
	}

	public void insertarRescatado(Rescatado rescatado) throws ClassNotFoundException, SQLException {
		Connection con = Conector.getConnection();
		PreparedStatement pst = con
				.prepareStatement("INSERT INTO Rescatado (nacionalidad,nombre,sexo,edad,idRescate) VALUES (?,?,?,?,?)");
		pst.setString(1, rescatado.getNacionalidad());
		pst.setString(2, rescatado.getNombre());
		pst.setString(3, rescatado.getSexo());
		pst.setString(4, rescatado.getEdad());
		pst.setInt(5, rescatado.getRescate().getId());
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
