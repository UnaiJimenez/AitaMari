package modelo;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ModeloHistorico {

	
	public static Ruta VerHistorico() throws SQLException, ClassNotFoundException{
		Ruta ruta = new Ruta();
		Connection con = Conector.getConnection();
		Statement st = con.prepareStatement("CALL MaximoRescatados");
		
		
		return ruta;
		}
	
}
