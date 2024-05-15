package controladorRescatado;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Medico;
import modelo.ModeloMedico;
import modelo.ModeloRescatado;
import modelo.Rescatado;

/**
 * Servlet implementation class EliminarRescatado
 */
@WebServlet("/EliminarRescatado")
public class EliminarRescatado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EliminarRescatado() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));

		try {

			Rescatado rescatado = ModeloRescatado.verRescatado(id);

			request.setAttribute("rescatado", rescatado);
			request.getRequestDispatcher("Rescatado/EliminarRescatado.jsp").forward(request, response);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean eliminarOk = false;
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		String confirmacion = (request.getParameter("Confirmacion"));
		if (confirmacion.equalsIgnoreCase("eliminar")) {
			ModeloRescatado mr = new ModeloRescatado();
			try {
				mr.eliminarRescatado(id);
				eliminarOk = true;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		request.setAttribute("eliminarOk", eliminarOk);
		request.getRequestDispatcher("IndexRescatado").forward(request, response);
	}
}
