package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ModeloHistorico {

	
	public static Historico VerHistorico() throws SQLException, ClassNotFoundException{
		Historico historico = new Historico();
		Connection con = Conector.getConnection();
		Statement st = con.prepareStatement("CALL ObtenerRutaConMasRescatados");
		
		
		
		return historico;
		}
	
	public static void insertarVoluntario(int idRuta, int idVoluntario) throws ClassNotFoundException, SQLException {
		Connection con = Conector.getConnection();
		PreparedStatement pst = con
				.prepareStatement("SELECT(idRuta,idVoluntario) VALUES (?,?)");
		pst.setInt(1, idRuta);
		pst.setInt(2, idVoluntario);
		pst.execute();
	}
	
}


