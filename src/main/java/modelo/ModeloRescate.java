package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ModeloRescate {

	public static ArrayList<Rescate> getTodos() {
        Connection con;
        ArrayList<Rescate> rescates = new ArrayList<>();

        try {
            con = Conector.getConnection();

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Rescate");

            while (rs.next()) {
                Rescate rescate = new Rescate();

                LocalDateTime fechaHora = rs.getTimestamp("fechaHora").toLocalDateTime();

				rescate.setId(rs.getInt("id"));
				rescate.setFechaHora(((Timestamp) rs.getTimestamp("fechaHora")).toLocalDateTime());
				rescate.setPosicion(rs.getString("posicion"));
				
				Ruta ruta = getRuta(rs.getInt("idRuta"));
				rescate.setRuta(ruta);
				
				ArrayList<Rescatado> rescatados = getRescatados(rescate.getId());
				rescate.setRescatados(rescatados);

                rescates.add(rescate);
            }
            rs.close();
            st.close();
            con.close();
            
           } catch (ClassNotFoundException | SQLException e) {
        	   e.printStackTrace();
           }
        return rescates;
	}


	private static ArrayList<Rescatado> getRescatados(int id) throws ClassNotFoundException, SQLException {
		Connection con = Conector.getConnection();
		PreparedStatement pst = con.prepareStatement("SELECT * FROM Rescatado WHERE idRescate = ?");
		ArrayList<Rescatado> rescatados = new ArrayList<Rescatado>();
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {

			Rescatado rescatado = new Rescatado();
			rescatado.setId(rs.getInt("id"));
			rescatado.setNacionalidad(rs.getString("nacionalidad"));
			rescatado.setNombre(rs.getString("nombre"));
			rescatado.setSexo(rs.getString("sexo"));
			rescatado.setEdad(rs.getString("edad"));

			rescatados.add(rescatado);
		}
		rs.close();
		con.close();

		return rescatados;
	}

	public void modificar(Rescate rescate) throws ClassNotFoundException {
	    
    try {
	    Connection con = Conector.getConnection();
	    PreparedStatement pst = con.prepareStatement(
					"UPDATE Rescate SET fechaHora = ?, posicion = ?, idRuta = ? WHERE id = ?");
			pst.setTimestamp(1, Timestamp.valueOf(rescate.getFechaHora()));			
			pst.setString(2, rescate.getPosicion());
			pst.setInt(3, rescate.getRuta().getId());
			
			pst.setInt(4, rescate.getId());
			pst.executeUpdate();
	} catch (SQLException e) {
			e.printStackTrace();
    }
	}
    
		public static Rescate verRescate(int idRuta) throws ClassNotFoundException, SQLException {
		   
			Rescate rescate = new Rescate();
			
			try {
		        Connection con = Conector.getConnection();
		        PreparedStatement pst = con.prepareStatement("SELECT * FROM Rescate WHERE id = ?");
		        pst.setInt(1, idRuta);
		        ResultSet rs = pst.executeQuery();

		        if (rs.next()) {
		            
				        rescate.setId(rs.getInt("id"));
              
				        rescate.setFechaHora(((Timestamp) rs.getTimestamp("fechaHora")).toLocalDateTime());
				        rescate.setPosicion(rs.getString("posicion"));
				        
				        Ruta ruta = getRuta(rs.getInt("idRuta"));
				        rescate.setRuta(ruta);
				        
				        ArrayList<Rescatado> rescatados = getRescatados(rescate.getId());
				        rescate.setRescatados(rescatados);

		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return rescate;
		}
    
public void insertarRescate(Rescate rescate) throws ClassNotFoundException, SQLException {
		
      Connection con = Conector.getConnection();
		  PreparedStatement pst = con.prepareStatement("INSERT INTO Rescate (fechaHora,posicion,idRuta) VALUES (?,?,?)");

		  pst.setTimestamp(1, Timestamp.valueOf(rescate.getFechaHora()));
		  pst.setString(2, rescate.getPosicion());
		  pst.setInt(3, rescate.getRuta().getId());
		  pst.execute();
	  }
    
public void eliminarRescate(int id) throws ClassNotFoundException, SQLException {
		      
      Connection con = Conector.getConnection();
	    PreparedStatement pst = con.prepareStatement("DELETE FROM Rescate WHERE id=?");
		  pst.setInt(1, id);
		  pst.execute();
    }
	
public static int getUltimoRescate() throws ClassNotFoundException {
		
		try { 
			Connection con = Conector.getConnection();
			PreparedStatement pst = con.prepareStatement("SELECT id FROM Rescate ORDER BY id DESC LIMIT 1");
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
}
