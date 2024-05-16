package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conector {

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
        final String URL = "jdbc:mysql://192.168.1.10:33061/AitaMari";
        final String USERNAME = "root";
        final String PASSWORD = "plaiaundi";

        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        
        return con;
    }
}
