package controladorRescate;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloRescate;
import modelo.Rescate;

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

			request.setAttribute("rescate", rescate);
			System.out.println(rescate);
			request.getRequestDispatcher("ModificarRescate.jsp").forward(request, response);
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
	    int id = Integer.parseInt(request.getParameter("id"));
	    String fh = request.getParameter("fechaHora");
	    String posicion = request.getParameter("posicion");
	    int idRuta = Integer.parseInt(request.getParameter("idRuta"));

	    LocalDateTime fechaHora = LocalDateTime.parse(fh);

	    Rescate rescate = new Rescate();
	    rescate.setId(id);
	    rescate.setFechaHora(fechaHora);
	    rescate.setPosicion(posicion);
	    rescate.setIdRuta(idRuta);

	    ModeloRescate mr = new ModeloRescate();
	    try {
	        mr.modificar(rescate);
	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }

	    response.sendRedirect("IndexRescate");
	}

}
