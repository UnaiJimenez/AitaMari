package controlador;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloVoluntario;
import modelo.Voluntario;

/**
 * Servlet implementation class EliminarVoluntario
 */
@WebServlet("/EliminarVoluntario")
public class EliminarVoluntario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarVoluntario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloVoluntario mv = new ModeloVoluntario();
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			
			Voluntario voluntario = mv.verVoluntario(id);
			
			request.setAttribute("voluntario", voluntario);
			request.getRequestDispatcher("EliminarVoluntario.jsp").forward(request, response);
			
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
		System.out.println(id);
		if(confirmacion == 1) {
			ModeloVoluntario mv = new ModeloVoluntario();
			try {
				mv.eliminarVoluntario(id);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		response.sendRedirect("IndexVoluntarios");
		
	}

}
