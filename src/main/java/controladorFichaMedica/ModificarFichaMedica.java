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
import validacion.MetodosValidacion;

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
		
		boolean modificarOk = false;
		boolean noEsTipoSangreMod = false;
		
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

				if(MetodosValidacion.esTipoSangre(fichaMedica.getTipoSangre()) == true) {
					mfm.modificar(fichaMedica);
					modificarOk = true;
				}else {
					noEsTipoSangreMod = true;
				}
				
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		request.setAttribute("noEsTipoSangreMod", noEsTipoSangreMod);
		request.setAttribute("modificarOk", modificarOk);
		request.getRequestDispatcher("IndexFichaMedica").forward(request, response);
	}

}
