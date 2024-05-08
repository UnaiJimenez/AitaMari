package controladorRescatado;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloRescatado;
import modelo.ModeloVoluntario;
import modelo.Rescatado;

/**
 * Servlet implementation class InsertarRescatado
 */
@WebServlet("/InsertarRescatado")
public class InsertarRescatado extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertarRescatado() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("InsertarRescatado.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nacionalidad = request.getParameter("nacionalidad");
		String nombre = request.getParameter("nombre");
		String sexo = request.getParameter("sexo");
		String edad = request.getParameter("edad");
		int idRescate = Integer.parseInt(request.getParameter("idRescate"));
		
		Rescatado rescatado = new Rescatado();
		rescatado.setNacionalidad(nacionalidad);
		rescatado.setNombre(nombre);
		rescatado.setSexo(sexo);
		rescatado.setEdad(edad);
		rescatado.setIdRescate(idRescate);
		
		String confirmacion = (request.getParameter("Confirmacion"));
		if(confirmacion.equalsIgnoreCase("insertar")) {
			ModeloRescatado mr = new ModeloRescatado();
			try {
				mr.insertarRescatado(rescatado);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		response.sendRedirect("IndexRescatado");
		
	}

}
