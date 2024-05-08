package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ModeloHistorico {

	
	public static Historico VerHistorico() throws SQLException, ClassNotFoundException{
		Historico historico = new Historico();
		Connection con = Conector.getConnection();
		Statement st = con.prepareStatement("CALL ObtenerRutaConMasRescatados");
		
		
		return historico;
		}
	
}
