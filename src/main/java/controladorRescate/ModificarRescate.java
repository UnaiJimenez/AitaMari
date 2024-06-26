package controladorRescate;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloRescate;
import modelo.ModeloRuta;
import modelo.Rescate;
import modelo.Ruta;

/**
 * Servlet implementation class ModificarVoluntario
 */
@WebServlet("/ModificarRescate")
public class ModificarRescate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificarRescate() {
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
			Rescate rescate = ModeloRescate.verRescate(id);
			ArrayList<Ruta> rutas = ModeloRuta.getTodos();
			request.setAttribute("rutas", rutas);
			request.setAttribute("rescate", rescate);
			request.getRequestDispatcher("Rescate/ModificarRescate.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean modificarOk = false;
		String confirmacion = request.getParameter("Confirmacion");
		if (confirmacion.equalsIgnoreCase("modificar")) {

			String fh = request.getParameter("fechaHora");
			LocalDateTime fechaHora = LocalDateTime.parse(fh);

			int id = Integer.parseInt(request.getParameter("id"));
			String posicion = request.getParameter("posicion");
			int idRuta = Integer.parseInt(request.getParameter("idRuta"));

			try {

				Ruta ruta = ModeloRescate.getRuta(idRuta);
				Rescate rescate = new Rescate();
				rescate.setId(id);
				rescate.setFechaHora(fechaHora);
				rescate.setPosicion(posicion);
				rescate.setRuta(ruta);

				ModeloRescate mr = new ModeloRescate();
				try {
					mr.modificar(rescate);
					modificarOk = true;
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		request.setAttribute("modificarOk", modificarOk);
		request.getRequestDispatcher("IndexRescate").forward(request, response);
	}
}
