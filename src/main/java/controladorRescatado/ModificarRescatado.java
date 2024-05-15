package controladorRescatado;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloRescatado;
import modelo.ModeloRescate;
import modelo.Rescatado;
import modelo.Rescate;
import validacion.MetodosValidacion;

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
			ArrayList<Rescate> rescates = ModeloRescate.getTodos();
			request.setAttribute("rescates", rescates);
			request.setAttribute("rescatado", rescatado);
			System.out.println(rescatado);
			request.getRequestDispatcher("Rescatado/ModificarRescatado.jsp").forward(request, response);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * @throws IOException
	 * @throws ServletException 
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		
		boolean modificarOk = false;
		boolean noEsGeneroMod = false;
		
		String confirmacion = request.getParameter("Confirmacion");
		
		if (confirmacion.equalsIgnoreCase("modificar")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String nacionalidad = request.getParameter("nacionalidad");
			String nombre = request.getParameter("nombre");
			String sexo = request.getParameter("sexo");
			String edad = request.getParameter("edad");
			int idRescate = Integer.parseInt(request.getParameter("idRescate"));

			try {
				Rescate rescate = ModeloRescatado.getRescate(idRescate);
				Rescatado rescatado = new Rescatado();
				rescatado.setId(id);
				rescatado.setNacionalidad(nacionalidad);
				rescatado.setNombre(nombre);
				rescatado.setSexo(sexo);
				rescatado.setEdad(edad);
				rescatado.setRescate(rescate);

				ModeloRescatado mr = new ModeloRescatado();

				try {
					if(MetodosValidacion.esGenero(rescatado.getSexo()) == true) {
						mr.modificar(rescatado);
						modificarOk = true;
					}else {
						noEsGeneroMod = true;
					}
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		request.setAttribute("noEsGeneroMod", noEsGeneroMod);
		request.setAttribute("modificarOk", modificarOk);
		request.getRequestDispatcher("IndexRescatado").forward(request, response);
	}
}
