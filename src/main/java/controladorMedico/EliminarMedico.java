package controladorMedico;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Medico;
import modelo.ModeloMedico;

/**
 * Servlet implementation class EliminarMedico
 */
@WebServlet("/EliminarMedico")
public class EliminarMedico extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarMedico() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	ModeloMedico mm = new ModeloMedico();
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			
			Medico medico = mm.verMedico(id);
			
			request.setAttribute("medico", medico);
			request.getRequestDispatcher("EliminarMedico.jsp").forward(request, response);
			
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
			ModeloMedico mm = new ModeloMedico();
			try {
				mm.eliminarMedico(id);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
		
		response.sendRedirect("IndexMedicos");
		
	}

}
