package controladorRuta;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloRuta;
import modelo.Ruta;

/**
 * Servlet implementation class EliminarRuta
 */
@WebServlet("/EliminarRuta")
public class EliminarRuta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarRuta() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			Ruta ruta = ModeloRuta.verRuta(id);

			request.setAttribute("ruta", ruta);
			request.getRequestDispatcher("Ruta/EliminarRuta.jsp").forward(request, response);	
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		boolean eliminarNoOk = false;
		boolean eliminarOk = false;
		
		int id = Integer.parseInt(request.getParameter("id"));

		int confirmacion = Integer.parseInt(request.getParameter("Confirmacion"));
		if(confirmacion == 1) {
			
			try {
				ModeloRuta.eliminarMedico(id);
				ModeloRuta.eliminarVoluntario(id);
				ModeloRuta.eliminarRuta(id);
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
		request.getRequestDispatcher("IndexRuta").forward(request, response);	
	}

}
