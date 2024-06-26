package controladorRescate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloRescatado;
import modelo.ModeloRescate;
import modelo.ModeloRuta;
import modelo.Rescate;
import modelo.Ruta;

/**
 * Servlet implementation class InsertarVoluntario
 */
@WebServlet("/InsertarRescate")
public class InsertarRescate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertarRescate() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Ruta> rutas = ModeloRuta.getTodos();
		request.setAttribute("rutas", rutas);
		request.getRequestDispatcher("Rescate/InsertarRescate.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		
		boolean insertarOk = false;
		
	    String confirmacion = request.getParameter("Confirmacion");

	    // Verificar si la fecha y hora no son nulas ni vac�as antes de analizarlas
	    if (confirmacion.equalsIgnoreCase("insertar")) {
	        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
	        String fh = request.getParameter("fechaHora");

	        if (fh != null && !fh.isEmpty()) {
	            LocalDateTime fechaHora = LocalDateTime.parse(fh, formato);

	            String posicion = request.getParameter("posicion");
	            int idRuta = Integer.parseInt(request.getParameter("idRuta"));

	            try {
	                Ruta ruta = ModeloRescate.getRuta(idRuta);

	                Rescate rescate = new Rescate();
	                rescate.setFechaHora(fechaHora);
	                rescate.setPosicion(posicion);
	                rescate.setRuta(ruta);
	                ModeloRescate mr = new ModeloRescate();
	                try {
	                    mr.insertarRescate(rescate);
	                    insertarOk = true;
	                } catch (ClassNotFoundException e) {
	                    e.printStackTrace();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }
	    
	    request.setAttribute("insertarOk", insertarOk);
	    request.getRequestDispatcher("IndexRescate").forward(request, response);
	}
}
