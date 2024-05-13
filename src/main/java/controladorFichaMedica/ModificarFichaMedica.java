package controladorFichaMedica;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.FichaMedica;
import modelo.ModeloFichaMedica;
import modelo.ModeloRescatado;
import modelo.Rescatado;

/**
 * Servlet implementation class ModificarFichaMedica
 */
@WebServlet("/ModificarFichaMedica")
public class ModificarFichaMedica extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModificarFichaMedica() {
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
			FichaMedica fichaMedica = ModeloFichaMedica.verFichaMedica(id);

			ArrayList<Rescatado> rescatados = ModeloRescatado.getTodos();

			request.setAttribute("fichaMedica", fichaMedica);
			request.setAttribute("rescatados", rescatados);
			request.getRequestDispatcher("FichaMedica/ModificarFichaMedica.jsp").forward(request, response);
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String confirmacion = request.getParameter("Confirmacion");
		
		if (confirmacion.equalsIgnoreCase("modificar")) {
			int id = Integer.parseInt(request.getParameter("id"));
			String constantesVitales = request.getParameter("constantesVitales");
			String alergias = request.getParameter("alergias");
			String tipoSangre = request.getParameter("tipoSangre");
			int idRescatado = Integer.parseInt(request.getParameter("idRescatado"));

			try {
				Rescatado rescatado = ModeloFichaMedica.getRescatado(idRescatado);
				FichaMedica fichaMedica = new FichaMedica();
				fichaMedica.setId(id);
				fichaMedica.setConstantesVitales(constantesVitales);
				fichaMedica.setAlergias(alergias);
				fichaMedica.setTipoSangre(tipoSangre);
				fichaMedica.setRescatado(rescatado);

				ModeloFichaMedica mfm = new ModeloFichaMedica();

				mfm.modificar(fichaMedica);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		response.sendRedirect("IndexFichaMedica");
	}

}
