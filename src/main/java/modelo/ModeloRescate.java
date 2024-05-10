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
                rescate.setFechaHora(fechaHora); 
                rescate.setPosicion(rs.getString("posicion"));
                rescate.setIdRuta(rs.getInt("idRuta"));

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
	
public static int getUltimoRescate() throws ClassNotFoundException {
		
		try { 
			Connection con = Conector.getConnection();

			PreparedStatement pst = con.prepareStatement("SELECT id FROM Rescate ORDER BY id DESC LIMIT 1");
		
			ResultSet rs = pst.executeQuery();
		
			if (rs.next()) {
			
				int id = rs.getInt("id");
				return id;
			}
			
		} catch (SQLException e)

		{
			e.printStackTrace();
		}

		return -1;
	}


		public void modificar(Rescate rescate) throws ClassNotFoundException {
	        try {
	            Connection con = Conector.getConnection();
	            PreparedStatement pst = con.prepareStatement(
	                    "UPDATE Rescate SET fechaHora = ?, posicion = ?, idRuta = ? WHERE id = ?");
	            pst.setTimestamp(1, Timestamp.valueOf(rescate.getFechaHora())); // Convertir LocalDateTime a Timestamp
	            pst.setString(2, rescate.getPosicion());
	            pst.setInt(3, rescate.getIdRuta());
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
		            rescate.setFechaHora(rs.getTimestamp("fechaHora").toLocalDateTime()); // Mantener como LocalDateTime
		            rescate.setPosicion(rs.getString("posicion"));
		            rescate.setIdRuta(rs.getInt("idRuta"));

		            return rescate;
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return null;
		}

	    public void insertarRescate(Rescate rescate) throws ClassNotFoundException, SQLException {
	        Connection con = Conector.getConnection();
	        PreparedStatement pst = con.prepareStatement("INSERT INTO Rescate (fechaHora,posicion,idRuta) VALUES (?,?,?)");

	        pst.setTimestamp(1, Timestamp.valueOf(rescate.getFechaHora())); // Convertir LocalDateTime a Timestamp
	        pst.setString(2, rescate.getPosicion());
	        pst.setInt(3, rescate.getIdRuta());
	        pst.execute();
	    }

	    public void eliminarRescate(int id) throws ClassNotFoundException, SQLException {
	        Connection con = Conector.getConnection();
	        PreparedStatement pst = con.prepareStatement("DELETE FROM Rescate WHERE id=?");
	        pst.setInt(1, id);
	        pst.execute();
	    }
	}