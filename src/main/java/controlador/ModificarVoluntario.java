package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloVoluntario;
import modelo.Voluntario;

/**
 * Servlet implementation class ModificarVoluntario
 */
@WebServlet("/ModificarVoluntario")
public class ModificarVoluntario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarVoluntario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		// TODO Auto-generated method stub
		String nombre = request.getParameter("Nombre");
		String apellido = request.getParameter("Apellido");
		String edad = request.getParameter("Edad");
		String email = request.getParameter("Email");
		String telefono = request.getParameter("Telefono");
		
		Voluntario voluntario = new Voluntario();
		voluntario.setNombre(nombre);
		voluntario.setApellido(apellido);
		voluntario.setEdad(edad);
		voluntario.setEmail(email);
		voluntario.setTelefono(telefono);
		
		ModeloVoluntario mv = new ModeloVoluntario();
		try {
			mv.modificar(voluntario);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();	
			
		}
		
		response.sendRedirect("IndexVoluntarios");}

}
