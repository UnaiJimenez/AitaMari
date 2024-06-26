package controladorVoluntario;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloVoluntario;
import modelo.Voluntario;
import validacion.MetodosValidacion;

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
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			Voluntario voluntario = ModeloVoluntario.verVoluntario(id);
			
			request.setAttribute("voluntario", voluntario);
			request.getRequestDispatcher("Voluntario/ModificarVoluntarios.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		// TODO Auto-generated method stub
	
		boolean modificarOk = false;
		boolean noEsEnteroMod = false;
		
		int id = Integer.parseInt(request.getParameter("id"));
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String edad = request.getParameter("edad");
		String email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		
		Voluntario voluntario = new Voluntario();
		voluntario.setId(id);
		voluntario.setNombre(nombre);
		voluntario.setApellido(apellido);
		voluntario.setEdad(edad);
		voluntario.setEmail(email);
		voluntario.setTelefono(telefono);
		
		String confirmacion = request.getParameter("Confirmacion");
		if(confirmacion.equalsIgnoreCase("modificar")) {
			ModeloVoluntario mv = new ModeloVoluntario();
			try {
				if(MetodosValidacion.esEntero(voluntario.getEdad()) == true) {
					mv.modificar(voluntario);
					modificarOk = true;
				}else{
					noEsEnteroMod = true;
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();		
			}
		}
		
		request.setAttribute("noEsEnteroMod", noEsEnteroMod);
		request.setAttribute("modificarOk", modificarOk);
		request.getRequestDispatcher("IndexVoluntario").forward(request, response);
		}

}
