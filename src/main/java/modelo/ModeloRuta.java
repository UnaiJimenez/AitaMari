package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloRuta {

	public static ArrayList<Ruta> getTodos() {

		Connection con;
		ArrayList<Ruta> rutas = new ArrayList<>();

		try {
			con = Conector.getConnection();

			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM Ruta");
			// Iterar sobre los resultados

			while (rs.next()) {
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
				rutas.add(ruta);
			}
			rs.close();
			st.close();
			con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return rutas;

	}

	public static ArrayList<Voluntario> getVoluntarios(int id) throws ClassNotFoundException, SQLException {
		Connection con = Conector.getConnection();
		PreparedStatement pst = con.prepareStatement("SELECT ParticipantesVoluntarios.idRuta, ParticipantesVoluntarios.idVoluntario, Voluntario.nombre, Voluntario.apellido, Voluntario.edad, Voluntario.email, Voluntario.telefono \r\n"
				+ "FROM Voluntario\r\n"
				+ "INNER JOIN ParticipantesVoluntarios ON Voluntario.id = ParticipantesVoluntarios.idVoluntario\r\n"
				+ "INNER JOIN Ruta ON Ruta.id = ParticipantesVoluntarios.idRuta\r\n"
				+ "WHERE Ruta.id = ?;");
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
	
	

	public static ArrayList<Medico> getMedicos(int id) throws SQLException, ClassNotFoundException {
		Connection con = Conector.getConnection();
		PreparedStatement pst = con.prepareStatement("SELECT ParticipantesMedicos.idRuta, ParticipantesMedicos.idMedico, Medico.nombre, Medico.apellido, Medico.especialidad\r\n"
				+ "FROM Medico\r\n"
				+ "INNER JOIN ParticipantesMedicos ON Medico.id = ParticipantesMedicos.idMedico\r\n"
				+ "INNER JOIN Ruta ON Ruta.id = ParticipantesMedicos.idRuta\r\n"
				+ "WHERE Ruta.id = ?;");
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

	public void modificar(Ruta ruta) throws ClassNotFoundException {

		try {

			Connection con = Conector.getConnection();
			PreparedStatement pst = con.prepareStatement(
					"UPDATE Ruta SET fechaSalida = ?, fechaLlegada = ?, origen = ?, destino = ? WHERE id = ?");
			pst.setDate(1,new java.sql.Date(ruta.getFechaSalida().getTime()) );
			pst.setDate(2,new java.sql.Date(ruta.getFechaLlegada().getTime()));
			pst.setString(3, ruta.getOrigen());
			pst.setString(4, ruta.getDestino());

			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public static Ruta verRuta(int id) throws ClassNotFoundException, SQLException {

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
				ruta.setMedicos(medicos);
				ruta.setVoluntarios(voluntarios);

				return ruta;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}

	public void insertarRuta(Ruta ruta) throws ClassNotFoundException, SQLException {
		Connection con = Conector.getConnection();
		PreparedStatement pst = con
				.prepareStatement("INSERT INTO Ruta (fechaSalida,fechaLlegada,origen,destino) VALUES (?,?,?,?)");
		pst.setDate(1, new java.sql.Date(ruta.getFechaSalida().getTime()));
		pst.setDate(2, new java.sql.Date(ruta.getFechaLlegada().getTime()));
		pst.setString(3, ruta.getOrigen());
		pst.setString(4, ruta.getDestino());
		pst.execute();
	}

	public static void eliminarRuta(int id) throws ClassNotFoundException, SQLException {
		Connection con = Conector.getConnection();
		PreparedStatement pst = con.prepareStatement("DELETE FROM Ruta WHERE id=?");
		pst.setInt(1, id);
		pst.execute();

	}

	public void modificarRuta(Ruta ruta) throws ClassNotFoundException {
		try {

            Connection con = Conector.getConnection();
            PreparedStatement pst = con.prepareStatement("UPDATE Ruta SET fechaSalida = ?, fechaLlegada = ?, origen = ?, destino = ? WHERE id = ?");
    		pst.setDate(1, new java.sql.Date(ruta.getFechaSalida().getTime()));
    		pst.setDate(2, new java.sql.Date(ruta.getFechaLlegada().getTime()));
    		pst.setString(3, ruta.getOrigen());
    		pst.setString(4, ruta.getDestino());
    		pst.setInt(5, ruta.getId());

            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

		
	}

