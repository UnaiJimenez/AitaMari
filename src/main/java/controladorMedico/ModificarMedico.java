package controladorMedico;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloMedico;
import modelo.Medico;

/**
 * Servlet implementation class ModificarMedico
 */
@WebServlet("/ModificarMedico")
public class ModificarMedico extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificarMedico() {
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
			Medico medico = ModeloMedico.verMedico(id);

			request.setAttribute("medico", medico);
			request.getRequestDispatcher("ModificarMedicos.jsp").forward(request, response);
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String especialidad = request.getParameter("especialidad");	
		
		Medico medico = new Medico();
		medico.setId(id);
		medico.setNombre(nombre);
		medico.setApellido(apellido);
		medico.setEspecialidad(especialidad);
		
		String confirmacion = request.getParameter("Confirmacion");
		if(confirmacion.equalsIgnoreCase("modificar")) {
			ModeloMedico mm = new ModeloMedico();
			try {
				mm.modificar(medico);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

		response.sendRedirect("IndexMedico");
	}

}
