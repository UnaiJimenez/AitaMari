package controladorRescatado;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloRescatado;
import modelo.Rescatado;

/**
 * Servlet implementation class ModificarRescatado
 */
@WebServlet("/ModificarRescatado")
public class ModificarRescatado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificarRescatado() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));

		try {
			
			Rescatado rescatado = ModeloRescatado.verRescatado(id);

			request.setAttribute("rescatado", rescatado);
			request.getRequestDispatcher("ModificarRescatado.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @throws IOException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
	int id = Integer.parseInt(request.getParameter("id"));
    String nacionalidad = request.getParameter("nacionalidad");
	String nombre = request.getParameter("nombre");
    String sexo = request.getParameter("sexo");
    String edad = request.getParameter("edad");   
    int idRescate = Integer.parseInt(request.getParameter("idRescate"));
    
    Rescatado rescatado = new Rescatado();
    rescatado.setId(id);
    rescatado.setNacionalidad(nacionalidad);
    rescatado.setNombre(nombre);
    rescatado.setSexo(sexo);
    rescatado.setEdad(edad);
    rescatado.setIdRescate(idRescate);
    ModeloRescatado mr = new ModeloRescatado();
    try {
        mr.modificar(rescatado);
    } catch (ClassNotFoundException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();    
        
    }
    
    response.sendRedirect("IndexRescatado");
}

}
