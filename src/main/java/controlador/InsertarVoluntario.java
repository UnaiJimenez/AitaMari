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
 * Servlet implementation class InsertarVoluntario
 */
@WebServlet("/InsertarVoluntario")
public class InsertarVoluntario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarVoluntario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("InsertarVoluntario.jsp").forward(request, response);
	
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String edad = request.getParameter("edad");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		
		Voluntario voluntario = new Voluntario();
		voluntario.setNombre(nombre);
		voluntario.setApellido(apellido);
		voluntario.setEdad(edad);
		voluntario.setEmail(email);
		voluntario.setTelefono(telefono);

		ModeloVoluntario mv = new ModeloVoluntario();
		
		
		
		try {
			
			mv.insertarVoluntarios(voluntario);
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("IndexVoluntarios");
		
	
	}

}
