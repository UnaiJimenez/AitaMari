package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ModeloFichaMedica {

	public static ArrayList<FichaMedica> getTodos() {
		
		Connection con;
		ArrayList<FichaMedica> fichasMedicas = new ArrayList<>();
		
		try {
			con = Conector.getConnection();
			
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM FichaMedica");
			
			while (rs.next()) {
				FichaMedica fichaMedica = new FichaMedica();
				
				fichaMedica.setId(rs.getInt("id"));
				fichaMedica.setConstantesVitales(rs.getString("constantesVitales"));
				fichaMedica.setAlergias(rs.getString("alergias"));
				fichaMedica.setTipoSangre(rs.getString("tipoSangre"));
				fichaMedica.setIdRescatado(rs.getInt("idRescatado"));
				
				fichasMedicas.add(fichaMedica);
			}
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return fichasMedicas;
	}
	
	public void modificar(FichaMedica fichaMedica) throws ClassNotFoundException {

		try {

			Connection con = Conector.getConnection();
			PreparedStatement pst = con.prepareStatement(
					"UPDATE FichaMedica SET constantesVitales = ?, alergias = ?, tipoSangre = ?, idRescatado = ? WHERE id = ?");
			pst.setString(1, fichaMedica.getConstantesVitales());
			pst.setString(2, fichaMedica.getAlergias());
			pst.setString(3, fichaMedica.getTipoSangre());
			pst.setInt(4, fichaMedica.getIdRescatado());
			pst.setInt(5, fichaMedica.getId());

			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public static FichaMedica verFichaMedica(int id) throws ClassNotFoundException, SQLException {

		try {
			Connection con = Conector.getConnection();
			PreparedStatement pst = con.prepareStatement("SELECT * FROM FichaMedica WHERE id = ?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();

			if (rs.next()) {
				FichaMedica fichaMedica = new FichaMedica();
				fichaMedica.setId(rs.getInt("id"));
				fichaMedica.setConstantesVitales(rs.getString("constantesVitales"));
				fichaMedica.setAlergias(rs.getString("alergias"));
				fichaMedica.setTipoSangre(rs.getString("tipoSangre"));
				fichaMedica.setIdRescatado(rs.getInt("idRescatado"));

				return fichaMedica;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
	

	public void insertarFichasMedicas(FichaMedica fichaMedica) throws ClassNotFoundException, SQLException {
		Connection con = Conector.getConnection();
		PreparedStatement pst = con.prepareStatement("INSERT INTO FichaMedica (constantesVitales,alergias,tipoSangre,IdRescatado) VALUES (?,?,?,?)");
		pst.setString(1, fichaMedica.getConstantesVitales());
		pst.setString(2, fichaMedica.getAlergias());
		pst.setString(3, fichaMedica.getTipoSangre());
		pst.setInt(4, fichaMedica.getIdRescatado());
		pst.execute();
	}
	
	public void eliminarFichaMedica(int id) throws ClassNotFoundException, SQLException {
		Connection con =Conector.getConnection();
		PreparedStatement pst = con.prepareStatement("DELETE FROM FichaMedica WHERE id=?");
		pst.setInt(1, id);
		pst.execute();
		
	}
}

