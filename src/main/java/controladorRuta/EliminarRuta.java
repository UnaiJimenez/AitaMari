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
			request.getRequestDispatcher("EliminarRuta.jsp").forward(request, response);
			
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
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));

		int confirmacion = Integer.parseInt(request.getParameter("Confirmacion"));
		if(confirmacion == 1) {
			
			try {
				ModeloRuta.eliminarVoluntario(id);
				ModeloRuta.eliminarMedico(id);
				ModeloRuta.eliminarRuta(id);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		response.sendRedirect("IndexRuta");
		
	}

}
