package controladorRescate;

import java.io.IOException;
import java.util.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloRescate;
import modelo.Rescate;

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

		request.getRequestDispatcher("InsertarRescate.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		String fh = request.getParameter("fechaHora");

		try {
			Date fechaHora = sdf.parse(fh);
			String posicion = request.getParameter("apellido");
			int idRuta = Integer.parseInt(request.getParameter("idRuta"));

			Rescate rescate = new Rescate();
			rescate.setFechaHora(fechaHora);
			rescate.setPosicion(posicion);
			rescate.setIdRuta(idRuta);

			ModeloRescate mr = new ModeloRescate();
			try {

				mr.insertarRescates(rescate);

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (ParseException e) {

			e.printStackTrace();
		}

		response.sendRedirect("IndexRescates");

	}

}
