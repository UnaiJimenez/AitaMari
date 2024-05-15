package controladorRescate;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloRescate;
import modelo.Rescate;

/**
 * Servlet implementation class EliminarVoluntario
 */
@WebServlet("/EliminarRescate")
public class EliminarRescate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarRescate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id = Integer.parseInt(request.getParameter("id"));
		
		Rescate rescate;
		try {
			rescate = ModeloRescate.verRescate(id);
			request.setAttribute("rescate", rescate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		request.getRequestDispatcher("Rescate/EliminarRescate.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		boolean eliminarNoOk = false;
		boolean eliminarOk = false;
		
		int id = Integer.parseInt(request.getParameter("id"));

		String confirmacion = (request.getParameter("Confirmacion"));
		if(confirmacion.equalsIgnoreCase("eliminar")) {
			ModeloRescate mr = new ModeloRescate();
			try {
				mr.eliminarRescate(id);
				eliminarOk = true;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				eliminarNoOk = true;
				e.printStackTrace();
			}
		}
		
		request.setAttribute("eliminarOk", eliminarOk);
		request.setAttribute("eliminarNoOk", eliminarNoOk);
		request.getRequestDispatcher("IndexRescate").forward(request, response);	
	}
}
