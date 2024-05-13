package controladorFichaMedica;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.FichaMedica;
import modelo.ModeloFichaMedica;
import modelo.ModeloVoluntario;
import modelo.Voluntario;

/**
 * Servlet implementation class EliminarFichaMedica
 */
@WebServlet("/EliminarFichaMedica")
public class EliminarFichaMedica extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarFichaMedica() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			
			FichaMedica fichaMedica = ModeloFichaMedica.verFichaMedica(id);
			
			request.setAttribute("fichaMedica", fichaMedica);
			request.getRequestDispatcher("FichaMedica/EliminarFichaMedica.jsp").forward(request, response);
			
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

		String confirmacion = (request.getParameter("Confirmacion"));
		System.out.println(id);
		if(confirmacion.equalsIgnoreCase("eliminar")) {
			ModeloFichaMedica mfm = new ModeloFichaMedica();
			try {
				mfm.eliminarFichaMedica(id);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		response.sendRedirect("IndexFichaMedica");
	}

}
