package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloRescate {

	public static ArrayList<Rescate> getTodos() {

		Connection con;
		ArrayList<Rescate> rescates = new ArrayList<>();

		try {
			con = Conector.getConnection();

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Rescate");
			// Iterar sobre los resultados

			while (rs.next()) {
				Rescate rescate = new Rescate();

				rescate.setId(rs.getInt("id"));
				rescate.setFechaHora(rs.getDate("fechaHora"));
				rescate.setPosicion(rs.getString("posicion"));
				Ruta ruta = getRuta(rs.getInt("idRuta"));
				rescate.setRuta(ruta);

				rescates.add(rescate);
			}
			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rescates;

	}

	public static Ruta getRuta(int id) throws ClassNotFoundException {
		
		try {
			Connection con = Conector.getConnection();
			PreparedStatement pst = con.prepareStatement("SELECT * FROM Ruta WHERE id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				Ruta ruta = new Ruta();
				
				ruta.setId(rs.getInt("id"));
				ruta.setFechaSalida(rs.getDate("fechaSalida"));
				ruta.setFechaLlegada(rs.getDate("fechaLlegada"));
				ruta.setOrigen(rs.getString("origen"));
				ruta.setDestino(rs.getString("destino"));
		
				ArrayList<Voluntario> voluntarios = getVoluntarios(ruta.getId());
				ArrayList<Medico> medicos = getMedicos(ruta.getId());
				ruta.setVoluntarios(voluntarios);
				ruta.setMedicos(medicos);
				
				return ruta;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static ArrayList<Medico> getMedicos(int id) throws SQLException, ClassNotFoundException {
		Connection con = Conector.getConnection();
		PreparedStatement pst = con.prepareStatement(
				"SELECT ParticipantesMedicos.idRuta, ParticipantesMedicos.idMedico, Medico.nombre, Medico.apellido, Medico.especialidad\r\n"
						+ "FROM Medico\r\n"
						+ "INNER JOIN ParticipantesMedicos ON Medico.id = ParticipantesMedicos.idMedico\r\n"
						+ "INNER JOIN Ruta ON Ruta.id = ParticipantesMedicos.idRuta\r\n" + "WHERE Ruta.id = ?;");
		ArrayList<Medico> medicos = new ArrayList<Medico>();
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			Medico medico = new Medico();

			medico.setId(rs.getInt("idMedico"));
			medico.setNombre(rs.getString("nombre"));
			medico.setApellido(rs.getString("apellido"));
			medico.setEspecialidad(rs.getString("especialidad"));

			medicos.add(medico);
		}
		rs.close();
		con.close();
		return medicos;

	}

	public static ArrayList<Voluntario> getVoluntarios(int id) throws ClassNotFoundException, SQLException {
		Connection con = Conector.getConnection();
		PreparedStatement pst = con.prepareStatement(
				"SELECT ParticipantesVoluntarios.idRuta, ParticipantesVoluntarios.idVoluntario, Voluntario.nombre, Voluntario.apellido, Voluntario.edad, Voluntario.email, Voluntario.telefono \r\n"
						+ "FROM Voluntario\r\n"
						+ "INNER JOIN ParticipantesVoluntarios ON Voluntario.id = ParticipantesVoluntarios.idVoluntario\r\n"
						+ "INNER JOIN Ruta ON Ruta.id = ParticipantesVoluntarios.idRuta\r\n" + "WHERE Ruta.id = ?;");
		ArrayList<Voluntario> voluntarios = new ArrayList<Voluntario>();
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {

			Voluntario voluntario = new Voluntario();
			voluntario.setId(rs.getInt("idVoluntario"));
			voluntario.setEdad(rs.getString("edad"));
			voluntario.setNombre(rs.getString("nombre"));
			voluntario.setApellido(rs.getString("apellido"));
			voluntario.setEmail(rs.getString("email"));
			voluntario.setTelefono(rs.getString("telefono"));

			voluntarios.add(voluntario);
		}
		rs.close();
		con.close();

		return voluntarios;
	}

	public void modificar(Rescate rescate) throws ClassNotFoundException {

		try {

			Connection con = Conector.getConnection();
			PreparedStatement pst = con.prepareStatement(
					"UPDATE Rescate SET fechaHora = ?, posicion = ?, idRuta = ? WHERE id = ?");
			pst.setDate(1, new java.sql.Date(rescate.getFechaHora().getTime()));			
			pst.setString(2, rescate.getPosicion());
			pst.setInt(3, rescate.getRuta().getId());
			
			pst.setInt(4, rescate.getId());
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public static Rescate verRescate(int id) throws ClassNotFoundException, SQLException {

		try {
			Connection con = Conector.getConnection();
			PreparedStatement pst = con.prepareStatement("SELECT * FROM Rescate WHERE id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				Rescate rescate = new Rescate();
				rescate.setId(rs.getInt("id"));
				rescate.setFechaHora(rs.getDate("fechaHora"));
				rescate.setPosicion(rs.getString("posicion"));
				Ruta ruta = getRuta(rs.getInt("idRuta"));
				rescate.setRuta(ruta);
				
				return rescate;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
	

	public void insertarRescate(Rescate rescate) throws ClassNotFoundException, SQLException {
		Connection con = Conector.getConnection();
		PreparedStatement pst = con.prepareStatement("INSERT INTO Rescate (fechaHora,posicion,idRuta) VALUES (?,?,?)");
		
		pst.setDate(1, new java.sql.Date(rescate.getFechaHora().getTime()));
		pst.setString(2, rescate.getPosicion());
		pst.setInt(3, rescate.getRuta().getId());
		pst.execute();
	}
	
	public void eliminarRescate(int id) throws ClassNotFoundException, SQLException {
		Connection con =Conector.getConnection();
		PreparedStatement pst = con.prepareStatement("DELETE FROM Rescate WHERE id=?");
		pst.setInt(1, id);
		pst.execute();
		
	}
}
